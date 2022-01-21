package com.codeHQ.springbootapplication.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "device")
public class DeviceEntity {

	@Id
	@Column(name = "device_id")
	private String deviceId;

	@Column
	private double latitude;

	@Column
	private double longitude;

	@JsonIgnore
	@OneToMany(mappedBy = "deviceId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DeviceDetailEntity> details;
	
	@JsonIgnore
	@OneToOne(mappedBy = "data", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private OneToOneEntity data;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "manyEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ManyToManyEntity> manyEntity;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Set<DeviceDetailEntity> getDetails() {
		return details;
	}

	public void setDetails(Set<DeviceDetailEntity> details) {
		this.details = details;
	}

	public OneToOneEntity getData() {
		return data;
	}

	public void setData(OneToOneEntity data) {
		this.data = data;
	}

	public List<ManyToManyEntity> getManyEntity() {
		return manyEntity;
	}

	public void setManyEntity(List<ManyToManyEntity> manyEntity) {
		this.manyEntity = manyEntity;
	}
	
	
	
	
}