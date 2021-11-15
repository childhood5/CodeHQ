package com.codeHQ.springbootapplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.codeHQ.springbootapplication.constants.RegexConstant;

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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
