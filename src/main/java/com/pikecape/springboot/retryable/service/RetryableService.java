package com.pikecape.springboot.retryable.service;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryableService {
  @Retryable(
    retryFor = {RetryException.class},
    maxAttemptsExpression = "5",
    backoff = @Backoff(delayExpression = "1000")
  )
  public void retryableMethod() {
    log.info("Repeat start {}", Instant.now());
    throw new RetryException("Retry failed");
  }
}