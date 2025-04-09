package com.pikecape.springboot.retry.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Goose {
  String uid;
  String name;
}
