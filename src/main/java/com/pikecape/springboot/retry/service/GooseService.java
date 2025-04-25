package com.pikecape.springboot.retry.service;

import com.pikecape.springboot.retry.exception.BadRequestException;
import com.pikecape.springboot.retry.model.Goose;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class GooseService {
  @Retryable(
    retryFor = {ResponseStatusException.class},
    maxAttemptsExpression = "5",
    backoff = @Backoff(delayExpression = "1000")
  )
  public Goose getGoose(String uid) {
    log.info("getDuck");
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Goose " + uid + " not found");
  }

  @Recover
  public Goose recoverRetryException(ResponseStatusException responseStatusException, String uid) {
    throw new BadRequestException("Failed to query goose " + uid, responseStatusException);
  }
}
