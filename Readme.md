# Springboot_samples
- Springbootを利用したWebアプリケーションの各種サンプル実装を行うサイト．
- 対象のSpringbootのver.はv2.4.0.RELEASE

## 環境構築
- 必要な開発環境は下記を参照して構築すること
- https://github.com/igakilab/byod.zip_isdev

### Spring Initializrを利用したセットアップ
- 作成したいアプリの名前でフォルダを作成し，そのフォルダをvscodeで開く
- 表示->コマンドパレット，を選択し，Spring Initializr:Generate a Gradle Project を実行する
  - Specify project language: Java
  - Input Group Id for your project: jp.ac.oit.is.{チーム名をアルファベット小文字で}
    - 例：jp.ac.oit.is.inudaisuki
      - スペースや特殊文字を含めないこと．すべてアルファベット小文字．
  - Input Artifact Id for your project: {アプリ名をアルファベット小文字で}
    - 例：dogland
    - スペースや特殊文字を含めないこと(_は入力できるが，不具合を誘発することがあるので使わないほうが良い)．すべてアルファベット小文字．また，セットアップ時に作成したフォルダ名と同じにしておくこと．
  - Specify Spring Boot version.: 2.2.4
  - Search for dependencies
    - 以下を選択
    - Spring Web
    - Thymeleaf
    - Mybatis Framework
    - H2 Database
    - Spring Security
  - フォルダの選択を行うダイヤログが表示されるので，現在のフォルダのひとつ上（通常is_dev20などになる）を指定して，springbootのためのフォルダを作成させる．
    - このとき，すでにあるフォルダを上書き(overwrite)してよいか問い合わせがあるので，OKすること．
  - Successfully Generatedと出ればOK．
- .gitignore作成
- build.gradleを修正
  - tomcatでなくjettyを利用する設定と当初はSecurityを使わないのでその設定をコメントアウトする
    - `implementation 'org.springframework.boot:spring-boot-starter-jetty'`追加
    - `configurations`追加
    - securityのimplementation設定をコメントアウト

### アプリ名等を後で変更したい場合
- 以下のファイルを修正する
  - settings.gradle
    - rootProject.name = 'springbootsamples' の行の'springbootsamples'をアプリ名に変更する．
    - 小文字アルファベットだけから構成されるものにすること（半角スペースや全角文字は不可）
  - build.gradle
    - group = 'jp.ac.oit.igakilab' の行の右側を自分たちのグループ名に変更する．
      - 例：'jp.ac.oit.inudaisuki'
      - 小文字アルファベットだけから構成されるものにすること（半角スペースや全角文字は不可）
    - src\main\java 以下のフォルダ構成とgroup及びrootProject.nameのアプリ名はおなじになるようにしておくこと．src\test\java も同じ
    - 同じくクラスファイルのパッケージの修正も必要

### リポジトリの作成とpush
- git init, git push

### application.properties
- `C:\Users\...\oithomes\advanced\springboot_samples\src\main\resources\application.properties` に以下のような設定を追記
  - 主にjetty周りの設定
  - 参考 https://howtodoinjava.com/spring-boot2/logging/embedded-server-logging-config/
  - tomcatの場合はこちらを参考：https://www.baeldung.com/spring-boot-embedded-tomcat-logs

```java
server.jetty.accesslog.filename=jetty-access.log
server.jetty.accesslog.enabled=true
server.jetty.accesslog.date-format=yyyy/mm/dd:HH:mm:ss Z
server.jetty.accesslog.time-zone=JST
server.jetty.accesslog.log-server=true
server.port=8000
spring.datasource.sql-script-encoding=UTF-8
```
- プロジェクトのbuild/logsフォルダにアクセスログが保存されるようになる．LogFormat等は今後要検討
- ポート番号 `server.port=8000` を設定することで， http://localhost:8000/ でSpringBootアプリが動作するようになる

### SpringBootWebアプリの実行方法
- vscodeからターミナル->新しいターミナル，を選択し，bashのターミナルをエディタ下部に開く
- build.gradleファイルがあるのと同じディレクトリにいることを確認後，`gradle bootRun`を実行するとSpringBootアプリがビルドされ，組み込みjettyで起動する
  - `gradle build`を実行するとbuild/libs/ 以下に作成されるjarを対象に，java -jar ???.jar でもSpringBootWebアプリケーションを起動できる
- http://localhost:8000/ にアクセスしたときになにかWebページが表示されていればOK．

# Samples
## [Sample1]templateを利用したhtmlファイルの表示
### 参考
- https://qiita.com/yama9112/items/ff829561238440437b99
### 関連するファイル
- Sample1Controller.java
- sample1.html
### 動作確認
- http://localhost:8000/sample1 にアクセスする
- HelloWorldと書かれたHTMLがブラウザに表示されればOK

