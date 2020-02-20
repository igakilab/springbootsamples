package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * /apiへのリクエストがあるとこのcontrollerクラスで処理する
 *
 * @Controllerと異なり，viewではなく指定した文字列や値がそのまま返るようになる
 */
@RestController
@RequestMapping("api")
public class Sample2RestController {

  /**
   * /api/sample21 にGETでアクセスすると，sample21()メソッドが呼び出される
   *
   * @return htmlではなく，Hello sample21!という文字列が返る
   */
  @GetMapping("sample21")
  private String sample21() {
    return "Hello sample21!";
  }

}
