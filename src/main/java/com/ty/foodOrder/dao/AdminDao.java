package com.ty.foodOrder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.foodOrder.dto.Admin;


@Component
public class AdminDao {

	@Autowired
	EntityManagerFactory entityManagerFactory; 
	
	public void saveAdmin(Admin admin ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.persist(admin) ;
		entityTransaction.commit();
		
	}
	
	public boolean validateAdmin(String email ,String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		String sql = "SELECT a FROM Admin a WHERE a.email = ?1 AND a.password = ?2" ;
		Query  query = entityManager.createQuery(sql) ;
		query.setParameter(1, email) ;
		query.setParameter(2, password) ;
		
		if(query.getResultList().size() >= 0) {
			return true ;
		}else {
			return false ;
		}
	}
	

}
