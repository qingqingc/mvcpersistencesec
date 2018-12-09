package com.mvc.web;

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
import com.mvc.entities.Man;
import com.mvc.redis.RedisClientTemplate;
import com.mvc.service.ManService;

@Controller
public class ManController {
	private final static Logger log = LoggerFactory.getLogger(ManController.class);
	@Autowired
	private RedisClientTemplate redisClient;
//	@Autowired
//	private RedisClientTemplateIf redisClient;
	//redis test begin
	 /*@Autowired
	    protected RedisTemplate<Serializable, Serializable> redisTemplate;*/
	//redis test ended
	@Autowired
	private ManService manservice;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView enterInDockingPage() {
		Map<String, Man> m = new HashMap<String, Man>();
		Man man = new Man();
		man.setName("berryr");
		man.setRemark("good remark!");
		man.setSex("男");
		m.put("mankey", man);
		ModelAndView mav = new ModelAndView("test", m);
		log.info("enter in docking page.");
		return mav;
	}*/

	@RequestMapping(value = "/md", method = RequestMethod.POST)
	public ModelAndView kserMan(@RequestParam("name") String username, HttpServletRequest request) {
		Map<String, List<Man>> m = new HashMap<String, List<Man>>();
		ModelAndView mav = new ModelAndView("dock", m);
		manservice.getAllMan();
		log.info("Redirect dock page from request /md.");
		return mav;
	}

	@RequestMapping(value = "/mk", method = RequestMethod.GET)
	public ModelAndView reachInDockPage() {
		Map<String, List<Man>> m = new HashMap<String, List<Man>>();
		ModelAndView mav = new ModelAndView("dock", m);
		// get user's name
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			log.info(username);
		} else {
			username = principal.toString();
			log.info(username);
		}
		log.info("Redirect dock page from request /mk.");
		return mav;
	}

	@RequestMapping("loginSecurity")
	public String logink() {
		return "loginSecurity";
	}

	@RequestMapping(value = "/logink", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("loginB");
		//redis test begin
		/*redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection arg0) throws DataAccessException {
				arg0.set(redisTemplate.getStringSerializer().serialize("user.uid." + 2334),
                        redisTemplate.getStringSerializer().serialize("Berrrry"));
				U.p(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				return null;
			}
        });
		
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection arg0) throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize("user.uid." + 2334);
				if (arg0.exists(key)) {
					byte[] value = arg0.get(key);
                    String name = redisTemplate.getStringSerializer().deserialize(value);
                    U.p(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + name);
				}				
				return null;
			}
        });*/
		
//		 redisClient.set("a", "abcberry you are ok expired!");
//		 redisClient.set("ab", "ab==========================================");
//		for (int i = 0 ; i < 100; i++) {
//			redisClient.set("a" + i, "value" + i);
//		}
		/*for (int i = 0; i < 100;i++) {
			U.p(redisClient.get("a" + i));
		} 
		U.p("key akk " + redisClient.get("akk"));
		U.p("key akym " + redisClient.get("akym"));
		redisClient.append("k", " after append.");*/
		//redis test ended
		return model;

	}

	@RequestMapping(value = "/mj", method = RequestMethod.GET)
	public ModelAndView reachInDockPrevPage() {
		Map<String, List<Man>> m = new HashMap<String, List<Man>>();
		ModelAndView mav = new ModelAndView("dock", m);
		// get user's name
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			log.info(username);
		} else {
			username = principal.toString();
			log.info(username);
		}
		//
		manservice.getAllMan();
		return mav;
	}

	@RequestMapping(value = "/accessdeny", method = RequestMethod.GET)
	public ModelAndView accessdeny() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		ModelAndView mav = new ModelAndView("accessdeny");
		mav.addObject("u", username);
		log.info("the usser: " + username + "is denied by system!");
		return mav;
	}

	//@RequestMapping(value = "/internet/access", method = RequestMethod.GET)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView internetAccess() {
		ModelAndView mav = new ModelAndView("internetAccess");
		log.info("Test internet access.");
		return mav;
	}
	
	@RequestMapping("validateImage")
	public String validateImage() {
		log.info("Go validate photo code!");
		return "image";
	}
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST )
	public ModelAndView addRole(@ModelAttribute("user") Man user) throws UnsupportedEncodingException {
		Map<String, Man> m = new HashMap<String, Man>();
		Man man = new Man();
		man.setName(user.getName());
		man.setRemark(user.getRemark());
		String sex = new String(user.getSex().getBytes("ISO-8859-1"), "UTF-8");
		man.setSex(sex);
		
		m.put("mankey", man);
		ModelAndView mav = new ModelAndView("dock", m);
		log.info(sex + " sex");
		return mav;
	}
}
