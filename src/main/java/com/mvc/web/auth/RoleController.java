package com.mvc.web.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.common.Constants;
import com.mvc.entities.Man;
import com.mvc.entities.TResource;
import com.mvc.entities.TRight;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TRole;
import com.mvc.entities.TRole22;
import com.mvc.entities.TRoleRight;
import com.mvc.entities.TUserprofile;
import com.mvc.redis.RedisClientTemplate;
import com.mvc.service.ManService;
import com.mvc.service.auth.RoleService;
import com.mvc.utilities.U;

@Controller
@RequestMapping("/auth/role")
public class RoleController {
	private final static Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleservice;
	
	@Autowired
	private Constants rourcesConstants;
	
	@RequestMapping(value = "/addRole")
	public String addRole(HttpServletRequest request) {
		List<TResource> resourceLst = roleservice.findResources();
		/*for (TResource t : resourceLst) {
			List<TRightResource> trList = t.getTRightResources();
			for (TRightResource tr : trList) {
				TRight trg = tr.getTRight2();
				List<TRoleRight> rrLst = trg.getTRoleRights();
				for (TRoleRight rr : rrLst) {
					TRole role = rr.getTRole2();
				}
			}
 		}*/
		request.setAttribute("resourceLst", resourceLst);
		return "/auth/role/addrole";
	}
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST )
	public String saveRole(@ModelAttribute("role") TRole role, String resCheckbox) throws UnsupportedEncodingException {
		log.info("add role name : " + role.getName());
		roleservice.saveRole(role, resCheckbox);
		log.info("save successful!");
		return "redirect:/mk";
	}
	
	@RequestMapping(value = "findAllRoles")
	public String findAllRoles(HttpServletRequest request) {		
		List<TRole> rLst = roleservice.findAllRoles();
		request.setAttribute("roleLst", rLst);
		return "/auth/role/showRoles";
	}
	
	@RequestMapping(value = "/goAddResource")
	public String goResource() {	
		return "/auth/role/addResource";
	}
	
	@RequestMapping(value = "saveResource")
	public String saveResource(TResource r, HttpServletRequest request) {
		roleservice.saveResource(r);
		List<TResource> resLst = roleservice.findResources();
		request.setAttribute("resources", resLst);
		rourcesConstants.setResourceMap2();//For auth refresh.
		return "/auth/role/showResource";
	}
	
	@RequestMapping(value = "findAllResources")
	public String findResources(HttpServletRequest request) {
		List<TResource> resLst = roleservice.findResources();
		request.setAttribute("resources", resLst);
		return "/auth/role/showResource";
	}
	
	@RequestMapping(value = "updateResource")
	public String updateResource(HttpServletRequest request) {
		String[] s = request.getParameterValues("rowData[]");
		if (s != null && s.length > 1 && s[1] != null) {
			Long id = Long.valueOf(s[1]);
			TResource r = new TResource();
			r.setId(Long.valueOf(s[1]));
			r.setName(s[2]);
			roleservice.updateResource(r);
			rourcesConstants.setResourceMap2();//For auth refresh.
		}
		return "{\"result\": \"success\"}";
	}
	
	@RequestMapping(value = "deleteResource")
	public String deleteResource(HttpServletRequest request) {
		String[] s = request.getParameterValues("rowData[]");
		if (s != null && s.length > 1 && s[1] != null) {
			Long id = Long.valueOf(s[1]);
			TResource r = new TResource();
			r.setId(Long.valueOf(s[1]));
			r.setName(s[2]);//It need not.
			roleservice.deleteResource(r);
			rourcesConstants.setResourceMap2();//For auth refresh.
		}
		return "{\"result\": \"success\"}";
	}
}
