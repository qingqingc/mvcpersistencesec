package com.mvc.dao.auth;

import java.util.List;
import com.mvc.entities.TGroup;
import com.mvc.entities.TRole;

public interface GroupDao {
	public boolean saveGroup(TGroup group, String str);
	public List<TRole> retrieveAllRoles();
	public List<TGroup> retrieveAllGroups();
	public List<TGroup> findGroup(String str);
}
