package com.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mvc.dao.auth.UserDao;
import com.mvc.entities.TResource;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TUserprofile;

@Component
public class UsrSerImpl implements UsrSer {
	@Autowired
	private UserDao mdao;
	@Override
	public TUserprofile getUser() {
		// TODO Auto-generated method stub
		List<TUserprofile> manList = mdao.getAllUser();
		return manList.get(0);
	}
	
	@Override
	public List<TResource> getResource() {
		// TODO Auto-generated method stub
		List<TResource> resList = mdao.getResource();
		return resList;
	}

	@Override
	public TUserprofile getUser(Long id) {
		return mdao.getUser(id);
	}

	@Override
	public TUserprofile getUser(String name) {
		// TODO Auto-generated method stub
		return mdao.getUser(name);
	}

	@Override
	public List<TRightResource> getResource(String str) {
		return mdao.getResource(str);
	}
}
