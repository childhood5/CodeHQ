package com.codeHQ.springbootapplication.exception;

import com.codeHQ.springbootapplication.constants.ErrorEnum;

/**
 * This is InvalidDeviceIdException class
 * 
 * @author tong
 */
@ErrorCode(status = 400, code = ErrorEnum.INVALID_DEVICEID)
public class InvalidDeviceIdException extends BaseException {

	public InvalidDeviceIdException() {
		super(ErrorEnum.INVALID_DEVICEID.getMessage());
	}
}