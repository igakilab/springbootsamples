package jp.ac.igakilab.springbootsamples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
  public String showFrurtsForm(ModelMap model) {
    Fruits fruits = fruitsMapper.select(1);
    model.addAttribute("fruit", fruits);// このkeyの文字列を利用して，HTMLで参照する

    return "addFruits.html";
  }

}
