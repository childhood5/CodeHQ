package com.codeHQ.springbootapplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.codeHQ.springbootapplication.constants.RegexConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This is Request dto
 * 
 * @author tong
 *
 */
public class Request {

	// Validate deviceId
	@Pattern(regexp = RegexConstant.DEVICE_ID_PATTERN)
	@NotEmpty
	private String deviceId;
	
	@JsonIgnore
	private String startDate;
	
	@JsonIgnore
	private String endDate;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
