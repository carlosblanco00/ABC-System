package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Local;

import com.softtek.abc.entity.ProveedorEntity;

@Local
public interface ProvedorEJB {
	
	public List<ProveedorEntity> listarProveedor();
	
	public ProveedorEntity buscarbProveedorPorID(Integer id);
	
	public void registrarProveedor(ProveedorEntity proveedor);

	public void modificarProveedor(ProveedorEntity proveedor);

	public void eliminarProveedor(ProveedorEntity proveedor);

}
