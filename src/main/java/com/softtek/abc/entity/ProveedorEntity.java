package com.softtek.abc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Proveedor")
@Table(name = "proveedores")
@NamedQueries({@NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class ProveedorEntity implements Serializable {

	private static final long serialVersionUID = 5127680519425135005L;
	
	@Id
	@Column(name = "id_proveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column(name = "num_identificacion")
	private String numeroIdentificacion;
	
	@Column
	private String direccion;
	
	@Column
	private String email;
	
	@Column(name = "num_vehic_disponibles")
	private Integer numeroVehiculosDisponibles;
	
	@OneToMany(mappedBy = "provedor", cascade = CascadeType.MERGE)
    private List<VehiculoEntity> vehiculos;
	
	@OneToMany(mappedBy = "provedor", cascade = CascadeType.MERGE)
    private List<ConductorEntity> conductores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroVehiculosDisponibles() {
		return numeroVehiculosDisponibles;
	}

	public void setNumeroVehiculosDisponibles(Integer numeroVehiculosDisponibles) {
		this.numeroVehiculosDisponibles = numeroVehiculosDisponibles;
	}

	public List<VehiculoEntity> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<VehiculoEntity> vehiculos) {
		this.vehiculos = vehiculos;
	} 

	public List<ConductorEntity> getConductores() {
		return conductores;
	}

	public void setConductores(List<ConductorEntity> conductores) {
		this.conductores = conductores;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion
				+ ", direccion=" + direccion + ", email=" + email + ", numeroVehiculosDisponibles="
				+ numeroVehiculosDisponibles + "]";
	} 
	
	
	

}
