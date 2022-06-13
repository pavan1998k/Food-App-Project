package com.ty.foodOrder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.foodOrder.dto.Products;

@Component
public class ProductDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public boolean saveProduct(Products product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (product != null) {
			entityTransaction.begin();
			entityManager.persist(product);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deletProduct(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Products products = entityManager.find(Products.class, id) ;
		if(products != null) {
			entityTransaction.begin();
			entityManager.remove(products);
			entityTransaction.commit();
			return true ;
		}else {
			return false ;
		}
	}
	
	public boolean updateProduct(int id ,Products products) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Products product = entityManager.find(Products.class, id) ;
		if(product != null) {
			entityTransaction.begin();
			entityManager.merge(products);
			entityTransaction.commit();
			return true ;
		}else {
			return false ;
		}
	}
	
	public List<Products> getAllProducts(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		String sql = "SELECT p FROM Products p " ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
	}
	
	public Products getProductById(int id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String sql = "SELECT p FROM Products p WHERE p.id = "+id ;
		Query query = entityManager.createQuery(sql) ;
		return (Products)query.getResultList().get(0) ;
	}
}
