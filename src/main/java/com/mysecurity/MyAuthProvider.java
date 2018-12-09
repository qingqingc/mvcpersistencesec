package com.mysecurity;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.mvc.entities.TGroupRole;
import com.mvc.entities.TRight;
import com.mvc.entities.TRoleRight;
import com.mvc.entities.TUserprofile;
import com.mvc.entities.TUserprofileGroup;
import com.mvc.service.UsrSer;
import com.mvc.service.auth.UserService;

public class MyAuthProvider implements UserDetailsService {
	private final static Logger logger = LoggerFactory.getLogger(MyAuthProvider.class);
	@Autowired
	private UsrSer userService;
	
	@Autowired
	private UserService userService1;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.trim().equalsIgnoreCase("")) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		TUserprofile usr;
		String password = "";
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
		if (username != null && !username.equals("")) {
			usr = userService.getUser(username);			
			if (usr != null) {
				password = usr.getPassword();
				List<TUserprofileGroup> tugLst = usr.getTUserprofileGroups();
				if (tugLst != null) {
					for (TUserprofileGroup rg : tugLst) {
						List<TGroupRole> grlst = rg.getTGroup().getTGroupRoles();
						if (grlst != null) {
							for (TGroupRole gr : grlst) {
								List<TRoleRight> rrLst = gr.getTRole2().getTRoleRights();
								if (rrLst != null) {
									for (TRoleRight tr : rrLst) {
										TRight right = tr.getTRight2();
										authList.add(new SimpleGrantedAuthority(right.getName()));
									}
								}
							}
						}
					}
				}
			}
		}
		List<TRight> rgtList = userService1.getUserRight(username);
		List<SimpleGrantedAuthority> authList2 = new ArrayList<SimpleGrantedAuthority>();
		for (TRight r : rgtList) {
			authList2.add(new SimpleGrantedAuthority(r.getName()));
		}
 		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		//////////////////////
		// List<SimpleGrantedAuthority> authList1 = new
		// ArrayList<SimpleGrantedAuthority>();
		// authList1.add(new SimpleGrantedAuthority("ROLE_NONE_MATCH_ANYWAY"));
//		User user = new User(username, encodedPassword, authList1);
		///////////////////////////
		User user = new User(username, encodedPassword, authList2);
		logger.info("login name is|" + username + ",password is|" + encodedPassword);
		return user;
	}

	public List<SimpleGrantedAuthority> loadUserRight() {
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();

		return authList;
	}
}
