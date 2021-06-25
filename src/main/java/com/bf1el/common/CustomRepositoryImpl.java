package com.bf1el.common;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID>{
	
	//ovde ga pravimo da bi se automatski pravio za sve modele
	private final EntityManager entityManager;
	
	public CustomRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}
	
	//morali smo da ih implementiramo jer smo implentirali CustomRepository koji impl JpaRepository
	@Override
	public void refresh(T t) {
		entityManager.refresh(t);
		
	}
	
	// primer metoda iz JPA koju smo overridovali i napisali neku svoju logiku unutar metodinog tela
	@Override
	public void detach(T t) {
		entityManager.detach(t);
		
	}

	@Override
	public void clear() {
		entityManager.clear();
		
	}

}
