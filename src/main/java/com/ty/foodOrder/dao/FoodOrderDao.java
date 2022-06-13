package com.ty.foodOrder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.foodOrder.dto.FoodOrder;

@Component
public class FoodOrderDao {

	@Autowired
	EntityManagerFactory entityManagerFactory ;
	
	public FoodOrder placeFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder ;
	}
	
	public List<FoodOrder> getAllFoodOrders(){
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		String sql = "SELECT o FROM FoodOrder o" ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
		
	}
	
	public FoodOrder viewFoodOrderById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		String sql = "SELECT o FROM FoodOrder o WHERE o.id = "+id ;
		Query query = entityManager.createQuery(sql) ;
		return (FoodOrder) query.getResultList().get(0) ;
	}
}
