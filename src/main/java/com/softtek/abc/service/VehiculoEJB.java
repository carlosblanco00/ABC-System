package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Local;

import com.softtek.abc.entity.VehiculoEntity;

@Local
public interface VehiculoEJB {
	
	public List<VehiculoEntity> listarVehiculo();

	public void registrarVehiculo(VehiculoEntity vehiculo);

	public void modificarVehiculo(VehiculoEntity vehiculo);

	public void eliminarVehiculo(VehiculoEntity vehiculo);
	
	public List<VehiculoEntity> listarVehiculoSinAsignar();
}
