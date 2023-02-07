package com.softtek.abc.dao;

import java.util.List;

import com.softtek.abc.entity.ConductorVehiculoEntity;


public interface ConductorVehiculoDAO {
	
	public List<ConductorVehiculoEntity> findAllConductorVehiculoEntity();

	public void insertConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo);

	public void updateConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo);

	public void deleteConductorVehiculoEntity(ConductorVehiculoEntity conductorVehiculo);

}
