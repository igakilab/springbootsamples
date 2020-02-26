package jp.ac.igakilab.springbootsamples.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jp.ac.igakilab.springbootsamples.service.AsyncService;

/**
 * Sample5SseController
 */
@RestController
@RequestMapping("sample5")
public class Sample5RestSseController {

  @Autowired // このアノテーションがついていると，対象のクラスのオブジェクトをSpringbootが管理し，自動的にnew等してくれる．ただし，対象のクラスに@Serviceや@Component等Springbootでの管理対象であることを示すアノテーションがついている必要がある．
  AsyncService asyncService;

  /**
   * このメソッドを呼び出すと，asyncService.async()が完了する前にdate.toString()が呼び出し元に返る．
   *
   * @return 現在日時が返る
   */
  @GetMapping("sample51")
  public String sample51() {
    Date date = new Date();
    System.out.println(date);
    asyncService.async();
    return date.toString();
  }

  /**
   * これを実行するとemitterが呼び出し元に返る． JS側でのContent-Typeは
   * text/event-streamになる．asyncService.async52()メソッド内のemitter.send()が実行されるたびにsendの引数が呼び出し元にPUSHで渡される
   *
   * @return SseEmitterが返る．サーバ->クライアントのPUSH型通信
   */
  @GetMapping("sample52")
  public SseEmitter sample52() {
    Date date = new Date();
    System.out.println("sample52 start" + date);
    SseEmitter emitter = new SseEmitter();
    asyncService.async52(emitter);
    System.out.println("sample52 end" + date);
    return emitter;

  }

}