# Samples
## templateを利用したhtmlファイルの表示
- 参考：https://qiita.com/yama9112/items/ff829561238440437b99
  - 実装：https://github.com/igakilab/springboot_samples/tree/9250ee3354163ac534e3d4b62879a72a5cab42e4
- http://localhost:8000/sample

## RestControllerを利用したapiの定義と利用(GET)
- 参考：https://qiita.com/sugaryo/items/5695bfcc21365f429767
  - 実装：https://github.com/igakilab/springboot_samples/commit/dfb755c75f097ff1ef22293bf97173fc78c53ae3
- http://localhost:8000/api/hello
  - Classにapiという名前をつけて，メソッドにhelloという名前をつける．↑のURLを呼び出すとhelloと名前をつけたメソッドの返り値が表示される

## Restのパスパラメータ
- 参考：https://qiita.com/sugaryo/items/5695bfcc21365f429767
  - 実装：https://github.com/igakilab/springboot_samples/commit/b653a6ffab85606bc1dec3b67ae960a166e5eaf9
- http://localhost:8000/api/test/hoge/fuga
  - `@RequestMapping("test/{param1}/{param2}")` とアノテートされたメソッドを呼び出す．メソッドの仮引数にパスパラメータを割り当てられる

## Restのクエリパラメータ
- 参考：https://qiita.com/sugaryo/items/5695bfcc21365f429767
  - 実装：https://github.com/igakilab/springboot_samples/commit/2cf5f05d2e136a0b7c3be9820164a9c748c1db86
- http://localhost:8000/api/test?param=hoge
  - `@RequestMapping("test")`なメソッドを呼び出す．クエリパラメータ名は指定がなければ仮引数の名前と同じ

## 複数ユーザによるベーシック認証とユーザ名表示
- 参考
  - https://www.codeflow.site/ja/article/spring-security__get-current-logged-in-username-in-spring-security
  - https://qiita.com/opengl-8080/items/eb3bf3b5301bae398cc2
  - 実装：https://github.com/igakilab/springboot_samples/commit/0b7b4c6032f6bfd6b0c66ec6c90190af27e560fc
- http://localhost:8000/hello
  - タイムリーフの使い方，ログインユーザ名の取得方法

## 特定ページへのベーシック認証をかけない設定
- 参考
  - https://intellectual-curiosity.tokyo/2019/04/14/spring-boot-2-x-%E3%81%A7basic%E8%AA%8D%E8%A8%BC%E3%82%92%E7%84%A1%E5%8A%B9%E3%81%AB%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95/
  - 実装：https://github.com/igakilab/springboot_samples/commit/201f416fca7223566158586a98664deffc3fcc33
- http://localhost:8000/sample
  - ベーシック認証がこのリクエストについてのみかからない．

## フォームを利用してPOSTするサンプル
- 参考
  - https://pointsandlines.jp/java/springboot-request-param
    - html部分のみこのままだとエラー
  - https://qiita.com/NagaokaKenichi/items/c6d1b76090ef5ef39482
    - タイムリーフのチートシート
  - 実装：https://github.com/igakilab/springboot_samples/commit/297f8113ba3d7736a65537bf7b89dff9082ba5c0
- http://localhost:8000/result
  - フィールドに数字を入れ，送信ボタンを押すと，フォームの下にGet 5等の数字が表示される．
  - result.htmlに対するGET/POST両方のコントローラを作成し，処理を実施
  - タイムリーフを利用し，値があるときとないとで表示を変える条件分岐もサンプル実装してみた

## DBの初期化及びデータ取得処理
- 参考
  - https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478
  - https://teratail.com/questions/99983
    - 日本語の取り扱いについて
  - https://mybatis.org/spring/ja/mappers.html
    - MapperクラスのオブジェクトはSpringBootが自動的に作成してくれるので，必要なときにMapperクラスのオブジェクトを引数に持つコンストラクタを定義すれば良い
  - 実装：https://github.com/igakilab/springboot_samples/commit/e27de415578525a00f538f80b3a4f0478ac149ce
- 実行するとgradle bootRunを実行したターミナルに，schema.sqlを通じてcreateされたテーブルにdata.sqlから登録されたデータが表示される．
- Fruits.javaのinterfaceを利用してFruitsMapper.javaでDBから取得するselect文を書いている
- apprication.propertiesでは，data.sqlがUTF-8なので，同じくUTF-8の利用を指定している（これがないともじバケる）
- H2DBを利用しており，データソースの設定はすべてspringbootが自動的にやってくれている
- CommandLineRunnerを利用してみた．SpringBoot起動時に呼び出してくれるらしい．DB等の初期化処理などに使えるっぽい．

