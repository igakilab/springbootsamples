package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Sample12Controller "/sample12"へのアクセスがあった場合はこのクラスが対応する
 * POSTの場合はsample12Postメソッド，GETの場合はsample12Getに処理が流れる
 */
@Controller
@RequestMapping("/sample12")
public class Sample12Controller {
  /**
   *
   * @param id    POST時に渡される値．POSTで渡されたidをInteger（要するに整数）に変換されてidという変数に渡される．
   * @param model SpringBootが用意する変数．このオブジェクト(map)に値を格納するとhtmlから見られるようになる．
   * @return Viewを返す．今回はsample12.html．このとき，ModelMapに値が格納されていたら，sample12.htmlからタイムリーフを利用して値を読み取ることができる
   */
  @PostMapping
  public String sample12Post(@RequestParam("id") Integer id, ModelMap model) {
    model.addAttribute("id", id);
    return "sample12";
  }

  /**
   * HTTP/GETでのアクセスがあった場合はこちらが対応する． なお，@RequestMapping,
   * と書いても同じ（デフォルトがGETに対応しているため）．
   *
   * @return sample12.htmlをViewとして返す
   */
  @GetMapping
  public String sample12Get() {
    return "sample12";
  }

}
