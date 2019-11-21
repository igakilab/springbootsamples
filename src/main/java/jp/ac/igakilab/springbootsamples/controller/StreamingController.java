package jp.ac.igakilab.springbootsamples.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import jp.ac.igakilab.springbootsamples.domain.AsyncHelper;

/**
 * StreamingController
 */
@Controller
@RequestMapping("/api/streaming")
public class StreamingController {

  // ↓だとasyncHelperが非同期にならない(End getがL37実行後に呼ばれる)
  // AsyncHelper asyncHelper = new AsyncHelper();
  @Autowired // @Componentの該当するクラスをDIしてくれる．また，End GetはL37終了前に呼ばれる
  AsyncHelper asyncHelper;

  // curl -i -s -N
  // http://localhost:8000/api/streaming?eventNumber=5\&intervalSec=1
  // -i:Respnse Header, Body 両方を出力
  // -s:silent mode
  // -N: No buffer
  @RequestMapping(method = RequestMethod.GET)
  public ResponseBodyEmitter streaming(@RequestParam(defaultValue = "1") long eventNumber,
      @RequestParam(defaultValue = "0") long intervalSec) throws IOException, InterruptedException {
    System.out.println("Start get.");

    ResponseBodyEmitter emitter = new ResponseBodyEmitter();
    asyncHelper.streaming(emitter, eventNumber, intervalSec);

    System.out.println("End get.");
    return emitter;
  }

}