## DBの値を取得し，GETでHTMLに渡して表示する方法
- 参考：
  - https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478
  - https://www.shookuro.com/entry/2017/05/02/120110
  - ModelMapへの独自クラスのオブジェクトを追加する方法
  - 実装：https://github.com/igakilab/springboot_samples/commit/583faf57e3791cdbe22324d3070589ff71da4fac
- http://localhost:8000/addFruits
  - DBに登録されたフルーツのデータをGET Requestに応じてタイムリーフを利用して表示する
  - 2種類の方法でHTMLにDBに登録されたフルーツの情報が表示される．

## フォームでPOSTしたデータをDBに登録し，同じページに登録した内容を表示する方法
- 参考：
  - https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478#mybatisdemoapplication%E3%81%AE%E4%BF%AE%E6%AD%A3%E3%81%A8spring-boot%E3%82%A2%E3%83%97%E3%83%AA%E3%82%B1%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%AE%E8%B5%B7%E5%8B%95
    - insert及びinsert時のkeyのauto incrementに関するサンプル
  - 実装：https://github.com/igakilab/springboot_samples/commit/86e82e938c8d242192f656ea73f04a32f94a35e6
    - ↑実装時は漏れていたが，↓のように@TransactionalをDBに書き込みを行う場合はつけておくと良いらしい（失敗した際に自動でロールバックしてくれる）
    - https://github.com/igakilab/springboot_samples/commit/28b49a47e0a87387a19b8a9dc63c05b8fa852af7
- http://localhost:8000/addFruits
  - 表示するとid1に登録されているフルーツが表示される
  - フォームに入力して「送信」すると，id2として（auto increment）送信した内容がDBに登録され，それがそのままフルーツ2としてhtmlにフルーツ1の代わりに表示される

## DBから複数の値をArrayListで取得し，htmlで表示するサンプル
- 参考：
  - https://qiita.com/NagaokaKenichi/items/c6d1b76090ef5ef39482#%E7%B9%B0%E3%82%8A%E8%BF%94%E3%81%97%E3%83%AB%E3%83%BC%E3%83%97
    - タイムリーフを利用した繰り返し処理及びステータス変数について参考にした
    - 繰り返しの単位がtdになっていたので，行単位で繰り返しを行うように実装では修正した．
  - 実装：https://github.com/igakilab/springboot_samples/commit/480b15ac815e816086aec744c1cb9ce64df160b1
- http://localhost:8000/addFruits
  - まずはこれを開いて，何でも良いので新しいフルーツの名前と数をDBに追加する
- http://localhost:8000/showFruitsList
  - 複数のフルーツがDBに登録された状態でこれを開くと，フルーツの情報が一行ずつ表示される
  - タイムリーフを利用したfor-each文とステータス変数を使った情報の表示を行っている

## SseEmitterとEventSourceを利用して非同期呼び出しを行うサンプル
- 参考：
  - https://qiita.com/kazuki43zoo/items/53b79fe91c41cc5c2e59
  - 実装：https://github.com/igakilab/springboot_samples/commit/8149268a777e03bce7dfda0c6bba3ef28df52ffe
- 確認1: `curl -i -s -N http://localhost:8000/api/streaming?eventNumber=5\&intervalSec=1`
  - `-i`はHTTPヘッダを表示するオプション， `-s`はダウンロード関連の表示を省略するオプション`-N`はバッファを利用しないオプション（このオプションがないとレスポンスが非同期じゃなくまとめて最後に来るようになる）
  - StreamingControllerからAsyncHelperのstreamingメソッドが非同期に呼び出されて，レスポンスが非同期に返ってくる
- 確認2: `curl -i -s -N http://localhost:8000/api/sse`
  - SseController内の一部の処理が非同期に呼び出される(L28-L43)．ただ，一部を非同期にするためにConcurrentパッケージのExecutorServiceが必要なのでおすすめしない
- 確認3: http://localhost:8000/ajaxFruits.html
  - 普通のAjax呼び出しだが，非同期にはならず，すべての処理が終了してから画面が更新される．非推奨だが，一般的な書き方ということで（同期呼び出しならこれでいい）．
- 確認4: http://localhost:8000/ajaxFruits2.html
  - EventSourceを利用．非同期に呼び出しが行われ，画面も非同期に更新される．
  - 一度ページを表示すると，StreamingControllerの該当するstreamingメソッドが何度も呼び出されるっぽい．接続が切れると自動的に再接続してるのかも．
### ポイント(StreamingController)
- SseEmitterのところはResponseBodyEmitterでもいける．curlでの実行結果は同様だが，JSで呼び出す際に，↓のようなエラーがJS側で発生してしまう
  - `EventSource's response has a MIME type ("text/plain") that is not "text/event-stream". Aborting the connection.`
  - これはResponseBodyEmitterだとtext/plainでメッセージが返るため．SseEmitterだとtext/event-streamで返るのでこちらを使うと良い
