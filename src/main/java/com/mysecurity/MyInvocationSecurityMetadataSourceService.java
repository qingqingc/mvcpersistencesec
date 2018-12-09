package com.mysecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import com.mvc.common.Constants;
import com.mvc.entities.TResource;
import com.mvc.entities.TRight;
import com.mvc.entities.TRightResource;
import com.mvc.service.UsrSer;
import com.mvc.utilities.U;

/** */
/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * 
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
	private final static Logger log = LoggerFactory.getLogger(MyInvocationSecurityMetadataSourceService.class);
	@Autowired
	private Constants cst; 
	@Autowired
	private UsrSer usrSer;
	private Map<String, Collection<ConfigAttribute>> resourceMap2;

	/*private void loadResourceDefine() {
		resourceMap2 = new HashMap<String, Collection<ConfigAttribute>>();
		List<TResource> resLst = usrSer.getResource();
		for (TResource r : resLst) {
			Set<TRight> rgtSet = new HashSet<TRight>();
			List<TRightResource> resourceLst = r.getTRightResources();
			U.p(resourceLst.size() + "");
			if (resourceLst != null) {
				for (TRightResource rr : resourceLst) {
					rgtSet.add(rr.getTRight2());
				}
				Collection<ConfigAttribute> clst = new ArrayList<ConfigAttribute>();
				for (TRight tr : rgtSet) {
					ConfigAttribute aa = new SecurityConfig(tr.getName());
					clst.add(aa);
				}
				resourceMap2.put(r.getName(), clst);
			}
		}
	}*/

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	// 根据URL，找到相关的权限配置。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		resourceMap2 = cst.getResourceMap2();
		ConfigAttribute a = new SecurityConfig("ROLE_NONE_MATCH_ANYWAY");
		Collection<ConfigAttribute> rltmatch = new ArrayList<ConfigAttribute>();
		rltmatch.add(a);
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null && resourceMap2 == null) {
			log.info("Roles initilization,just only do once time, if more than one there is must a error.");
			/*loadResourceDefine();*/
			resourceMap2 = cst.setResourceMap2();
		}
		// object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();
		FilterInvocation filterInvocation = (FilterInvocation) object;
		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		Iterator<String> ite = resourceMap2.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
			if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
				Collection<ConfigAttribute> cc = resourceMap2.get(resURL);
				if (cc != null && cc.size() > 0) {
					rltmatch = resourceMap2.get(resURL);
					return rltmatch;
				} else {
					return rltmatch;
				}
			}
		}

		return rltmatch;
	}

	@Override
	public boolean supports(Class<?> arg0) {

		return true;
	}

	public static void main(String[] args) {
		PathMatcher matcher = new AntPathMatcher();

		// 完全路径匹配
		// String requestPath="/user/list.htm?username=aaa&id=2&no=1&page=20";
		// String patternPath="/user/list.htm**";

		// 不完整路径匹配
		// String requestPath="/app/pub/login.do";
		// String patternPath="/**/login.do";

		// 模糊路径匹配
		// String requestPath="/app/pub/login.do";
		// String patternPath="/**/*.do";

		// 模糊单字符路径匹配
		// String requestPath = "/app/pub/login.do";
		// String patternPath = "/**/lo?in.do";

		String requestPath = "/mk";
		String patternPath = "/";

		boolean result = matcher.match(patternPath, requestPath);
		log.info(result + "");
	}
}