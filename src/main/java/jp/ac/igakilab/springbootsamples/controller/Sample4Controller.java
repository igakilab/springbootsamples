package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

  @Transactional // DBのトランザクション処理を利用したい場合につける
  @GetMapping("sample42")
  public String sample42GetFruits(ModelMap model) {
    Fruits fruit = fruitsMapper.select(1);// IDが1のフルーツの情報をDBから取得する
    model.addAttribute("fruit", fruit);// htmlから見えるようになる．
    return "sample4.html";
  }

  /**
   *
   * @param htmlで利用する(th:objectで指定する)オブジェクトを仮引数で指定し，@ModelAttributeアノテーションを付けておく必要がある
   * @return Viewコンポーネントの名前を返す．"sample43"だけでも良い．
   */
  @GetMapping("sample43")
  public String sample43GetFruits(@ModelAttribute("fruit") Fruits fruit) {
    return "sample43.html";
  }

  /**
   * POSTと同時にHTMLで値を表示したい場合は，sample43PostFruitsの引数にModelMap
   * modelを追加し，modelにaddAtributeでfruitを追加すれば良い
   *
   * @param fruit POST時に渡される(th:objectで指定する)オブジェクトを仮引数で指定することで，オブジェクトごと受け取ることができる．なお，@ModelAttributeアノテーションを付けておく必要がある
   * @return Viewコンポーネントの名前を返す．"sample43"だけでも良い．
   */
  @Transactional
  @PostMapping("sample43")
  public String sample43PostFruits(@ModelAttribute("fruit") Fruits fruit) {
    // DBにフルーツオブジェクトの値をinsert
    this.fruitsMapper.insert(fruit);

    // insertされた値をDBから取得してターミナルに表示する
    Fruits fruit2 = fruitsMapper.select(2);// IDが2のフルーツの情報をDBから取得する
    System.out.println(fruit2.getName());
    System.out.println(fruit2.getNum());
    System.out.println(fruit2.getWeight());
    System.out.println(fruit2.getDetails());
    System.out.println(fruit2.isSent());

    return "sample43.html";
  }
}
