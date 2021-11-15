package com.codeHQ.springbootapplication.service;

import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.dto.Request;
import com.codeHQ.springbootapplication.mapper.MapperObject;
import com.codeHQ.springbootapplication.model.DeviceEntity;
import com.codeHQ.springbootapplication.repository.DeviceRepository;
import com.codeHQ.springbootapplication.util.DateTimeUtil;

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
	public DeviceRequest getDeviceByDeviceId(Request request) {
		
		DeviceEntity deviceEntity = deviceRepository.findByDeviceId(request.getDeviceId());
		if(StringUtils.isNotBlank(request.getStartDate()) && StringUtils.isNotBlank(request.getEndDate())) {
			filterDeviceData(deviceEntity, request.getStartDate(), request.getEndDate());
		}
		return new MapperObject().mapperEntityToDto(deviceEntity, deviceEntity.getDetails());
	}

	private DeviceEntity filterDeviceData(DeviceEntity deviceEntity, String fromDate,
			String toDate) {
		Date startDate = DateTimeUtil.formatStringToDate(fromDate);
		Date endDate = DateTimeUtil.formatStringToDate(toDate);
		deviceEntity.setDetails(deviceEntity.getDetails().stream()
				.filter(x -> x.getTimestamp().after(startDate) && x.getTimestamp().before(endDate))
				.collect(Collectors.toSet()));
		return deviceEntity;
	}



}