package com.mvc.testing;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import com.mvc.entities.Man;


public class Test {

	@PersistenceUnit
	protected EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Man p =  new Man();
		p.setId(23874L);
		p.setName("eclipselinkTheTesting");
		p.setRemark("inMaven");
		p.setSex(":>");
		em.persist(p);
		em.getTransaction().commit();  
		em.close();
	}
}
