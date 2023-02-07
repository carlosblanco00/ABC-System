package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Stateless;

import com.softtek.abc.dao.ConductorDAO;
import com.softtek.abc.dao.ConductorDAOImpl;
import com.softtek.abc.entity.ConductorEntity;

@Stateless
public class ConductorEJBImpl implements ConductorEJB{
	
	private ConductorDAO conductorDAO;
	
	public ConductorEJBImpl() {
		// TODO Auto-generated constructor stub
		this.conductorDAO = new ConductorDAOImpl();
	}

	@Override
	public List<ConductorEntity> listarConductor() {
		// TODO Auto-generated method stub
		return conductorDAO.findAllConductorEntity();
	}

	@Override
	public void registrarConductor(ConductorEntity conductor) {
		// TODO Auto-generated method stub
		conductorDAO.insertConductorEntity(conductor);
	}

	@Override
	public void modificarConductor(ConductorEntity conductor) {
		// TODO Auto-generated method stub
		conductorDAO.updateConductorEntity(conductor);
	}

	@Override
	public void eliminarConductor(ConductorEntity conductor) {
		// TODO Auto-generated method stub
		conductorDAO.deleteConductorEntity(conductor);
		
	}

}
