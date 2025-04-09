package com.pikecape.springboot.retry.exception;

public class RetryException extends RuntimeException{
  public RetryException(String message) {
    super(message);
  }
}
