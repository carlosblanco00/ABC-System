package com.softtek.abc.service;

import java.util.List;

import javax.ejb.Stateless;

import com.softtek.abc.dao.ProveedorDAO;
import com.softtek.abc.dao.ProveedorDAOImpl;
import com.softtek.abc.entity.ProveedorEntity;

@Stateless
public class ProveedorEJBImpl implements ProvedorEJB{
	
	private ProveedorDAO proveedorDAO;
	
	public ProveedorEJBImpl() {
		proveedorDAO = new ProveedorDAOImpl();
	}

	@Override
	public List<ProveedorEntity> listarProveedor() {
		// TODO Auto-generated method stub
		return proveedorDAO.findAllProveedores();
	}

	@Override
	public void registrarProveedor(ProveedorEntity proveedor) {
		// TODO Auto-generated method stub
		proveedorDAO.insertProveedor(proveedor);
	}

	@Override
	public void modificarProveedor(ProveedorEntity proveedor) {
		// TODO Auto-generated method stub
		proveedorDAO.updateProveedor(proveedor);
	}

	@Override
	public void eliminarProveedor(ProveedorEntity proveedor) {
		// TODO Auto-generated method stub
		proveedorDAO.deleteProveedor(proveedor);
	}

	@Override
	public ProveedorEntity buscarbProveedorPorID(Integer id) {
		// TODO Auto-generated method stub
		return proveedorDAO.findByIdProveedor(id);
	}

}
