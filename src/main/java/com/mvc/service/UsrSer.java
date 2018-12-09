package com.mvc.service;

import java.util.List;
import com.mvc.entities.TResource;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TUserprofile;

public interface UsrSer {
	public TUserprofile getUser();
	public TUserprofile getUser(Long id);
	public TUserprofile getUser(String name);
	public List<TResource> getResource();
	public List<TRightResource> getResource(String str);
}
