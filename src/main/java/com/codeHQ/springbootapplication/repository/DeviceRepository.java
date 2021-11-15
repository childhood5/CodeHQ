package com.codeHQ.springbootapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.codeHQ.springbootapplication.model.DeviceEntity;

/**
 * Here is an DeviceRepository interface
 * 
 * @author tong
 */
public interface DeviceRepository extends CrudRepository<DeviceEntity, String> {

	DeviceEntity findByDeviceId(final String deviceId);

}
