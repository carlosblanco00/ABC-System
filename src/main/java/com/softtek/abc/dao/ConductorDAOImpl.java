package com.softtek.abc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.softtek.abc.entity.ConductorEntity;
import com.softtek.abc.util.EntityManagerUtil;

@Stateless
public class ConductorDAOImpl implements ConductorDAO{
	
	private final EntityManager em = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<ConductorEntity> findAllConductorEntity() {
		return  em.createNamedQuery("Conductor.findAll").getResultList();
	}

	@Override
	public void insertConductorEntity(ConductorEntity conductor) {
		em.getTransaction().begin();
		em.persist(conductor);
		em.getTransaction().commit();
		
	}

	@Override
	public void updateConductorEntity(ConductorEntity conductor) {
		em.getTransaction().begin();
		em.merge(conductor);
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteConductorEntity(ConductorEntity conductor) {
		em.getTransaction().begin();
		em.remove(em.merge(conductor));
		em.getTransaction().commit();
	}

}
