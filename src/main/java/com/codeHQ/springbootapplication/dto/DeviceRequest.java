package com.codeHQ.springbootapplication.dto;

import java.util.List;

import javax.validation.constraints.Digits;

/**
 * This is DeviceRequest dto
 * 
 * @author tong
 *
 */
public class DeviceRequest extends Request {

	// Validate of latitude
	@Digits(integer = 6, fraction = 6)
	private double latitude;

	// Validate of longitude
	@Digits(integer = 6, fraction = 6)
	private double longitude;

	private List<DeviceDetail> data;

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

	public List<DeviceDetail> getData() {
		return data;
	}

	public void setData(List<DeviceDetail> data) {
		this.data = data;
	}
}
