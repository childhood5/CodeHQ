package com.codeHQ.springbootapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.mapper.MapperObject;
import com.codeHQ.springbootapplication.model.DeviceEntity;
import com.codeHQ.springbootapplication.repository.DeviceRepository;

/**
 * Here is a DeviceServiceImpl class
 * 
 * @author tong
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	private DeviceRepository deviceRepository;

	@Autowired
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	// Saving a specific record by using the method save()
	public void save(DeviceRequest deviceRequest) {
		deviceRepository.save(new MapperObject().mapperDtoToEntity(deviceRequest));
	}
	

	// Getting a specific record by using the method getDeviceByDeviceId()
	public DeviceRequest getDeviceByDeviceId(String deviceId) {
		DeviceEntity  deviceEntity = deviceRepository.findByDeviceId(deviceId);
		return new MapperObject().mapperEntityToDto(deviceEntity, deviceEntity.getDetails());
	}

}