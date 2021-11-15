package com.codeHQ.springbootapplication.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This is DeviceDetail dto
 * 
 * @author tong
 *
 */
public class DeviceDetail {

	private int humidity;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date timestamp;
	
	private Temperature temperature;

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
}