- @RestController
  - 参考：https://qiita.com/TEBASAKI/items/267c261db17f178e33eb#controller-%E3%82%AF%E3%83%A9%E3%82%B9
  - 戻り値をそのままJS側で受け取る場合は@RestControllerで良い．今回の場合はemitter.send()の引数がそのままJSに渡される
- @Autowired
  - 対象クラスのオブジェクトをnewして割り当ててくれる．
  - ただし，対象クラスに@Component とアノテーションがついていないと駄目．
  - この例の場合，AsyncHelperクラスに@Componentがついているので，@Autowiredで割当が行われる．
  - なお，対象クラスを非同期に呼び出したい場合は@Autowiredが必須っぽい．
- L35で呼び出しているasyncHelper.streaming()は非同期に呼び出される．すなわち，L35の処理が終了する前にL37が呼び出される．
  - gradle bootRunを実行したターミナルを確認すると分かる
  - 非同期に呼び出したい別クラスのメソッドには，引数に必ずSseEmitterクラスのオブジェクトを渡す必要がある．また，呼び出し元メソッド(この例の場合はStreamingController.streaming())の返り値をSseEmitterクラスのオブジェクトにする必要がある．
### ポイント(AsyncHelper)
- @Component
  - このオブジェクトを利用するStreamingControllerで@Autowiredするために必要な設定．要はnewをSpringbootにやってもらうため．
- @Async
  - 非同期呼び出しをしたいメソッド（要するに指定したメソッドが終了するのを呼び出し元で待たなくて良い）にアノテーションとして付与する
- emitter.send()
  - 対象メソッドの引数に与えられたSseEmitterにsend()で引数として他クラスのオブジェクトや文字列を与えることで，javascript側でオブジェクトの場合はjsonオブジェクトとして，文字列の場合は文字列として受け取ることができる．
- emitter.complete()
  - これを呼び出すことで，emitterを利用して呼び出し処理が明示的に終了される．多分呼び出さないとemitterが終了されないままで，再利用できなくなる気がする．
  - また，これが呼び出されていると，JS側でEventSourceに指定されたapiが何度も呼び出されて，streamingメソッドも何度も呼び出されるが，complete()していないと，streamingメソッドは再度呼び出されることはなくなる（正確には呼ばれていてもemitterが機能しない？）．
- 発生する例外について
  - asyncHelper.streaming()内の処理を実行している最中にブラウザが終了する等でクライアントとの接続が切れた場合，以下の例外が発生する．
    - `java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state [MUST_DISPATCH]`
### ポイント(ajaxFruits2.html)
- EventSource()
  - 参考：https://uhyohyo.net/javascript/13_2.html
  - 参考：https://www.codeflow.site/ja/article/spring-mvc-sse-streams
  - 参考：https://developer.mozilla.org/ja/docs/Web/API/Server-sent_events/Using_server-sent_events
  - Server-Sent EventsをJSで受け取るために使う．URLを引数に与えると，emitter.send()で送信された内容を送信されるたびにon.messageで受け取ることができる
- sse.onmessage
  - EventSourceからメッセージが送られてきたら（MessageEvent)，function(evt)を処理する．
  - EventSourceはサーバから接続が切断されても自動的に再接続が行われるらしい．回避しようと思ったら，処理終了時や例外発生時（切断時に例外が発生する）にsse.close()を呼び出すと良い．
  ```javascript
    sse.onerror = function (evt) {
    console.log("error!!");
    sse.close();
  }
  ```
  - ブラウザ終了時
    - 組み込みTomcatの場合は`java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state [MUST_DISPATCH]`という例外が発生する．これはcatchしてログに表示しないようにするのは今の時点ではやり方がわからない
    - 組み込みjettyの場合は`org.eclipse.jetty.io.EofException: null` という例外が発生する．こちらの場合は，`AsyncHelper.java`の`streaming()`メソッド内部の`emitter.send()`でIOExceptionが発生するので，下記のようにcatchしてやれば切断時の処理を正しく実装できる
```java
  @Async
  public void streaming(SseEmitter emitter, long eventNumber, int intervalSec) throws InterruptedException {
    System.out.println("Start Async processing.");

    for (int i = 1; i <= eventNumber; i++) {
      TimeUnit.SECONDS.sleep(intervalSec);
      Fruits fruits = new Fruits();
      fruits.setName("メロン");
      fruits.setNum(i);
      fruits.setWeight(i * 25.5);
      try {
        emitter.send(fruits);
      } catch (IOException e) {
        System.out.println("IOException!");
        break;
      }
      System.out.println("java:msg" + i);
    }

    emitter.complete();

    System.out.println("End Async processing.");
  }
```
