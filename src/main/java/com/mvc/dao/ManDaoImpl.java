package com.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mvc.entities.Man;

@Component
public class ManDaoImpl implements ManDao {
	private final static Logger log = LoggerFactory.getLogger(ManDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	public List<Man> getAllMan() {
		String name = "success";
		List<Man> rltLst = new ArrayList<Man>();
		List<?> manList = em.createQuery("SELECT OBJECT(e) FROM t_man e WHERE e.name = :projectName")
				.setParameter("projectName", name).getResultList();

		String str = "Retrieve all man from db is|";
		if (manList != null) {
			str += manList.size();
			String sb = "";
			for (Object o : manList) {
				if (o instanceof Man) {
					Man man = (Man)o;
					sb = " man id : " + man.getId() + " man Name:" + man.getName() + "man Sex: " + man.getSex() + "man Remark:" + man.getRemark();
					rltLst.add(man);
				}
			}
			log.info(str + sb.toString());
		}

		return rltLst;
	}
}