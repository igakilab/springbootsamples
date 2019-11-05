package jp.ac.igakilab.springbootsamples.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

  /**
   *
   * @param model
   * @param principal ログインユーザ情報をもつ
   *                  参考：https://www.codeflow.site/ja/article/spring-security__get-current-logged-in-username-in-spring-security
   * @return
   */
  @RequestMapping("/hello")
  public String printWelcome(ModelMap model, Principal principal) {
    String name = principal.getName();// get logged in username
    model.addAttribute("username", name); // htmlで表示したい値をmodelに追加する
    return "hello";
  }
}
