# Springboot_samples
- Springbootを利用したWebアプリケーションの各種サンプル実装を行うサイト．
- 対象のSpringbootのver.はv2.2.0.RELEASE

## 環境構築
- `C:\oit\is_advanced` に以下を展開した
  - amazonjdk11.0.3_7
  - gradle-5.6.3
  - PortableGit-2.23.0-64
    - bash_profile.sh にjava及びgradle/binへのPATHを通し，$HOME(${USER}/oithomes/advanced/)を設定する
    - /usr/local/bin/に必要なコマンドを追加する
  - vscode-portable-win64-1.39.2-20
    - settings.jsonを設定
      - C:\oit\is_advanced\vscode-portable-win64-1.39.2-20\data\appdata\Code\User\settings.json
    - bash.exeをシェルに設定
    - 以下の拡張をインストール
      - Debugger for Java
      - EvilInspector
      - Gradle Language Support
      - Japanese Language Pack
      - Language Support for Java
      - Spring Initializr Java Support
      - Spring Boot Tools:これインストールしたらJava language supportのSuggestがうまく動かなくなった

## セットアップ
- 表示->コマンドパレット，を選択し，Spring Initializr:Generate a Gradle Project を実行する
  - group id等を適当に入力する
  - 以下の依存関係を導入
    - Spring Web
    - thymeleaf
    - mybatis
    - h2(未定)
- .gitignore作成
- git init, git push

## application.properties
### 組み込みTomcatのログ設定
- 参考：https://www.baeldung.com/spring-boot-embedded-tomcat-logs
- `C:\Users\...\oithomes\advanced\springboot_samples\src\main\resources\application.properties` に以下のようなtomcatのログ設定を追記
```java
server.tomcat.accesslog.enabled=true
server.tomcat.basedir=build
server.tomcat.accesslog.directory=logs
```
- プロジェクトのbuild/logsフォルダにアクセスログが保存されるようになる．LogFormat等は今後要検討
- ポート番号 `server.port=8000`

## SpringBootWebアプリの実行方法
- gradle bootRun を実行するとSpringBootアプリがビルドされ，組み込みTomcatで起動する
  - build/libs/ 以下に作成されるjarを対象に，java -jar ???.jar でもSpringBootWebアプリケーションを起動できる

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
  - 実装：https://github.com/igakilab/springboot_samples/commit/e27de415578525a00f538f80b3a4f0478ac149ce
- 実行するとgradle bootRunを実行したターミナルに，schema.sqlを通じてcreateされたテーブルにdata.sqlから登録されたデータが表示される．
- Fruits.javaのinterfaceを利用してFruitsMapper.javaでDBから取得するselect文を書いている
- apprication.propertiesでは，data.sqlがUTF-8なので，同じくUTF-8の利用を指定している（これがないともじバケる）
- H2DBを利用しており，データソースの設定はすべてspringbootが自動的にやってくれている
- CommandLineRunnerを利用してみた．SpringBoot起動時に呼び出してくれるらしい．DB等の初期化処理などに使えるっぽい．
