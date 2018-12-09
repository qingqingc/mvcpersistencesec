package com.mvc.dao.auth.impl;

import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mvc.dao.BaseDao;
import com.mvc.dao.auth.GroupDao;
import com.mvc.dao.auth.UserDao;
import com.mvc.entities.TGroup;
import com.mvc.entities.TResource;
import com.mvc.entities.TRight;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TUserprofile;
import com.mvc.entities.TUserprofileGroup;
import com.mvc.utilities.U;

@Component
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Autowired
	private GroupDao gpDao;

	@Override
	public List<TUserprofile> getAllUser() {
		// TODO Auto-generated method stub
		String sqlstr = "SELECT  OBJECT(e) FROM T_USERPROFILE e, T_USERPROFILE_GROUP a, "
				+ "T_GROUP gp,T_ROLE c,T_GROUP_ROLE h, T_ROLE_RIGHT b,T_RIGHT g, "
				+ " T_RIGHT_RESOURCE d, T_RESOURCE f "
				+ "where a.TUserprofile=e and a.TGroup=gp "
				+ "  and gp=h.TGroup2 and h.TRole2=c and c=b.TRole2 "
				+ "and b.TRight2=g and d.TRight2=g and f=d.TResource2";
		List<TUserprofile> manList = getEm().createQuery(sqlstr)
				.getResultList();
		String str = "The container size is : ";
		if (manList != null) {
			str += manList.size();
			String sb = "";
			for (TUserprofile man : manList) {
				sb = " userprofile id : " + man.getId() + " userprofile Name:" + man.getName() + "userprofile Sex: " + man.getEmail();				
			}
			System.out.println(str + "-------------->  " + sb.toString());
		}
		return manList;
	}

	@Override
	public List<TResource> getResource() {
		String sqlstr = "SELECT  OBJECT(e) FROM T_RESOURCE e ";
		 List<TResource> resLst = getEm().createQuery(sqlstr)
				.getResultList();
		return resLst;
	}

	@Override
	public TUserprofile getUser(Long id) {
		// TODO Auto-generated method stub
		Query query = getEm().createQuery("select p from T_USERPROFILE p where p.id=?1 ");
		query.setParameter(1,id);
		TUserprofile tp = (TUserprofile)query.getSingleResult();
		return tp;
	}

	@Override
	public TUserprofile getUser(String name) {
		Query query = getEm().createQuery("select p from T_USERPROFILE p where p.name=?1 ");
		query.setParameter(1,name);
		TUserprofile tp = (TUserprofile)query.getSingleResult();
		return tp;
	}

	@Override
	public boolean saveUser(TUserprofile usr, String str) {
		getEm().persist(usr);
		List<TGroup> gLst = gpDao.findGroup(str);
		for (TGroup g : gLst) {
			TUserprofileGroup ug = new TUserprofileGroup();
			ug.setTGroup(g);
			ug.setTUserprofile(usr);
			getEm().persist(ug);
		}
		return true;
	}

	@Override
	public List<TUserprofile> findUsers() {
		String sqlstr = "SELECT OBJECT(e) FROM T_USERPROFILE e ";
		List<TUserprofile> resLst = getEm().createQuery(sqlstr)
				.getResultList();
		return resLst;
	}

	@Override
	public List<TRightResource> getResource(String str) {
		String sqlstr = "SELECT  OBJECT(d) FROM "
				+ " T_RIGHT_RESOURCE d, T_RESOURCE f "
				+ "where f=d.TResource2";
		 List<TRightResource> resLst = getEm().createQuery(sqlstr)
				.getResultList();
		return resLst;
	}

	@Override
	public List<TRight> getUserRight(String userName) {
		String sqlstr = "SELECT  OBJECT(g) FROM T_USERPROFILE e, T_USERPROFILE_GROUP a, "
				+ "T_GROUP gp,T_ROLE c,T_GROUP_ROLE h, T_ROLE_RIGHT b,T_RIGHT g, "
				+ " T_RIGHT_RESOURCE d, T_RESOURCE f "
				+ "where a.TUserprofile=e and a.TGroup=gp "
				+ "  and gp=h.TGroup2 and h.TRole2=c and c=b.TRole2 "
				+ "and b.TRight2=g and d.TRight2=g and f=d.TResource2 and e.name=?1";
		List<TRight> manList = getEm().createQuery(sqlstr).setParameter(1, userName).
				getResultList();
		return manList;
	}
}
