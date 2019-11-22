package jp.ac.igakilab.springbootsamples.domain;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class AsyncHelper {
  @Async
  public void streaming(SseEmitter emitter, long eventNumber, int intervalSec) throws InterruptedException {
    System.out.println("Start Async processing.");

    for (int i = 1; i <= eventNumber; i++) {
      TimeUnit.SECONDS.sleep(intervalSec);
      Fruits fruits = new Fruits();
      fruits.setName("メロン");
      fruits.setNum(i);
      fruits.setWeight(i * 25.5);
      // emitter.send("msg" + i + "\r\n");
      try {
        emitter.send(fruits);
      } catch (IOException e) {
        System.out.println("IOException!");
        break;
      }
      System.out.println("java:msg" + i);
    }

    emitter.complete();// これをコメントアウトすると，streamingメソッドは1度だけ呼び出されて終了するが，complete()を呼び出しておくと，streamingメソッドは何回も呼び出される．

    System.out.println("End Async processing.");
  }
  // ...
}
