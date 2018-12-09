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
import com.mvc.entities.TRole;
import com.mvc.service.auth.GroupService;
import com.mvc.utilities.U;

@Controller
@RequestMapping("/auth/group")
public class GroupController {
	
	private final static Logger log = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired
	private GroupService gpService;
	
	@RequestMapping(value = "/goAddGroup")
	public String goAddGroup(HttpServletRequest request) {
		List<TRole> gpLst = gpService.retrieveAllRoles();
		request.setAttribute("gpLst", gpLst);
		return "/auth/group/addGroup";
	}
	
	@RequestMapping(value = "/saveGroup")
	public String saveGroup(@ModelAttribute("group") TGroup group,String rleCheckbox) throws UnsupportedEncodingException {
		String gName = group.getName();
		log.info("the added group name is :u " +  group.getName());
		
		gpService.saveGroup(group, rleCheckbox);
		log.info("save group successful!");
		return "redirect:/mk";
	}
}
