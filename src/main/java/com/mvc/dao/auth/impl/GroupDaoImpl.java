package com.mvc.dao.auth.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mvc.dao.BaseDao;
import com.mvc.dao.auth.GroupDao;
import com.mvc.dao.auth.RoleDao;
import com.mvc.entities.TGroup;
import com.mvc.entities.TGroupRole;
import com.mvc.entities.TRole;

@Component
public class GroupDaoImpl extends BaseDao implements GroupDao {
	
	@Autowired
	private RoleDao rDao;
	
	@Override
	public boolean saveGroup(TGroup group, String rleCheckbox) {
		getEm().persist(group);
		List<TRole> rleList = rDao.findRoles(rleCheckbox);
		for (TRole role : rleList) {
			TGroupRole tg = new TGroupRole();
			tg.setTRole2(role);
			tg.setTGroup2(group);
			getEm().persist(tg);
		}
		return true;
	}

	@Override
	public List<TRole> retrieveAllRoles() {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_ROLE e")
				.getResultList();
		List<TRole> rltLst = new ArrayList<TRole>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TRole) {
					rltLst.add((TRole)o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public List<TGroup> retrieveAllGroups() {
		List<?> groupList = getEm().createQuery("SELECT OBJECT(e) FROM T_GROUP e")
				.getResultList();
		List<TGroup> rltLst = new ArrayList<TGroup>();
		if (groupList != null) {
			for (Object o : groupList) {
				if (o instanceof TGroup) {
					rltLst.add((TGroup)o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public List<TGroup> findGroup(String str) {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_GROUP e where e.id =" + str)
				.getResultList();
		List<TGroup> rltLst = new ArrayList<TGroup>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TGroup) {
					rltLst.add((TGroup)o);
				}
			}
		}
		return rltLst;
	}
}