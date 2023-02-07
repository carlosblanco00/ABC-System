package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Local;

import com.softtek.abc.entity.ConductorVehiculoEntity;

@Local
public interface ConductorVehiculoEJB {
	
	public List<ConductorVehiculoEntity> listarConductorVehiculo();

	public void registrarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo);

	public void modificarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo);

	public void eliminarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo);
}
