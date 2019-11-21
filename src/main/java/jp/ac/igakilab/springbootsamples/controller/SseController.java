package jp.ac.igakilab.springbootsamples.controller;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * StreamingController
 */
@Controller
@RequestMapping("/api/sse")
public class SseController {

  private ExecutorService nonBlockingService = Executors.newCachedThreadPool();

  // curl -i -s -N http://localhost:8000/api/sse
  @RequestMapping(method = RequestMethod.GET)
  public SseEmitter handleSse() {
    SseEmitter emitter = new SseEmitter();
    nonBlockingService.execute(() -> {
      try {
        emitter.send("/sse" + " @ " + new Date());
        TimeUnit.SECONDS.sleep(1);
        emitter.send("/sse" + " @ " + new Date());
        TimeUnit.SECONDS.sleep(2);
        emitter.send("/sse" + " @ " + new Date());
        TimeUnit.SECONDS.sleep(3);
        emitter.send("/sse" + " @ " + new Date());
        // we could send more events
        emitter.complete();
      } catch (Exception ex) {
        emitter.completeWithError(ex);
      }
    });
    return emitter;
  }
}
