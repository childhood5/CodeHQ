package com.codeHQ.springbootapplication.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codeHQ.springbootapplication.dto.DeviceDetail;
import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.dto.Temperature;
import com.codeHQ.springbootapplication.model.DeviceDetailEntity;
import com.codeHQ.springbootapplication.model.DeviceEntity;

/**
 * This is MapperObject class to mapper object
 * 
 * @author tong
 *
 */
public class MapperObject {

	/**
	 * Mapper from dto to entity
	 * 
	 * @param dto
	 * @return a DeviceEntity
	 */
	public DeviceEntity mapperDtoToEntity(DeviceRequest dto) {

		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setDeviceId(dto.getDeviceId());
		deviceEntity.setLatitude(dto.getLatitude());
		deviceEntity.setLongitude(dto.getLongitude());

		Set<DeviceDetailEntity> details = new HashSet<>();
		List<DeviceDetail> deviceDetailDto = dto.getData();
		for (DeviceDetail detail : deviceDetailDto) {
			DeviceDetailEntity entity = new DeviceDetailEntity();
			entity.setHumidity(detail.getHumidity());
			entity.setUnit(detail.getTemperature().getUnit());
			entity.setValue(detail.getTemperature().getValue());
			entity.setTimestamp(new Date());
			entity.setDeviceId(deviceEntity);
			details.add(entity);
		}
		deviceEntity.setDetails(details);
		return deviceEntity;
	}

	/**
	 * Mapper from entity to dto
	 * 
	 * @param deviceEntity
	 * @param detailDeviceEntity
	 * @return DeviceRequest dto
	 */
	public DeviceRequest mapperEntityToDto(DeviceEntity deviceEntity, Set<DeviceDetailEntity> detailDeviceEntity) {

		DeviceRequest deviceRequest = new DeviceRequest();
		deviceRequest.setDeviceId(deviceEntity.getDeviceId());
		deviceRequest.setLatitude(deviceEntity.getLatitude());
		deviceRequest.setLongitude(deviceEntity.getLongitude());

		List<DeviceDetail> listDeviceDetail = new ArrayList<>();
		for (DeviceDetailEntity entity : detailDeviceEntity) {
			DeviceDetail detail = new DeviceDetail();
			Temperature temperature = new Temperature();
			temperature.setUnit(entity.getUnit());
			temperature.setValue(entity.getValue());
			detail.setHumidity(entity.getHumidity());
			detail.setTemperature(temperature);
			detail.setTimestamp(entity.getTimestamp());
			listDeviceDetail.add(detail);
		}
		deviceRequest.setData(listDeviceDetail);
		return deviceRequest;
	}
	

}