package com.softtek.abc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.softtek.abc.dto.VehiculoCondutorFilterDTO;
import com.softtek.abc.entity.ConductorEntity;
import com.softtek.abc.entity.ConductorVehiculoEntity;
import com.softtek.abc.entity.ProveedorEntity;
import com.softtek.abc.entity.VehiculoEntity;
import com.softtek.abc.service.ConductorEJB;
import com.softtek.abc.service.ConductorEJBImpl;
import com.softtek.abc.service.ConductorVehiculoEJB;
import com.softtek.abc.service.ConductorVehiculoEJBImpl;
import com.softtek.abc.service.VehiculoEJB;
import com.softtek.abc.service.VehiculoEJBImpl;
import com.softtek.abc.util.EstadoVehiculoEnum;

@ManagedBean(name = "conductorVehiculoMB")
@ViewScoped
public class ConductorVehiculoMB implements Serializable {

	private static final long serialVersionUID = -8930326463908738346L;

	private ConductorVehiculoEJB conductorVehiculoEJB;

	private VehiculoEJB vehiculoEJB;

	private ConductorEJB conductorEJB;

	private VehiculoCondutorFilterDTO vehiculoCondutorFilter;

	private List<ConductorVehiculoEntity> listConductorVehiculo;

	private List<ConductorVehiculoEntity> filteredConductorVehiculo;

	private List<ConductorEntity> listConductor;

	private List<ConductorEntity> filteredConductor;

	private VehiculoEntity vehiculoEntity;

	private ConductorEntity conductorEntity;

	private ConductorEntity selectedConductorEntity;

	private ConductorVehiculoEntity selectedConductorVehiculoEntity;
	
	private List<EstadoVehiculoEnum> estadosVehiculo = Arrays.asList(EstadoVehiculoEnum.DISPONIBLE,EstadoVehiculoEnum.OCUPADO,EstadoVehiculoEnum.SIN_ASIGNAR);

	public ConductorVehiculoMB() {
		// TODO Auto-generated constructor stub

		this.conductorVehiculoEJB = new ConductorVehiculoEJBImpl();
		this.vehiculoEJB = new VehiculoEJBImpl();
		this.conductorEJB = new ConductorEJBImpl();

		this.vehiculoCondutorFilter = new VehiculoCondutorFilterDTO();

		this.vehiculoEntity = new VehiculoEntity();
		this.vehiculoEntity.setProvedor(new ProveedorEntity());

		this.conductorEntity = new ConductorEntity();
		this.conductorEntity.setProvedor(new ProveedorEntity());

		buscarConductores();
	}

	public void buscarVehiculosCondutores() {
		System.out.println("busqueda filtro -> " + vehiculoCondutorFilter.getIdProveedor()
				+ vehiculoCondutorFilter.getPlaca() + vehiculoCondutorFilter.getNumIdentConductor());
		this.listConductorVehiculo = this.conductorVehiculoEJB.listarConductorVehiculo();

	}

	public void buscarConductores() {
		this.listConductor = this.conductorEJB.listarConductor();
	}

	public void saveVehicle() {
		if (this.vehiculoEntity.getIdVehiculo() == null) {
			this.vehiculoEntity.setEstado(EstadoVehiculoEnum.SIN_ASIGNAR.toString());
			this.vehiculoEJB.registrarVehiculo(this.vehiculoEntity);
			if (this.listConductorVehiculo != null) {
				this.listConductorVehiculo.add(new ConductorVehiculoEntity(null, vehiculoEntity));
			} else {
				this.listConductorVehiculo = new ArrayList<>();
				this.listConductorVehiculo.add(new ConductorVehiculoEntity(null, vehiculoEntity));
			}
		} else {
			this.vehiculoEJB.modificarVehiculo(vehiculoEntity);
//			this.listConductorVehiculo.stream()
//					.filter(x -> x.getVehiculo().getIdVehiculo() == vehiculoEntity.getIdVehiculo())
//					.forEach(x -> x.setVehiculo(vehiculoEntity));
		}

	}

	public void saveDriver() {

		if (this.conductorEntity.getIdConductor() == null) {
			this.conductorEJB.registrarConductor(conductorEntity);
			if (this.listConductor != null) {
				this.listConductor.add(conductorEntity);
			} else {
				this.listConductor = new ArrayList<>();
				this.listConductor.add(conductorEntity);
			}
		} else {
			this.conductorEJB.modificarConductor(conductorEntity);
		}

		this.selectedConductorEntity = conductorEntity;
		resetConductorEntity();

	}

	public void deleteDriver() {
		this.conductorEJB.eliminarConductor(conductorEntity);

		this.listConductor.remove(conductorEntity);

	}
	
