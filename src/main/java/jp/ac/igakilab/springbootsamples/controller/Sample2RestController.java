package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /*
   * http://localhost:8000/api/sample22/hoge
   * のように指定すると，"/api/sample22"の後に記述された/で区切られた内容(パスパラメータ)を引数として受け取ることができる．
   *
   * @GetMapping("sample22/{param}")はsample22/の後の引数をparamという名前で受け取ることを示している．
   *
   * (@PathVariable String param)と書くとString
   * paramにURLのパスパラメータの値をSpringBootが代入してくれる．
   *
   * (@PathVariable("param") String param)のように{param}のパスパラメータ名を明示的に指定しても良い
   */
  @GetMapping("sample22/{param}")
  private String sample22Path1(@PathVariable String param) {
    return "受け取ったパラメータは" + param + "です";
  }

  /*
   * http://localhost:8000/api/sample22/hoge/fuga/ パスパラメータを複数受け取ることもできる
   */
  @GetMapping("sample22/{param1}/{param2}")
  private String sample22Path2(@PathVariable String param1, @PathVariable String param2) {
    return "受け取ったパラメータは" + param1 + "と" + param2 + "です";
  }

  /*
   * http://localhost:8000/api/sample22?param=hoge
   * のように指定すると，"?"以降のparam=hogeの形式の文字列(クエリパラメータ)を受け取ることができる．
   *
   * (@RequestParam("param") String param) とかすると?name=hoge
   * と指定できる．()を省略すると仮引数がクエリパラメータ名になる
   */
  @GetMapping("sample22")
  private String testQueryParam(@RequestParam String param) {
    return "受け取ったクエリパラメータは" + param + "dayo";

  }
}
