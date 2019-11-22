package jp.ac.igakilab.springbootsamples.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jp.ac.igakilab.springbootsamples.domain.AsyncHelper;

/**
 * StreamingController
 */
@RestController
public class StreamingController {

  // ↓だとasyncHelperが非同期にならない(End getがL37の終了を待ってから呼ばれる)
  // AsyncHelper asyncHelper = new AsyncHelper();
  @Autowired // @Componentの該当するクラスをDIしてくれる．また，End GetはL37終了を待たずに呼ばれる
  AsyncHelper asyncHelper;

  // curl -i -s -N
  // http://localhost:8000/api/streaming?eventNumber=5\&intervalSec=1
  // -i:Respnse Header, Body 両方を出力
  // -s:silent mode
  // -N: No buffer
  @GetMapping("/api/streaming")
  public SseEmitter streaming(@RequestParam(defaultValue = "1") long eventNumber, int intervalSec)
      throws IOException, InterruptedException {
    System.out.println("Start get.");

    SseEmitter emitter = new SseEmitter();
    asyncHelper.streaming(emitter, eventNumber, intervalSec);

    System.out.println("End get.");
    return emitter;
  }

}
