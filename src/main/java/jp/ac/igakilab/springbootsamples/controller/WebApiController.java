package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WebApiController {
  @RequestMapping("hello")
  private String hello() {
    return "SpringBoot!";
  }
}
