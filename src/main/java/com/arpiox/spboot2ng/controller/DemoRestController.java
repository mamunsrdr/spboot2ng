package com.arpiox.spboot2ng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

  @RequestMapping(value = "/greetings", method = RequestMethod.GET)
  public ResponseEntity<Map> greetings() {
    Map<String, String> greetings = new HashMap<>();
    greetings.put("message", "Hello angular 6");
    return new ResponseEntity<>(greetings, HttpStatus.OK);
  }
}
