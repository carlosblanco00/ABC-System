package com.softtek.abc.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.Stateless;

import com.softtek.abc.dao.ConductorVehiculoDAO;
import com.softtek.abc.dao.ConductorVehiculoDAOImpl;
import com.softtek.abc.entity.ConductorVehiculoEntity;
import com.softtek.abc.entity.CondutoresVehiculosKey;
import com.softtek.abc.entity.VehiculoEntity;

@Stateless
public class ConductorVehiculoEJBImpl implements ConductorVehiculoEJB{
	
	private ConductorVehiculoDAO conductorVehiculoDAO;
	
	public ConductorVehiculoEJBImpl() {
		// TODO Auto-generated constructor stub
		conductorVehiculoDAO = new ConductorVehiculoDAOImpl();
	}

	@Override
	public List<ConductorVehiculoEntity> listarConductorVehiculo() {
		
		List<ConductorVehiculoEntity> listVehiculoSinAsignar = new VehiculoEJBImpl().listarVehiculoSinAsignar().stream().map(v -> new ConductorVehiculoEntity(null, v)).collect(Collectors.toList()); 
		
		return Stream.concat(conductorVehiculoDAO.findAllConductorVehiculoEntity().stream(), listVehiculoSinAsignar.stream()).collect(Collectors.toList());
	}

	@Override
	public void registrarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		
		conductorVehiculo.setId(new CondutoresVehiculosKey(conductorVehiculo.getConductor().getIdConductor(), conductorVehiculo.getVehiculo().getIdVehiculo()));
		
		conductorVehiculoDAO.insertConductorVehiculoEntity(conductorVehiculo);
		
	}

	@Override
	public void modificarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		conductorVehiculoDAO.updateConductorVehiculoEntity(conductorVehiculo);
	}

	@Override
	public void eliminarConductorVehiculo(ConductorVehiculoEntity conductorVehiculo) {
		// TODO Auto-generated method stub
		conductorVehiculoDAO.deleteConductorVehiculoEntity(conductorVehiculo);
	}

}
