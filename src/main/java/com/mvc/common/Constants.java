package com.mvc.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import com.mvc.entities.TRightResource;
import com.mvc.service.UsrSer;

@Service
public class Constants {
	@Autowired
	private UsrSer usrSer;
	
	private Map<String, Collection<ConfigAttribute>> resourceMap2 = null;

	public Map<String, Collection<ConfigAttribute>> getResourceMap2() {
		return resourceMap2;
	}

	public Map<String, Collection<ConfigAttribute>> setResourceMap2() {
		loadResourceDefine();
		return resourceMap2;
	}

	private void loadResourceDefine() {
		resourceMap2 = new HashMap<String, Collection<ConfigAttribute>>();
		List<TRightResource> resourceLst = usrSer.getResource("");
		if (resourceLst != null) {
			for (TRightResource rr : resourceLst) {
				Collection<ConfigAttribute> clst = new ArrayList<ConfigAttribute>();
				ConfigAttribute aa = new SecurityConfig(rr.getTRight2().getName());
				clst.add(aa);
				resourceMap2.put(rr.getTResource2().getName(), clst);
			}
		}
	}
}
