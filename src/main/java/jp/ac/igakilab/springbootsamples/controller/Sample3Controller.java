package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample3Controller
 */
@Controller
@RequestMapping("/sample3")
public class Sample3Controller {

  /**
   * sample3へのURLリクエストがあったらこのクラスが反応する /sample3/sample31
   * へのURLリクエストがあったらsample31()メソッドが反応する
   *
   * @return sample31という名前のviewを返す．この場合はtemplates/sample31.htmlを返す
   */
  @GetMapping("sample31")
  public String sample31() {
    return "sample31";
  }
}
