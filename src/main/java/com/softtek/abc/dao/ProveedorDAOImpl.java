package com.softtek.abc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.softtek.abc.entity.ProveedorEntity;
import com.softtek.abc.util.EntityManagerUtil;

@Stateless
public class ProveedorDAOImpl implements ProveedorDAO{
	
    private EntityManager em = EntityManagerUtil.getEntityManager();
			
			
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorEntity> findAllProveedores() {
		List<ProveedorEntity> listaProveedores = new ArrayList<>();
		listaProveedores = em.createNamedQuery("Proveedor.findAll").getResultList();
		return listaProveedores;
	}
	
	@Override
	public ProveedorEntity findByIdProveedor(Integer id) {
		// TODO Auto-generated method stub
		return em.find(ProveedorEntity.class, id);
	}

	@Override
	public void insertProveedor(ProveedorEntity proveedor) {
		em.getTransaction().begin();
		em.persist(proveedor);
		em.getTransaction().commit();
	}

	@Override
	public void updateProveedor(ProveedorEntity proveedor) {
		em.getTransaction().begin();
		em.merge(proveedor);
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteProveedor(ProveedorEntity proveedor) {
		em.getTransaction().begin();
		em.remove(em.merge(proveedor));
		em.getTransaction().commit();
		
	}

	
}
