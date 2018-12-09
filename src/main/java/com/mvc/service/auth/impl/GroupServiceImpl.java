package com.mvc.service.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.auth.GroupDao;
import com.mvc.entities.TGroup;
import com.mvc.entities.TRole;
import com.mvc.service.auth.GroupService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao gpDao;
	@Override
	public boolean saveGroup(TGroup g, String rleStr) {
		return gpDao.saveGroup(g, rleStr);
	}
	@Override
	public List<TRole> retrieveAllRoles() {		
		return gpDao.retrieveAllRoles();
	}
	@Override
	public List<TGroup> findGroup(String str) {
		return gpDao.findGroup(str);
	}
}
