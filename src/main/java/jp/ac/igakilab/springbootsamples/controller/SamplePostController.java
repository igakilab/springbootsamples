package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SamplePostController
 */
@Controller
@RequestMapping("/result")
public class SamplePostController {
  @PostMapping
  public String buyItem(@RequestParam("id") Integer id, ModelMap model) {
    model.addAttribute("id", id);
    return "result";
  }

  @RequestMapping
  public String showResult() {
    return "result";
  }

}
