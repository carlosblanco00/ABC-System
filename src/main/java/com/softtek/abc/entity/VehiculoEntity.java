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

import com.softtek.abc.util.EstadoVehiculoEnum;

@Entity(name = "Vehiculo")
@Table(name = "vehiculos")
@NamedQueries({ @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
				@NamedQuery(name = "Vehiculo.findByIdProveedor", query = "SELECT v FROM Vehiculo v WHERE v.provedor.id = :idProvedor")})
public class VehiculoEntity {

	@Id
	@Column(name = "id_vehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehiculo;

	private String placa;

	private String marca;

	private String modelo;

	private String estado;

	@JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(cascade = CascadeType.MERGE)
	private ProveedorEntity provedor;
	
	@OneToMany(mappedBy = "vehiculo", cascade = CascadeType.MERGE)
    Set<ConductorVehiculoEntity> conductores;

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProveedorEntity getProvedor() {
		return provedor;
	}

	public void setProvedor(ProveedorEntity provedor) {
		this.provedor = provedor;
	}

	public Set<ConductorVehiculoEntity> getConductor() {
		return conductores;
	}

	public void setConductor(Set<ConductorVehiculoEntity> conductor) {
		this.conductores = conductor;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
}
