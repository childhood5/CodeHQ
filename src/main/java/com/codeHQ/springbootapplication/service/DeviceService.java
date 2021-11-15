package com.codeHQ.springbootapplication.service;

import com.codeHQ.springbootapplication.dto.DeviceRequest;

/**
 * Define DeviceService
 * 
 * @author tong
 */
public interface DeviceService {
	
	//Getting a specific record by using the method getDeviceByDeviceId()
	public DeviceRequest getDeviceByDeviceId(String deviceId);
	
	//Saving a specific record by using the method save()
	public void save(DeviceRequest books);

}