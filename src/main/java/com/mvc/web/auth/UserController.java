package com.mvc.web.auth;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entities.TGroup;
import com.mvc.entities.TGroupRole;
import com.mvc.entities.TRole;
import com.mvc.entities.TUserprofile;
import com.mvc.service.auth.GroupService;
import com.mvc.service.auth.UserService;
import com.mvc.utilities.U;

@Controller
@RequestMapping("/auth/user")
public class UserController {
	
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/goAddUser")
	public String goAddUser(HttpServletRequest request) {
		List<TGroup> gpLst = userService.retrieveAllGroups();
		request.setAttribute("usrLst", gpLst);
		for (TGroup g : gpLst) {
			List<TGroupRole> ls = g.getTGroupRoles();
			for (TGroupRole tr : ls) {
				log.info(tr.getTRole2().getName());
			}
		}
		log.info("group list size is: " + gpLst.size());
		request.setAttribute("gpLst", gpLst);
		return "/auth/user/addUser";
	}
	
	@RequestMapping(value = "/saveUser")
	public String saveUser(TUserprofile user,String belongGroup) throws UnsupportedEncodingException {
		String gName = user.getName();
		log.info("the added user name is :u " +  user.getName() + "group id :" + belongGroup);
		
		userService.saveUser(user, belongGroup);
		log.info("save user successful!");
		return "redirect:/mk";
	}
	
	@RequestMapping(value = "findAllUser")
	public String findAllUser(HttpServletRequest request) {
		List<TUserprofile> usrs = userService.findUsers();
		request.setAttribute("usrs", usrs);
		return "/auth/user/showUsers";
	}
}
