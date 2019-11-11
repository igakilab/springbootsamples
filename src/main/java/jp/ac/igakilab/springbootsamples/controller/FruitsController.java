package jp.ac.igakilab.springbootsamples.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.igakilab.springbootsamples.domain.Fruits;
import jp.ac.igakilab.springbootsamples.mapper.FruitsMapper;

/**
 * FruitsController
 */
@Controller
public class FruitsController {
  private final FruitsMapper fruitsMapper;

  // SpringBootがMapperを自動的にnewしてくれるので，開発者が明示的に作成する必要はない．
  public FruitsController(FruitsMapper fruitsMapper) {
    this.fruitsMapper = fruitsMapper;
  }

  @GetMapping("/addFruits")
  public String showFruitsForm(ModelMap model) {
    Fruits fruits = fruitsMapper.select(1);
    model.addAttribute("fruit", fruits);// このkeyの文字列を利用して，HTMLで参照する
    model.addAttribute("fruit2", new Fruits());
    // fruit2という名前のオブジェクトをmodelに追加しておかないと，htmlのフォーム表示時にエラーが起きる
    return "addFruits.html";
  }

  @PostMapping("/addFruits")
  @Transactional
  public String sendFruitsForm(ModelMap model, Fruits fruit2) {
    this.fruitsMapper.insert(fruit2);
    fruit2 = fruitsMapper.select(2);// id 2に登録されているフルーツを取得
    model.addAttribute("fruit2", fruit2);
    model.addAttribute("fruit", new Fruits());// fruitという名前のオブジェクトをmodelに追加しておかないと，htmlで${fruit.name}などを表示したときにエラーが発生する
    return "addFruits.html";
  }

  @GetMapping("/showFruitsList")
  public String showFruitsList(ModelMap model) {
    ArrayList<Fruits> fruitsList = this.fruitsMapper.selectAll();
    model.addAttribute("fruits", fruitsList);

    return "showFruits.html";
  }

}
