package com.pikecape.springboot.retry.service;

import com.pikecape.springboot.retry.exception.BadRequestException;
import com.pikecape.springboot.retry.model.Goose;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GooseService {
  @Retryable(
    retryFor = {RetryException.class},
    maxAttemptsExpression = "5",
    backoff = @Backoff(delayExpression = "1000")
  )
  public Goose getGoose(String uid) {
    throw new RetryException("Retry failed");
  }

  @Recover
  public Goose recoverRetryException(RetryException retryException) {
    throw new BadRequestException(retryException.getMessage());
  }
}