	public void deleteConductorVehiculo() {
		
		ConductorVehiculoEntity conductoreVehiculoDelete =  this.listConductorVehiculo.stream().filter(x -> x.getVehiculo().getIdVehiculo() == this.vehiculoEntity.getIdVehiculo()).collect(Collectors.toList()).get(0);
		
		this.conductorVehiculoEJB.eliminarConductorVehiculo( conductoreVehiculoDelete);
		
		conductoreVehiculoDelete.setConductor(null);
		this.vehiculoEntity.setEstado(EstadoVehiculoEnum.SIN_ASIGNAR.toString());
		this.vehiculoEJB.modificarVehiculo(this.vehiculoEntity);
		
		
	}
	
	public void deleteVehicule() {
		
		if(this.listConductorVehiculo.stream().allMatch(x -> x.getVehiculo().getIdVehiculo() == this.vehiculoEntity.getIdVehiculo() && x.getConductor() != null)) {
			deleteConductorVehiculo();
		}
		
		//this.vehiculoEntity.setConductor(new HashSet<>());
		
		this.vehiculoEJB.eliminarVehiculo(vehiculoEntity);
		this.listConductorVehiculo.remove(this.listConductorVehiculo.stream().filter(x -> x.getVehiculo().getIdVehiculo() == this.vehiculoEntity.getIdVehiculo()).collect(Collectors.toList()).get(0));
		
		resetVehiculoEntit();
		
	}

	public void resetVehiculoEntit() {
		this.vehiculoEntity = new VehiculoEntity();
		this.vehiculoEntity.setProvedor(new ProveedorEntity());
	}

	public void resetConductorEntity() {
		this.conductorEntity = new ConductorEntity();
		this.conductorEntity.setProvedor(new ProveedorEntity());
	}

	public void assignDriverToVehicle() {
		System.out.println("asiganar condutor -> " + selectedConductorEntity.getNombre() + " al vehiculo -> "
				+ selectedConductorVehiculoEntity.getVehiculo().getPlaca());
		selectedConductorVehiculoEntity.setConductor(selectedConductorEntity);
		selectedConductorVehiculoEntity.getVehiculo().setEstado(EstadoVehiculoEnum.DISPONIBLE.toString());
		actualizarEstadoVehiculoDisponible();
		this.conductorVehiculoEJB.registrarConductorVehiculo(selectedConductorVehiculoEntity);
	}

	private void actualizarEstadoVehiculoDisponible() {

		vehiculoEJB.modificarVehiculo(selectedConductorVehiculoEntity.getVehiculo());
	}

	public VehiculoCondutorFilterDTO getVehiculoCondutorFilter() {
		return vehiculoCondutorFilter;
	}

	public void setVehiculoCondutorFilter(VehiculoCondutorFilterDTO vehiculoCondutorFilter) {
		this.vehiculoCondutorFilter = vehiculoCondutorFilter;
	}

	public List<ConductorVehiculoEntity> getListConductorVehiculo() {
		return listConductorVehiculo;
	}

	public void setListConductorVehiculo(List<ConductorVehiculoEntity> listConductorVehiculo) {
		this.listConductorVehiculo = listConductorVehiculo;
	}

	public List<ConductorVehiculoEntity> getFilteredConductorVehiculo() {
		return filteredConductorVehiculo;
	}

	public void setFilteredConductorVehiculo(List<ConductorVehiculoEntity> filteredConductorVehiculo) {
		this.filteredConductorVehiculo = filteredConductorVehiculo;
	}

	public VehiculoEntity getVehiculoEntity() {
		return vehiculoEntity;
	}

	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculoEntity = vehiculoEntity;
	}

	public List<ConductorEntity> getListConductor() {
		return listConductor;
	}

	public void setListConductor(List<ConductorEntity> listConductor) {
		this.listConductor = listConductor;
	}

	public List<ConductorEntity> getFilteredConductor() {
		return filteredConductor;
	}

	public void setFilteredConductor(List<ConductorEntity> filteredConductor) {
		this.filteredConductor = filteredConductor;
	}

	public ConductorEntity getConductorEntity() {
		return conductorEntity;
	}

	public void setConductorEntity(ConductorEntity conductorEntity) {
		this.conductorEntity = conductorEntity;
	}

	public ConductorEntity getSelectedConductorEntity() {
		return selectedConductorEntity;
	}

	public void setSelectedConductorEntity(ConductorEntity selectedConductorEntity) {
		this.selectedConductorEntity = selectedConductorEntity;
	}

	public ConductorVehiculoEntity getSelectedConductorVehiculoEntity() {
		return selectedConductorVehiculoEntity;
	}

	public void setSelectedConductorVehiculoEntity(ConductorVehiculoEntity selectedConductorVehiculoEntity) {
		this.selectedConductorVehiculoEntity = selectedConductorVehiculoEntity;
	}

	public List<EstadoVehiculoEnum> getEstadosVehiculo() {
		return estadosVehiculo;
	}

	public void setEstadosVehiculo(List<EstadoVehiculoEnum> estadosVehiculo) {
		this.estadosVehiculo = estadosVehiculo;
	}

	
}
