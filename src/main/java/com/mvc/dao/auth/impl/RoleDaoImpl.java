package com.mvc.dao.auth.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.mvc.dao.BaseDao;
import com.mvc.dao.auth.RoleDao;
import com.mvc.dao.auth.UserDao;
import com.mvc.entities.TGroup;
import com.mvc.entities.TGroupRole;
import com.mvc.entities.TResource;
import com.mvc.entities.TRight;
import com.mvc.entities.TRightResource;
import com.mvc.entities.TRole;
import com.mvc.entities.TRole22;
import com.mvc.entities.TRoleRight;
import com.mvc.entities.TUserprofile;
import com.mvc.service.UsrSer;
import com.mvc.utilities.U;

@Component
@Transactional
// public class RoleDaoImpl extends BaseDao implements RoleDao {
public class RoleDaoImpl extends BaseDao implements RoleDao {

	@Autowired
	private UsrSer usrSer;
	/*
	 * @PersistenceContext//(unitName = "jpaDemo1") private EntityManager em;
	 * 
	 * public EntityManager getEm() { return
	 * em;//.getEntityManagerFactory().createEntityManager(); }
	 * 
	 * public void setEm(EntityManager em) { em = em; }
	 */
	@Autowired
	private UserDao userDao;

	@Override
	public void saveRole(TRole r, String str) {
		List<TResource> resLst = findResources(str);
		getEm().persist(r);
		for (TResource tr : resLst) {
			List<TRightResource> rsLst = tr.getTRightResources();
			TRoleRight rr = new TRoleRight();
			for (TRightResource rightR : rsLst) {
				rr.setTRight2(rightR.getTRight2());// one right just only belong
													// one resource.
			}
			rr.setTRole2(r);
			getEm().persist(rr);
		}
	}

	@Override
	/*
	 * @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	 */
	public void saveRole2(TRole22 r) {
		// getEm().getTransaction().begin();
		getEm().persist(r);
		// getEm().merge(r);
		// getEm().getTransaction().commit();
	}

	@Override
	public List<TRole> findRoles(String sqlStr) {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_ROLE e where e.id in (" + sqlStr + ")")
				.getResultList();
		List<TRole> rltLst = new ArrayList<TRole>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TRole) {
					rltLst.add((TRole) o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public List<TRole> findAllRoles() {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_ROLE e ").getResultList();
		List<TRole> rltLst = new ArrayList<TRole>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TRole) {
					rltLst.add((TRole) o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public void saveResource(TResource r) {
		getEm().persist(r);
		/* getEm().refresh(r); */
		getEm().flush();
		TRight rht = new TRight();
		Date d = new Date();
		rht.setName("ROLE_" + String.valueOf(d.getTime()));
		getEm().persist(rht);
		/* getEm().refresh(rht); */
		getEm().flush();
		TRightResource tr = new TRightResource();
		tr.setTRight2(rht);
		tr.setTResource2(r);
		getEm().persist(tr);
		/* getEm().refresh(tr); */
		getEm().flush();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		TUserprofile up = userDao.getUser(username);
		List<TGroupRole> grLstr = up.getTUserprofileGroups().get(0).getTGroup().getTGroupRoles();
		for (TGroupRole gr : grLstr) {
			TRole trle = gr.getTRole2();
			TRoleRight rr = new TRoleRight();
			rr.setTRight2(rht);
			rr.setTRole2(trle);
			getEm().persist(rr);
			/* getEm().refresh(rr); */
			getEm().flush();
		}
	}

	@Override
	public List<TResource> findResources() {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_RESOURCE e").getResultList();
		List<TResource> rltLst = new ArrayList<TResource>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TResource) {
					rltLst.add((TResource) o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public List<TResource> findResources(String str) {
		List<?> roleList = getEm().createQuery("SELECT OBJECT(e) FROM T_RESOURCE e where e.id in (" + str + ")")
				.getResultList();
		List<TResource> rltLst = new ArrayList<TResource>();
		if (roleList != null) {
			for (Object o : roleList) {
				if (o instanceof TResource) {
					rltLst.add((TResource) o);
				}
			}
		}
		return rltLst;
	}

	@Override
	public TResource updateResource(TResource r) {
		Query query = getEm().createQuery("select p from T_RESOURCE p where p.id=?1 ");
		query.setParameter(1,r.getId());
		TResource tp = (TResource)query.getSingleResult();
		tp.setName(r.getName());
		tp = getEm().merge(tp);
		return tp;
	}
	
	public static void main(String[] args) {
		Date d = new Date();
		U.p(d.getTime());
	}

	@Override
	public void deleteResource(TResource r) {
		TResource rr = getEm().find(TResource.class, r.getId());
		Query query = getEm().createQuery("select p from T_RIGHT_RESOURCE p where p.TResource2.id=?1 ");
		query.setParameter(1,r.getId());
		TRightResource tp = (TRightResource)query.getSingleResult();
		TRight right = tp.getTRight2();
		getEm().remove(tp);
		getEm().remove(rr);
		
		Query query2 = getEm().createQuery("select p from T_ROLE_RIGHT p where p.TRight2.id=?1 ");
		query2.setParameter(1,right.getId());
		TRoleRight tp2 = (TRoleRight)query2.getSingleResult();
		getEm().remove(tp2);
		getEm().remove(right);
		
		 
	}
}
