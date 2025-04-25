package com.pikecape.springboot.retry.service;

import com.pikecape.springboot.retry.model.Duck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class DuckService {
  @Retryable(
    retryFor = {ResponseStatusException.class},
    maxAttemptsExpression = "5",
    backoff = @Backoff(delayExpression = "1000")
  )
  public Duck getDuck(String uid) {
    log.info("getDuck");
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Duck " + uid + " not found");
  }
}
