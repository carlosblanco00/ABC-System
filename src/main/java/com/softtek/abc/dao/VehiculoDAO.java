package com.softtek.abc.dao;

import java.util.List;

import com.softtek.abc.entity.VehiculoEntity;


public interface VehiculoDAO {
	
	public List<VehiculoEntity> findAllVehiculoEntity();

	public void insertVehiculoEntity(VehiculoEntity vehiculo);

	public void updateVehiculoEntity(VehiculoEntity vehiculo);

	public void deleteVehiculoEntity(VehiculoEntity vehiculo);
	
	public List<VehiculoEntity> findByEstadoSinAsignarVehiculos();

}
