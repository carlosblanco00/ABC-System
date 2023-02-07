package com.softtek.abc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import com.softtek.abc.entity.ProveedorEntity;
import com.softtek.abc.service.ProvedorEJB;
import com.softtek.abc.service.ProveedorEJBImpl;

@ManagedBean(name = "proveedorMB")
@ViewScoped
public class ProveedorMB implements Serializable{
	
	
	private static final long serialVersionUID = -2716325062609370650L;

	private ProvedorEJB provedorEJB;
	
	private List<ProveedorEntity> listProvider;
	private List<ProveedorEntity> filteredProvider;
	private ProveedorEntity selectedProvider;
	
	
	public ProveedorMB() {
		
		this.provedorEJB = new ProveedorEJBImpl();
		this.selectedProvider = new ProveedorEntity();

		obtenerProvedores();
	}
	
	public void obtenerProvedores() {
		this.listProvider = provedorEJB.listarProveedor();
	}
	
	public void saveOrModifyProvider() {
		if(selectedProvider.getId() == null) {
			provedorEJB.registrarProveedor(selectedProvider);
			if(this.listProvider != null) {
				this.listProvider.add(selectedProvider);
			}else {
				this.listProvider = new ArrayList<>();
				this.listProvider.add(selectedProvider);
			}
		}else {
			provedorEJB.modificarProveedor(selectedProvider);
		}
		
		resetSelectedProvider();
		
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('manageProviderDialog').hide()");
	}
	
	public void deleteProvider() {
		System.out.println("provider to delete ->" + this.selectedProvider.getNombre());
		provedorEJB.eliminarProveedor(this.selectedProvider);
		this.listProvider.remove(this.selectedProvider);
		resetSelectedProvider();
	}
	
	public void resetSelectedProvider(){
		this.selectedProvider = new ProveedorEntity();
	}

	public List<ProveedorEntity> getListProvider() {
		return listProvider;
	}

	public void setListProvider(List<ProveedorEntity> listProvider) {
		this.listProvider = listProvider;
	}

	public List<ProveedorEntity> getFilteredProvider() {
		return filteredProvider;
	}

	public void setFilteredProvider(List<ProveedorEntity> filteredProvider) {
		this.filteredProvider = filteredProvider;
	}

	public ProveedorEntity getSelectedProvider() {
		return selectedProvider;
	}

	public void setSelectedProvider(ProveedorEntity selectedProvider) {
		this.selectedProvider = selectedProvider;
	}
	
	
	
	
	

}
