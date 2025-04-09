package com.pikecape.springboot.retry.service;

import com.pikecape.springboot.retry.model.Duck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DuckService {
  @Retryable(
    retryFor = {RetryException.class},
    maxAttemptsExpression = "5",
    backoff = @Backoff(delayExpression = "1000")
  )
  public Duck getDuck(String uid) {
    throw new RetryException("Retry failed");
  }
}
