package com.mvc.dao.auth;

import java.util.List;
import com.mvc.entities.TResource;
import com.mvc.entities.TRight;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TUserprofile;

public interface UserDao {
	public List<TUserprofile> getAllUser();
	public TUserprofile getUser(Long id);
	public TUserprofile getUser(String name);
	public List<TResource>  getResource();
	public List<TRightResource> getResource(String str);
	public boolean saveUser(TUserprofile usr, String str);
	public List<TUserprofile> findUsers();
	public List<TRight> getUserRight(String userName);
}