package com.pikecape.springboot.retry.controller;

import com.pikecape.springboot.retry.model.Goose;
import com.pikecape.springboot.retry.service.GooseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gooses")
@RequiredArgsConstructor
public class GooseController {
  private final GooseService gooseService;

  @GetMapping("/{uid}")
  public Goose getGoose(@PathVariable String uid) {
    return gooseService.getGoose(uid);
  }
}
