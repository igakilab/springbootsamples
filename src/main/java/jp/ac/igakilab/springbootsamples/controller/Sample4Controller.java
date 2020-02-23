package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import jp.ac.igakilab.springbootsamples.model.Fruits;
import jp.ac.igakilab.springbootsamples.model.FruitsMapper;

/**
 * Sample4Controller
 */
@Controller
public class Sample4Controller {
  // FruitsMapperオブジェクトを宣言し，Sample4Controllerクラス（要はこのクラス）の
  // コンストラクタの引数に渡せば，SpringBootがMapperオブジェクトを作成して代入してくれる
  // resourcesパッケージの直下にschema.sqlがあるとDBのスキーマを起動時に設定してくれる．data.sqlがあると初期データの投入を自動的にしてくれる．
  private final FruitsMapper fruitsMapper;

  public Sample4Controller(FruitsMapper fruitsMapper) {
    this.fruitsMapper = fruitsMapper;
  }

  @Transactional // DBのトランザクション処理を利用したい場合につける
  @GetMapping("sample41")
  public String sample41GetFruits() {
    Fruits fruit = fruitsMapper.select(1);// IDが1のフルーツの情報をDBから取得する
    System.out.println(fruit.getName());
    System.out.println(fruit.getNum());
    System.out.println(fruit.getWeight());
    System.out.println(fruit.getDetails());
    System.out.println(fruit.isSent());
    return "sample4.html";
  }
}
