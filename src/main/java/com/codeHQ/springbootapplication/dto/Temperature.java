package com.codeHQ.springbootapplication.dto;

/**
 * This is Temperature dto
 * 
 * @author tong
 *
 */
public class Temperature {

	private String unit;

	private String value;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
