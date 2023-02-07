package com.softtek.abc.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.softtek.abc.entity.ConductorVehiculoEntity;
import com.softtek.abc.util.EntityManagerUtil;

@Stateless
public class ConductorVehiculoDAOImpl implements ConductorVehiculoDAO {

	private final EntityManager em = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<ConductorVehiculoEntity> findAllConductorVehiculoEntity() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ConductorVehiculo.findAll").getResultList();
	}

	@Override
	public void insertConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.createNativeQuery("INSERT INTO conductores_vehiculos (conductor_id, vehiculo_id, proveedor_id) VALUES (?,?,?)")
				.setParameter(1, conductorVehiculo.getConductor().getIdConductor())
				.setParameter(2, conductorVehiculo.getVehiculo().getIdVehiculo())
				.setParameter(3, conductorVehiculo.getVehiculo().getProvedor().getId()).executeUpdate();
		em.getTransaction().commit();

	}

	@Override
	public void updateConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(conductorVehiculo);
		em.getTransaction().commit();
	}

	@Override
	public void deleteConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.merge(conductorVehiculo));
		em.getTransaction().commit();

	}

}
