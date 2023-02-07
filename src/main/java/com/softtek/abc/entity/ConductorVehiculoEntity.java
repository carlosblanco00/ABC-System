package com.softtek.abc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "ConductorVehiculo")
@Table(name = "conductores_vehiculos")
@NamedQueries({ @NamedQuery(name = "ConductorVehiculo.findAll", query = "SELECT cv FROM ConductorVehiculo cv") })
public class ConductorVehiculoEntity {
	
	@EmbeddedId
	private CondutoresVehiculosKey id;
	
//	@Transient
	@ManyToOne
    @MapsId("condutorId")
    @JoinColumn(name = "conductor_id")
    private ConductorEntity conductor;
	
//	@Transient
	@ManyToOne
    @MapsId("vehiculoId")
    @JoinColumn(name = "vehiculo_id")
    private VehiculoEntity vehiculo;
	
	public ConductorVehiculoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ConductorVehiculoEntity(ConductorEntity conductor, VehiculoEntity vehiculo) {
		this.conductor = conductor;
		this.vehiculo = vehiculo;
	}



	public CondutoresVehiculosKey getId() {
		return id;
	}

	public void setId(CondutoresVehiculosKey id) {
		this.id = id;
	}

	public ConductorEntity getConductor() {
		return conductor;
	}

	public void setConductor(ConductorEntity conductor) {
		this.conductor = conductor;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	

}
