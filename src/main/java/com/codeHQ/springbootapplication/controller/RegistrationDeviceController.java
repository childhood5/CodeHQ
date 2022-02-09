package com.codeHQ.springbootapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeHQ.springbootapplication.dto.DeviceRequest;
import com.codeHQ.springbootapplication.dto.Request;
import com.codeHQ.springbootapplication.exception.ApiError;
import com.codeHQ.springbootapplication.service.DeviceService;
import com.codeHQ.springbootapplication.service.TestService;
import com.codeHQ.springbootapplication.util.ValidatorUtil;

/**
 * Here is RegistrationDeviceController 
 * 
 * @author tong
 *
 */

@RestController
@RequestMapping(value = "/api/devices", produces = { "application/json", "application/xml" })
public class RegistrationDeviceController {

	private DeviceService deviceService;
	
	private TestService test;

	
	@Autowired
	public RegistrationDeviceController(DeviceService deviceService, TestService test) {
		this.deviceService = deviceService;
		this.test = test;
	}

	/**
	 * Handle to store data to database
	 * 
	 * @param deviceRequest is request data
	 * @param result is a BindingResult
	 * @return a response data or error from server
	 */
	@PostMapping("/registration")
	public ResponseEntity<?> saveDevice(@RequestBody @Valid DeviceRequest deviceRequest, BindingResult result) {
		try {
			ValidatorUtil.validateRequest(result);
			deviceService.save(deviceRequest);
			return new ResponseEntity<>(deviceRequest, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
	
	/**
	 * Get information of device and detail
	 * 
	 * @param request is data from client
	 * @param result is a BindingResult
	 * @return information of device or error
	 */
	@GetMapping("/{deviceId}")
	public ResponseEntity<?> getDevice(@Valid Request request, BindingResult result) {
		try {
			ValidatorUtil.validateRequest(result);
			DeviceRequest dto = deviceService.getDeviceByDeviceId(request);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
	
	@PostMapping("/test")
	public ResponseEntity<?> insert(@Valid Request request, BindingResult result) {
		try {
			test.save(request);
			return new ResponseEntity<>(200, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}

}
