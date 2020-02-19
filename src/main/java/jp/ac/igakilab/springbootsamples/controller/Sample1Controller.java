package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample1Controller
 */
@Controller
public class Sample1Controller {

  /**
   * sample1へのURLリクエストがあったらsample1()を呼び出す．http://localhost:8000/sample1 など
   * また，RequestMappingの引数にはGET/POSTの違いやheaderの情報なども指定できる．/sample1の文字列には*や**などのワイルドカードも使えるらしい．
   *
   * @return sample1という名前のviewを返す．この場合はtemplates/sample1.htmlを返す
   */
  @RequestMapping("/sample1")
  public String sample1() {
    return "sample1";
  }
}
