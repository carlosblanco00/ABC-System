package com.softtek.abc.service;

import java.util.List;

import com.softtek.abc.dao.VehiculoDAO;
import com.softtek.abc.dao.VehiculosDAOImpl;
import com.softtek.abc.entity.VehiculoEntity;

public class VehiculoEJBImpl implements VehiculoEJB {
	
	private VehiculoDAO vehiculoDAO;
	
	public VehiculoEJBImpl() {
		// TODO Auto-generated constructor stub
		vehiculoDAO = new VehiculosDAOImpl();
	}

	@Override
	public List<VehiculoEntity> listarVehiculo() {
		// TODO Auto-generated method stub
		return vehiculoDAO.findAllVehiculoEntity();
	}

	@Override
	public void registrarVehiculo(VehiculoEntity vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAO.insertVehiculoEntity(vehiculo);
	}

	@Override
	public void modificarVehiculo(VehiculoEntity vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAO.updateVehiculoEntity(vehiculo);
	}

	@Override
	public void eliminarVehiculo(VehiculoEntity vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAO.deleteVehiculoEntity(vehiculo);
	}

	@Override
	public List<VehiculoEntity> listarVehiculoSinAsignar() {
		// TODO Auto-generated method stub
		return vehiculoDAO.findByEstadoSinAsignarVehiculos();
	}

}
