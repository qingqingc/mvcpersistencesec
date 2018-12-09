package com.mvc.service.auth;

import java.util.List;
import com.mvc.entities.TGroup;
import com.mvc.entities.TRole;

public interface GroupService {
	public boolean saveGroup(TGroup g, String str);
	public List<TRole> retrieveAllRoles();
	public List<TGroup> findGroup(String str);
}
