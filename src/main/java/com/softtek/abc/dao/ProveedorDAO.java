package com.softtek.abc.dao;

import java.util.List;

import com.softtek.abc.entity.ProveedorEntity;


public interface ProveedorDAO {

	public List<ProveedorEntity> findAllProveedores();
	
	public ProveedorEntity findByIdProveedor(Integer id);

	public void insertProveedor(ProveedorEntity proveedor);

	public void updateProveedor(ProveedorEntity proveedor);

	public void deleteProveedor(ProveedorEntity proveedor);

}
