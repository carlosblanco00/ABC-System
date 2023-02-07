package com.softtek.abc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CondutoresVehiculosKey implements Serializable {
	
	private static final long serialVersionUID = 8742611451831395995L;

	@Column(name = "conductor_id")
    private Integer condutorId;

    @Column(name = "vehiculo_id")
    private Integer vehiculoId;
    
    public CondutoresVehiculosKey() {
		// TODO Auto-generated constructor stub
	}
    
	public CondutoresVehiculosKey(Integer condutorId, Integer vehiculoId) {
		super();
		this.condutorId = condutorId;
		this.vehiculoId = vehiculoId;
	}



	public Integer getCondutorId() {
		return condutorId;
	}

	public void setCondutorId(Integer condutorId) {
		this.condutorId = condutorId;
	}

	public Integer getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(Integer vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(condutorId, vehiculoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CondutoresVehiculosKey other = (CondutoresVehiculosKey) obj;
		return Objects.equals(condutorId, other.condutorId) && Objects.equals(vehiculoId, other.vehiculoId);
	}
    
	
    

}
