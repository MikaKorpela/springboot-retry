package com.pikecape.springboot.retryable.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableRetry
class RetryableServiceTest {
  @Autowired
  private RetryableService retryableService;

  @TestConfiguration
  static class ContextConfiguration {
    @Bean
    public RetryableService retryableService() {
      return new RetryableService();
    }
  }

  @Test
  void testFoo() {
    assertThrows(RetryException.class, () -> retryableService.retryableMethod());
  }
}
