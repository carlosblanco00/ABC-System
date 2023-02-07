package com.softtek.abc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Conductor")
@Table(name = "conductores")
@NamedQueries({ @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
		@NamedQuery(name = "Conductor.findByIdProveedor", query = "SELECT c FROM Conductor c WHERE c.provedor.id = :idProvedor"), })
public class ConductorEntity {

	@Id
	@Column(name = "id_conductor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConductor;

	@Column(name = "num_identificacion")
	private String numeroIdentificacion;

	private String nombre;

	@JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
	@ManyToOne(cascade = CascadeType.MERGE)
	private ProveedorEntity provedor;
	
	@OneToMany(mappedBy = "conductor", cascade = CascadeType.MERGE)
    Set<ConductorVehiculoEntity> vehiculos;

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProveedorEntity getProvedor() {
		return provedor;
	}

	public void setProvedor(ProveedorEntity provedor) {
		this.provedor = provedor;
	}

	public Set<ConductorVehiculoEntity> getVehiculosAsignados() {
		return vehiculos;
	}

	public void setVehiculosAsignados(Set<ConductorVehiculoEntity> vehiculosAsignados) {
		this.vehiculos = vehiculosAsignados;
	}
	
	

}
