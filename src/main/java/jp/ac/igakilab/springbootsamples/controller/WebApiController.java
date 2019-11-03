package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WebApiController {
  @RequestMapping("hello")
  private String hello() {
    return "SpringBoot!";
  }

  /*
   * http://localhost:8000/api/test/hoge 受け取ったパラメータはhogeです
   *
   * @PathVariable("param")のように{param}のパスパラメータをメソッドの仮引数で明示的に指定しても良い
   */
  @RequestMapping("test/{param}")
  private String testPathVariable(@PathVariable String param) {
    return "受け取ったパラメータは" + param + "です";
  }

  /*
   * http://localhost:8000/api/test/hoge/fuga/ 受け取ったパラメータはhogeとfugaです
   */
  @RequestMapping("test/{param1}/{param2}")
  private String testPathVariable(@PathVariable String param1, @PathVariable String param2) {
    return "受け取ったパラメータは" + param1 + "と" + param2 + "です";
  }
}
