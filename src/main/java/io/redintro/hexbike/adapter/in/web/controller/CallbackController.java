package io.redintro.hexbike.adapter.in.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CallbackController {
  @GetMapping(value = "callbacks", produces = MediaType.APPLICATION_JSON_VALUE)
  public String index() {
    return "{\"message\":\"This is a callback from Hexbike\"}";
  }
}
