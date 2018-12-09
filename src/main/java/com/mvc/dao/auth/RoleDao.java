package com.mvc.dao.auth;

import java.util.List;
import com.mvc.entities.TResource;
import com.mvc.entities.TRole;
import com.mvc.entities.TRole22;

public interface RoleDao {
	public void saveRole(TRole r, String str);
	public List<TRole> findRoles(String sqlStr);
	public List<TRole> findAllRoles();
	public void saveRole2(TRole22 r);
	public void saveResource(TResource r);
	public List<TResource> findResources();
	public List<TResource> findResources(String str);
	public TResource updateResource(TResource r);
	public void deleteResource(TResource r);
}
