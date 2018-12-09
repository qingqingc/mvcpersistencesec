package com.mvc.service.auth;

import java.util.List;
import com.mvc.entities.TGroup;
import com.mvc.entities.TRight;
import com.mvc.entities.TUserprofile;

public interface UserService {
	public boolean saveUser(TUserprofile g, String str);
	public List<TGroup> retrieveAllGroups();
	public List<TUserprofile> findUsers();
	public List<TRight> getUserRight(String userName);
}
