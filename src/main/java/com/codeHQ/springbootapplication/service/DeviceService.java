package com.codeHQ.springbootapplication.service;

import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.dto.Request;

/**
 * Define DeviceService
 * 
 * @author tong
 */
public interface DeviceService {
	
	//Getting a specific record by using the method getDeviceByDeviceId()
	public DeviceRequest getDeviceByDeviceId(Request deviceId);
	
	//Saving a specific record by using the method save()
	public void save(DeviceRequest deviceRequest);

}