package com.codeHQ.springbootapplication;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codeHQ.springbootapplication.service.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationDeviceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DeviceService deviceService;

	@Test
	public void testGetDevice() throws Exception {
		mockMvc.perform(get("/api/devices/123")).andExpect(
				status().is2xxSuccessful());
	}

	@Test
	public void testSaveDevice() throws Exception {
		final String json = "{\"deviceId\":\"123\",\"latitude\": 123.4, \"longitude\": 120.9762, \"data\":[{ \"humidity\":123, \"temperature\":{ \n\"unit\":\"C\",\"value\":\"23.3\"}}]}";
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/api/devices/registration")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(json)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

}
