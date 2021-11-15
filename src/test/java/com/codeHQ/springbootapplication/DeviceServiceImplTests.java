package com.codeHQ.springbootapplication;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeHQ.springbootapplication.dto.DeviceDetail;
import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.dto.Request;
import com.codeHQ.springbootapplication.model.DeviceDetailEntity;
import com.codeHQ.springbootapplication.model.DeviceEntity;
import com.codeHQ.springbootapplication.repository.DeviceRepository;
import com.codeHQ.springbootapplication.service.DeviceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceImplTests {

	@InjectMocks
	private DeviceServiceImpl deviceService;

	@Mock
	private DeviceRepository repository;

	@Mock
	private DeviceRequest deviceRequest;
	
	@MockBean
	private Request request;
	
	@Test
	public void testSaveOrUpdate() {
		deviceService.save(deviceRequest);
		verify(deviceRequest).getData();
	}
	
	@Test
	public void testGetDeviceByDeviceId() {
		DeviceEntity deviceEntity = createDeviceEntity();
		DeviceDetailEntity deviceDetailEntity = createDeviceDetailEntity();
		Set<DeviceDetailEntity> set = new HashSet<>();
		set.add(deviceDetailEntity);
		deviceEntity.setDetails(set);
		
		Mockito.when(request.getDeviceId()).thenReturn("123");
		Mockito.when(repository.findByDeviceId(Mockito.anyString())).thenReturn(deviceEntity);
		request.setDeviceId("123");
		DeviceRequest dto = deviceService.getDeviceByDeviceId(request);
		DeviceDetail detailDto = dto.getData().get(0);
		assertEquals(deviceEntity.getDeviceId(), dto.getDeviceId());
		assertEquals(String.valueOf(deviceEntity.getLatitude()), String.valueOf(dto.getLatitude()));
		assertEquals(String.valueOf(deviceEntity.getLongitude()), String.valueOf(dto.getLongitude()));
		
		assertEquals(deviceDetailEntity.getHumidity(), detailDto.getHumidity());
		assertEquals(deviceDetailEntity.getUnit(), detailDto.getTemperature().getUnit());
		assertEquals(deviceDetailEntity.getValue(), detailDto.getTemperature().getValue());
	}
	
	private DeviceEntity createDeviceEntity() {
		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setDeviceId("123");
		deviceEntity.setLatitude(12);
		deviceEntity.setLongitude(34);
		return deviceEntity;
	}
	
	private DeviceDetailEntity createDeviceDetailEntity() {
		DeviceDetailEntity detailEntity = new DeviceDetailEntity();
		detailEntity.setHumidity(10);
		detailEntity.setUnit("C");
		detailEntity.setValue("30.3");
		return detailEntity;
	}

}





