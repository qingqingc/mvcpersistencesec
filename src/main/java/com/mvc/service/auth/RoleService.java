package com.mvc.service.auth;

import java.util.List;

import com.mvc.entities.TResource;
import com.mvc.entities.TRole;
import com.mvc.entities.TRole22;

public interface RoleService {
	public void saveRole(TRole r, String str);
	public void saveRole22(TRole22 r);
	public List<TRole> findAllRoles();
	public void saveResource(TResource r);
	public List<TResource> findResources();
	public TResource updateResource(TResource r);
	public void deleteResource(TResource r);
}
