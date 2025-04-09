package com.pikecape.springboot.retry.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Duck {
  String uid;
  String name;
}
