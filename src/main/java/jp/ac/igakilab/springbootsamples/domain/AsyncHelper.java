package jp.ac.igakilab.springbootsamples.domain;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Component
public class AsyncHelper {
  // ...
  @Async
  public void streaming(ResponseBodyEmitter emitter, long eventNumber, long intervalSec)
      throws IOException, InterruptedException {
    System.out.println("Start Async processing.");

    for (long i = 1; i <= eventNumber; i++) {
      TimeUnit.SECONDS.sleep(intervalSec);
      emitter.send("msg" + i + "\r\n");
      System.out.println("java:msg" + i);
    }

    emitter.complete();

    System.out.println("End Async processing.");
  }
  // ...
}
