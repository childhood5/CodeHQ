package com.codeHQ.springbootapplication.exception;

import com.codeHQ.springbootapplication.constants.ErrorEnum;

/**
 * This is InvalidLongitudeException class
 * 
 * @author tong
 */
@ErrorCode(status = 402, code = ErrorEnum.INVALID_LONGITUDE)
public class InvalidLongitudeException extends BaseException {

  public InvalidLongitudeException() {
    super(ErrorEnum.INVALID_LONGITUDE.getMessage());
  }
}