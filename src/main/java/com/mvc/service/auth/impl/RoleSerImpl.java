package com.mvc.service.auth.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mvc.dao.auth.RoleDao;
import com.mvc.entities.TResource;
import com.mvc.entities.TRole;
import com.mvc.entities.TRole22;
import com.mvc.service.auth.RoleService;

@Component
public class RoleSerImpl implements RoleService {
	@Autowired
	private RoleDao rdao;

	@Override
	public void saveRole(TRole r, String str) {
		rdao.saveRole(r, str);
	}
	
	@Override
	public void saveRole22(TRole22 r) {
		rdao.saveRole2(r);
	}
	
	@Override
	public List<TRole> findAllRoles() {
		return rdao.findAllRoles();
	}

	@Override
	public void saveResource(TResource r) {
		rdao.saveResource(r);
	}

	@Override
	public List<TResource> findResources() {
		return rdao.findResources();
	}

	@Override
	public TResource updateResource(TResource r) {
		return rdao.updateResource(r);
	}

	@Override
	public void deleteResource(TResource r) {
		rdao.deleteResource(r);
	}
}
