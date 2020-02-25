package jp.ac.igakilab.springbootsamples.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.ac.igakilab.springbootsamples.service.AsyncService;

/**
 * Sample5SseController
 */
@RestController
@RequestMapping("sample5")
public class Sample5RestSseController {

  @Autowired // このアノテーションがついていると，対象のクラスのオブジェクトをSpringbootが管理し，自動的にnew等してくれる．ただし，対象のクラスに@Serviceや@Component等Springbootでの管理対象であることを示すアノテーションがついている必要がある．
  AsyncService asyncService;

  @GetMapping("sample51")
  public String sample51() {
    Date date = new Date();
    System.out.println(date);
    asyncService.async();
    return date.toString();
  }

}
