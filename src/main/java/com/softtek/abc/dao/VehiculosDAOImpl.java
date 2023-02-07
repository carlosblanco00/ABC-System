package com.softtek.abc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.softtek.abc.entity.VehiculoEntity;
import com.softtek.abc.util.EntityManagerUtil;
import com.softtek.abc.util.EstadoVehiculoEnum;

@Stateless
public class VehiculosDAOImpl implements VehiculoDAO{
	
	private EntityManager em = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiculoEntity> findAllVehiculoEntity() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Vehiculo.findAll").getResultList();
	}

	@Override
	public void insertVehiculoEntity(VehiculoEntity vehiculo) {
		try {
			em.getTransaction().begin();
			em.persist(vehiculo);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public void updateVehiculoEntity(VehiculoEntity vehiculo) {
		em.getTransaction().begin();
		em.merge(vehiculo);
		em.getTransaction().commit();
	}

	@Override
	public void deleteVehiculoEntity(VehiculoEntity vehiculo) {
		em.getTransaction().begin();
		em.remove(em.merge(vehiculo));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiculoEntity> findByEstadoSinAsignarVehiculos() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT v FROM Vehiculo v WHERE v.estado = '"+EstadoVehiculoEnum.SIN_ASIGNAR.toString()+"' ").getResultList();
	}

}
