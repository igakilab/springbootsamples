package jp.ac.igakilab.springbootsamples.service;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * AsyncService 一般的にビジネスロジックなどを記述するクラスをサービスとする
 *
 * @Serviceをつけることで，Springbootが管理してくれるように鳴る
 */
@Service
public class AsyncService {

  @Async
  public void async() {
    System.out.println("async start");
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("async end");
  }
}
