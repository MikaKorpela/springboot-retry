package com.pikecape.springboot.retryable.exception;

public class RetryException extends RuntimeException{
  public RetryException(String message) {
    super(message);
  }
}
