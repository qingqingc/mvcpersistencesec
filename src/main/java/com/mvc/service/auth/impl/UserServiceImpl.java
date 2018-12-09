package com.mvc.service.auth.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.auth.GroupDao;
import com.mvc.dao.auth.UserDao;
import com.mvc.entities.TGroup;
import com.mvc.entities.TRight;
import com.mvc.entities.TUserprofile;
import com.mvc.service.auth.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private GroupDao gpDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean saveUser(TUserprofile g, String str) {
		return userDao.saveUser(g, str);
	}

	@Override
	public List<TGroup> retrieveAllGroups() {
		return gpDao.retrieveAllGroups();
	}

	@Override
	public List<TUserprofile> findUsers() {
		// TODO Auto-generated method stub
		return userDao.findUsers();
	}

	@Override
	public List<TRight> getUserRight(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserRight(userName);
	}

}
