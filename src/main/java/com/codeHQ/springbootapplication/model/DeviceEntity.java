package com.codeHQ.springbootapplication.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DeviceDetailEntity> details;

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
}