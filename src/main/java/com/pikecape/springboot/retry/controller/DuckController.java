package com.pikecape.springboot.retry.controller;

import com.pikecape.springboot.retry.model.Duck;
import com.pikecape.springboot.retry.service.DuckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ducks")
@RequiredArgsConstructor
public class DuckController {
  private final DuckService duckService;

  @GetMapping("/{uid}")
  public Duck getDuck(@PathVariable String uid) {
    return duckService.getDuck(uid);
  }

}
