package com.pikecape.springboot.retryable.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pikecape.springboot.retryable.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableRetry
class RecoverableServiceTest {
  @Autowired
  private RecoverableService recoverableService;

  @TestConfiguration
  static class ContextConfiguration {
    @Bean
    public RecoverableService recoverableService() {
      return new RecoverableService();
    }
  }

  @Test
  void testFoo() {
    assertThrows(BadRequestException.class, () -> recoverableService.recoverableMethod());
  }
}
