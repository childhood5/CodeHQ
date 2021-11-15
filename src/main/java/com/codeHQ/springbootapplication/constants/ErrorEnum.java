package com.codeHQ.springbootapplication.constants;

/**
 * List of all errors
 * 
 * @author tong
 */
public enum ErrorEnum {

	INVALID_DEVICEID("400", "Invalid deviceId"),
	INVALID_LATITUDE("401", "Invalid latitude"),
	INVALID_LONGITUDE("402", "Invalid longitude");

	private String code;
	
	private String message;

	/**
	 * Initial constructor of ErrorEnum
	 * 
	 * @param code
	 * @param message
	 */
	ErrorEnum(final String code, final String message) {
		this.code = code;
		this.message = message;
	}

	// Get code
	public String getCode() {
		return code;
	}

	// Set code
	public void setCode(String code) {
		this.code = code;
	}

	// Get message
	public String getMessage() {
		return message;
	}

	// Set message
	public void setMessage(String message) {
		this.message = message;
	}
}
