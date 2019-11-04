package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * SampleController
 */
public class SampleController {

  @RequestMapping("/sample")
  public String sample() {
    return "sample.html";
  }
}
