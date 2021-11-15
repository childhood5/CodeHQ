package com.codeHQ.springbootapplication.exception;

import com.codeHQ.springbootapplication.constants.ErrorEnum;

/**
 * This is InvalidLatitudeException class
 * 
 * @author tong
 *
 */
@ErrorCode(status = 401, code = ErrorEnum.INVALID_LATITUDE)
public class InvalidLatitudeException extends BaseException {

  public InvalidLatitudeException() {
    super(ErrorEnum.INVALID_LATITUDE.getMessage());
  }
}