package com.softtek.abc.dao;

import java.util.List;

import com.softtek.abc.entity.ConductorEntity;


public interface ConductorDAO {
	
	public List<ConductorEntity> findAllConductorEntity();

	public void insertConductorEntity(ConductorEntity conductor);

	public void updateConductorEntity(ConductorEntity conductor);

	public void deleteConductorEntity(ConductorEntity conductor);
}
