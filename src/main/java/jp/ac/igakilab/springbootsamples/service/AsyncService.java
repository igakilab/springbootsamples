package jp.ac.igakilab.springbootsamples.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jp.ac.igakilab.springbootsamples.model.Fruits;

/**
 * AsyncService 一般的にビジネスロジックなどを記述するクラスをサービスとする
 *
 * @Serviceをつけることで，Springbootが管理してくれるようになる(@ComponentなどでもOK)
 */
@Service
public class AsyncService {

  @Async
  public void async() {
    System.out.println("async start");
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("async end");
  }

  @Async
  public void async52(SseEmitter emitter) {
    System.out.println("async52 start");
    Fruits fruit = new Fruits();
    fruit.setName("メロン");
    fruit.setNum(100);
    fruit.setWeight(1.7);
    try {
      for (int i = 0; i < 10; i++) {
        TimeUnit.SECONDS.sleep(2);
        // emitter.sendが実行されるたびにその引数がJavaScript側に渡される
        // JSの sse.onmessage = function (evt) {};
        // が発火し，evt.dataなどでsendの引数をJSから参照できるようになる．オブジェクトの場合はjsonオブジェクト，文字列の場合は文字列としてJSは受け取ることができる
        emitter.send(fruit);
      }

      /**
       * SSEでサーバとクライアントが接続された状態でブラウザを終了すると
       * 組み込みTomcatの場合はjava.lang.IllegalStateException: Calling [asyncError()] is not
       * valid for a request with Async state
       * [MUST_DISPATCH]という例外が発生する．これはcatchしてログに表示しないようにするのは今の時点ではやり方がわからない
       * 組み込みjettyの場合はorg.eclipse.jetty.io.EofException: null
       * という例外が発生する．こちらの場合は，emitter.send()実行時にIOExceptionが発生するので，下記のようにcatchしてやれば切断時の処理を正しく実装できる
       */
    } catch (IOException e) {
      // e.printStackTrace();
      // ブラウザ終了等クライアント切断時の処理をここで実装すると良い（ただしjettyの場合のみ有効）
      System.out.println("クライアントが切断されたようです");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    /**
     * complete()を呼び出すことで，emitterを利用した呼び出し処理が明示的に終了される．多分呼び出さないとemitterが終了されないままで，再利用できなくなる気がする．
     * complete()されていると，JS側でEventSourceに指定されたapiが何度も呼び出される．結果としてこのasync52メソッドもクライアントと接続している限り何度も呼び出される．が，complete()していないと，emitterが機能しないっぽい．
     */
    emitter.complete();
    System.out.println("async52 end");
  }
}
