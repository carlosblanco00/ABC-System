package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Local;

import com.softtek.abc.entity.ConductorEntity;

@Local
public interface ConductorEJB {

	public List<ConductorEntity> listarConductor();

	public void registrarConductor(ConductorEntity conductor);

	public void modificarConductor(ConductorEntity conductor);

	public void eliminarConductor(ConductorEntity conductor);
}
