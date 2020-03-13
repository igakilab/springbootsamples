# Springbootsamples
- Springbootを利用したWebアプリケーションの各種サンプル実装を行うサイト．
- 対象のSpringbootのver.はv2.2.4.RELEASE

<!-- TOC -->

- [Springbootsamples](#springbootsamples)
  - [環境構築](#環境構築)
    - [Spring Initializrを利用したセットアップ](#spring-initializrを利用したセットアップ)
    - [アプリ名等を後で変更したい場合](#アプリ名等を後で変更したい場合)
    - [リポジトリの作成とpush](#リポジトリの作成とpush)
    - [application.properties](#applicationproperties)
    - [SpringBootWebアプリの実行方法](#springbootwebアプリの実行方法)
- [Samples(シンプルなGET/POST)](#samplesシンプルなgetpost)
  - [[Sample1-1]templateを利用したhtmlファイルの表示(HTTP/GET)](#sample1-1templateを利用したhtmlファイルの表示httpget)
    - [参考](#参考)
    - [関連するファイル](#関連するファイル)
    - [関連する機能](#関連する機能)
    - [動作確認](#動作確認)
  - [[Sample1-2] java-html間の値の受け渡し(HTTP/POST, タイムリーフ)](#sample1-2-java-html間の値の受け渡しhttppost-タイムリーフ)
    - [参考](#参考-1)
    - [関連するファイル](#関連するファイル-1)
    - [関連する機能](#関連する機能-1)
    - [動作確認](#動作確認-1)
- [Samples(RestAPIの作成)](#samplesrestapiの作成)
  - [[Sample2-1] RestControllerの基本的な利用方法](#sample2-1-restcontrollerの基本的な利用方法)
    - [参考](#参考-2)
    - [関連するファイル](#関連するファイル-2)
    - [関連する機能](#関連する機能-2)
    - [動作確認](#動作確認-2)
  - [[Sample2-2] パラメータを渡してRestAPIを呼ぶ方法](#sample2-2-パラメータを渡してrestapiを呼ぶ方法)
    - [参考](#参考-3)
    - [関連するファイル](#関連するファイル-3)
    - [関連する機能](#関連する機能-3)
    - [動作確認](#動作確認-3)
- [Samples(ベーシック認証)](#samplesベーシック認証)
  - [[Sample3-1]最もシンプルなベーシック認証](#sample3-1最もシンプルなベーシック認証)
    - [参考](#参考-4)
    - [関連するファイル](#関連するファイル-4)
    - [関連する機能](#関連する機能-4)
    - [動作確認](#動作確認-4)
  - [[Sample3-2]ベーシック認証時にログインユーザ名を取得する方法](#sample3-2ベーシック認証時にログインユーザ名を取得する方法)
    - [参考](#参考-5)
    - [関連するファイル](#関連するファイル-5)
    - [関連する機能](#関連する機能-5)
    - [動作確認](#動作確認-5)
  - [[Sample3-3]フォームでのログインとログアウト](#sample3-3フォームでのログインとログアウト)
    - [参考](#参考-6)
    - [関連するファイル](#関連するファイル-6)
    - [関連する機能](#関連する機能-6)
    - [動作確認](#動作確認-6)
  - [[Sample3-4]InMemory認証でのユーザの追加](#sample3-4inmemory認証でのユーザの追加)
    - [参考](#参考-7)
    - [関連するファイル](#関連するファイル-7)
    - [関連する機能](#関連する機能-7)
    - [動作確認](#動作確認-7)
- [Samples(データベースとの連携)](#samplesデータベースとの連携)
  - [[Sample4-1]DBのテーブル設定，値登録とselectによる取得](#sample4-1dbのテーブル設定値登録とselectによる取得)
    - [参考](#参考-8)
    - [関連するファイル](#関連するファイル-8)
    - [関連する機能](#関連する機能-8)
    - [動作確認](#動作確認-8)
  - [[Sample4-2]DBの値を取得し，GETでHTMLに渡して表示する方法](#sample4-2dbの値を取得しgetでhtmlに渡して表示する方法)
    - [参考](#参考-9)
    - [関連するファイル](#関連するファイル-9)
    - [関連する機能](#関連する機能-9)
    - [動作確認](#動作確認-9)
  - [[Sample4-3] フォームでPOSTしたデータをDBに登録する](#sample4-3-フォームでpostしたデータをdbに登録する)
    - [参考](#参考-10)
    - [関連するファイル](#関連するファイル-10)
    - [関連する機能](#関連する機能-10)
    - [動作確認](#動作確認-10)
    - [動作確認（H2DBコンソール）](#動作確認h2dbコンソール)
  - [[Sample4-4] DBから複数の値をArrayListで取得し，htmlで表示するサンプル](#sample4-4-dbから複数の値をarraylistで取得しhtmlで表示するサンプル)
    - [参考](#参考-11)
    - [関連するファイル](#関連するファイル-11)
    - [関連する機能](#関連する機能-11)
    - [動作確認](#動作確認-11)
- [Samples(非同期呼び出し)](#samples非同期呼び出し)
  - [[Sample5-1] @Asyncを利用した非同期処理](#sample5-1-asyncを利用した非同期処理)
    - [参考](#参考-12)
    - [関連するファイル](#関連するファイル-12)
    - [関連する機能](#関連する機能-12)
    - [動作確認](#動作確認-12)
  - [[Sample5-2] Push型の非同期処理](#sample5-2-push型の非同期処理)
    - [参考](#参考-13)
    - [関連するファイル](#関連するファイル-13)
    - [関連する機能](#関連する機能-13)
    - [動作確認](#動作確認-13)

<!-- /TOC -->

## 環境構築
- 必要な開発環境は下記(private)を参照して構築すること
- https://github.com/igakilab/byod.zip_isdev
- 以下のセットアップを適用した状態のリポジトリは以下
  - https://github.com/igakilab/springbootsamples/tree/v0.0.2
  - これをclone, checkoutして下記[SpringBootWebアプリの実行方法]を試して正常に動作すればOK

### Spring Initializrを利用したセットアップ
- 作成したいアプリの名前でフォルダを作成し，そのフォルダをvscodeで開く
- 表示->コマンドパレット，を選択し，Spring Initializr:Generate a Gradle Project を実行する
  - Specify project language: Java
  - Input Group Id for your project: jp.ac.hoge.is.{チーム名をアルファベット小文字で}
     - 例：jp.ac.hoge.is.inudaisuki
       - スペースや特殊文字を含めないこと．すべてアルファベット小文字．
       - 必ずしもjp.ac.hogeから始まらなくても良い
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
  - フォルダの選択を行うダイヤログが表示されるので，現在のフォルダのひとつ上を指定して，springbootのためのフォルダを作成させる．
    - このとき，すでにあるフォルダを上書き(overwrite)してよいか問い合わせがあるので，OKすること．
  - Successfully Generatedと出ればOK．
- .gitignore作成
- build.gradleを修正
  - https://github.com/igakilab/springbootsamples/blob/v0.0.2/build.gradle
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
- `springbootsamples\src\main\resources\application.properties` に以下のような設定を追記
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
- プロジェクトの直下にアクセスログが保存されるようになる（logsなどのディレクトリを作成して保存も可能だが，その場合はlogsディレクトリが作成されていないとbuild errorが発生するようになってしまう）．LogFormat等は今後要検討
- ポート番号 `server.port=8000` を設定することで， http://localhost:8000/ でSpringBootアプリが動作するようになる

### SpringBootWebアプリの実行方法
- vscodeからターミナル->新しいターミナル，を選択し，bashのターミナルをエディタ下部に開く
- build.gradleファイルがあるのと同じディレクトリにいることを確認後，`gradle bootRun`を実行するとSpringBootアプリがビルドされ，組み込みjettyで起動する
  - `gradle build`を実行するとbuild/libs/ 以下に作成されるjarを対象に，java -jar ???.jar でもSpringBootWebアプリケーションを起動できる
- http://localhost:8000/ にアクセスしたときになにかWebページが表示されていればOK．

# Samples(シンプルなGET/POST)
- HTTP/GET,POSTを利用したWebアプリケーションの作成方法

## [Sample1-1]templateを利用したhtmlファイルの表示(HTTP/GET)
- 特定のURLリクエストに対して静的なhtmlを返すアプリケーション

### 参考
- https://qiita.com/yama9112/items/ff829561238440437b99

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/23ac2c848ae671fe810f6ee09eeb3a805c975b8b
- Sample1Controller.java
- sample1.html

### 関連する機能
- @Controller
- @RequestMapping

### 動作確認
- http://localhost:8000/sample1 をブラウザで表示する
- HelloWorldと書かれたHTMLがブラウザに表示されればOK

## [Sample1-2] java-html間の値の受け渡し(HTTP/POST, タイムリーフ)
- Webページのフォームで入力した値をjavaにPOSTし，処理した結果をhtmlで受け取って表示する．

### 参考
- https://pointsandlines.jp/java/springboot-request-param
  - Controllerでリクエストパラメーターを受け取る
- https://qiita.com/NagaokaKenichi/items/c6d1b76090ef5ef39482
  - タイムリーフのチートシート

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/93d39136181d84380b5e0f346ac0e2870282019e
- Sample12Controller.java
- sample12.html

### 関連する機能
- @Controller
- @RequestMapping (クラス)
- @PostMapping 及び @RequestParam
- @GetMapping
- ModelMapを利用したJavaからHTMLへの値渡し

### 動作確認
- http://localhost:8000/sample12 をブラウザで表示する
- フォーム（テキストボックス）と送信ボタンが表示されるので，数字を入力して送信すると，フォームの下に`GET 1111`のように値が2行表示されればOK．

# Samples(RestAPIの作成)
- urlでリクエストをかけると，htmlではなく何らかの値や文字列が返ってくるRestAPIを実装する

## [Sample2-1] RestControllerの基本的な利用方法
- Classにapiという名前をつけて，メソッドにrest21という名前をつける．
- /api/rest21 にGETリクエストすると，Javaのrest21メソッドの返り値がかえってくる(HTMLではない)

### 参考
- https://qiita.com/sugaryo/items/5695bfcc21365f429767

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/11fd7ab2ff93a7fed61e6a5c77e2a95b0b4c1076
- Sample2RestController.java

### 関連する機能
- @RestController
- @RequestMapping
- @GetMapping

### 動作確認
- http://localhost:8000/api/sample21 をブラウで表示する，あるいはbashターミナルで下記のように実行したときに，`Hello sample21!` と表示されればOK

```
$ curl -s http://localhost:8000/api/sample21
Hello sample21!
```
- curlの`-s` オプションはプログレス情報を表示しないためのもの

## [Sample2-2] パラメータを渡してRestAPIを呼ぶ方法
- パスパラメータ，クエリパラメータの2種類の方法でRestAPIを呼び，Javaに値を渡す方法
  - RestAPI以外でも使える

### 参考
- https://qiita.com/sugaryo/items/5695bfcc21365f429767

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/30f170578d503e81cde655c5c3aedbbfc82c28cc
- Sample2RestController.java

### 関連する機能
- @RestController
- @RequestMapping
- @GetMapping
- パスパラメータ：@PathVariable
- クエリパラメータ：@RequestParam

### 動作確認
- bashターミナルで下記のようになればOK．ブラウザでも確認できる．
- 上2つがパスパラメータ，3つ目がクエリパラメータ．

```
$ curl -s http://localhost:8000/api/sample22/hoge
受け取ったパラメータはhogeです
$ curl -s http://localhost:8000/api/sample22/hoge/fuga
受け取ったパラメータはhogeとfugaです
$ curl -s http://localhost:8000/api/sample22?param=ora
受け取ったクエリパラメータはoradayo
```
- curlの`-s` オプションはプログレス情報を表示しないためのもの

# Samples(ベーシック認証)

## [Sample3-1]最もシンプルなベーシック認証
- 特定のURLにアクセスする際にID・パスワードでの認証を行う

### 参考
- https://www.memory-lovers.blog/entry/2016/05/15/142600
- https://codezine.jp/article/detail/11703

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/4e8b7604a77894699e56a5aec0674f555513d1e7
- Sample3BasicAuthConfiguration.java
  - antMatchers()のところをanyRequest()にするとすべてのリクエストについてベーシック認証がかかる．
    - 参考：https://github.com/igakilab/springbootsamples/commit/201f416fca7223566158586a98664deffc3fcc33
  - ユーザアカウントを複数追加したい場合は，and().withUser()...と続けると良い
    - 参考：https://github.com/igakilab/springbootsamples/commit/0b7b4c6032f6bfd6b0c66ec6c90190af27e560fc
  - passwordに`{noop}`とつけると平文のパスワードになる．本来はエンコーダーを利用したほうが良い．
    - 参考：https://qiita.com/delaware/items/f30452007f6c6bd6e09d
- Sample3Controller.java
- sample31.html

### 関連する機能
- ベーシック認証
  - アカウントの追加
  - 指定したURLリクエストを対象とした認証の追加
- @Configuration
- @EnableWebSecurity // securityモジュールを利用するためのアノテーション

### 動作確認
- ブラウザで `http://localhost:8000/sample3/sample31` にアクセスする
- ベーシック認証のダイアログが表示されるので，user/password と入力する．
- `Authenticated!` と表示されればOK

## [Sample3-2]ベーシック認証時にログインユーザ名を取得する方法

### 参考
- https://www.codeflow.site/ja/article/spring-security__get-current-logged-in-username-in-spring-security

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/617318246f2bfec5fadf7075d9fa2e35b3793d09
- Sample3Controller.java
- sample32.html

### 関連する機能
- Principalを利用したログインユーザ情報の取得
- タイムリーフを利用したModelMapからの値の取得

### 動作確認
- http://localhost:8000/sample3/sample32 にブラウザでアクセスする
- ベーシック認証のダイアログが表示されるので，user/password と入力する
  - すでにログインしていたらダイアログは表示されない
- `Hello user`と表示されたらOK（userはログインID）．

## [Sample3-3]フォームでのログインとログアウト
- フォームでログインし，logoutリクエストでログアウトを行うサンプル

### 参考
- https://www.memory-lovers.blog/entry/2016/05/15/142600

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/a281ff07b4e64791f5bdbba99b032e756538ff0a
- Sample3BasicAuthConfiguration.java

### 関連する機能
- SpringBootのformLogin/logout機能の利用

### 動作確認
- http://localhost:8000/sample3/sample31 にブラウザでアクセスする
- SpringBootの提供するログインフォーム(ベーシック認証のダイアログではない)が表示されるので，user/password と入力する．
- `Authenticated!` と表示されればOK
- http://localhost:8000/logout にブラウザでアクセスすると，サインイン情報が削除されて再度ログインフォームが表示される．

## [Sample3-4]InMemory認証でのユーザの追加
- user2,user3,adminユーザを追加してみる

### 参考
- https://teachingprogramming.net/archives/199
- https://www.memory-lovers.blog/entry/2016/05/15/142600
- https://qiita.com/aikumi/items/256b7892effd5c92a39f
- 複数ユーザの設定を.and()でつないでも良いし，auth.inMemoryAuthentication().withUserを複数個書いても良い．この実装サンプルでは後者

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/90213bc3e408e70fcd4ec6122035b968d0a92a7c
- Sample3BasicAuthConfiguration.java

### 関連する機能
- SpringBootのauth.inMemoryAuthentication().withUser

### 動作確認
- http://localhost:8000/sample3/sample32 にブラウザでアクセスする
- SpringBootの提供するログインフォーム(ベーシック認証のダイアログではない)が表示されるので，Sample3BasicAuthConfiguration.javaで実装した下記ユーザでログインできるか確認する

```java
    auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    auth.inMemoryAuthentication().withUser("user2").password("{noop}password2").roles("USER");
    auth.inMemoryAuthentication().withUser("user3").password("{noop}password3").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
```

- `Hello user` など，ログインしたユーザ名が表示されればOK

# Samples(データベースとの連携)

## [Sample4-1]DBのテーブル設定，値登録とselectによる取得
- schema.sqlの内容でテーブルを構築し，data.sqlの内容で初期データを登録する．
- DBからSELECT文で値を取得し，Fruitsオブジェクトに格納する処理をMybatisのマッパー機能を利用して実装する．

### 参考
- https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478
- https://teratail.com/questions/99983
  - 日本語の取り扱いについて
- https://mybatis.org/spring/ja/mappers.html
  - MapperクラスのオブジェクトはSpringBootが自動的に作成してくれるので，必要なときにMapperクラスのオブジェクトを引数に持つコンストラクタを定義すれば良い

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/c13b2a1fd5170dcb24214abe4fb3a2cc5ecb85df
- Fruits.java
- FruitsMapper.java
  - Fruitsオブジェクトの内容とDBの内容をFruitsMapperインタフェースを利用して関連付ける
- schema.sql
  - DBの初期構造（要はCreate Table)
- data.sql
  - DBの初期データ（Insert）
- Sample4Controller.java
- この例ではすでに実装されているが，application.propertiesで文字コード(utf8)の設定(`spring.datasource.sql-script-encoding=UTF-8`)とbuild.gradleのdependenciesに下記の追記が必要
```gradle
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1'
	runtimeOnly 'com.h2database:h2'
```
  - これが記述されているとH2DBの場合はあらゆるDB接続関連の設定をSpringBootが自動でやってくれるようになる．

### 関連する機能
- @Controller
- @GetMapping
- Mybatisのmapper interface
- @Transactional
- @Mapper
- @Select

### 動作確認
- http://localhost:8000/sample41 にアクセスすると，ターミナルに下記が表示されればOK．ブラウザにはFruits Listとだけ表示される．

```
さがほのか
10
5.8
いちご
false
```
- Sample4Controllerクラスのsample41GetFruitsメソッド内でDBから値を取得してFruitsオブジェクトに格納し，表示している．

## [Sample4-2]DBの値を取得し，GETでHTMLに渡して表示する方法

### 参考
- https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478
- https://www.shookuro.com/entry/2017/05/02/120110
  - ModelMapへの独自クラスのオブジェクトを追加する方法

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/66b5d20a52480d187bcb8b31312f4ab743454461
- Sample4Controller.java
- sample4.html

### 関連する機能
- @Controller
- @Transactional
- @GetMapping
- タイムリーフを利用した値の表示

### 動作確認
- ブラウザで http://localhost:8000/sample42 にアクセスすると，ブラウザにFruits Listの下に下記が2回繰り返して表示されればOK．


```
さがほのか
10
5.8
いちご
false
```
- Sample4Controllerクラスのsample42GetFruitsメソッド内でDBから値を取得してFruitsオブジェクトに格納し，ModelMapオブジェクトに渡してhtmlから参照している．

## [Sample4-3] フォームでPOSTしたデータをDBに登録する
- オブジェクトごとPOSTでデータをHTMLからJavaに渡し，insert文をmapperインタフェースを利用して実行する

### 参考
- https://qiita.com/kazuki43zoo/items/ea79e206d7c2e990e478#mybatisdemoapplication%E3%81%AE%E4%BF%AE%E6%AD%A3%E3%81%A8spring-boot%E3%82%A2%E3%83%97%E3%83%AA%E3%82%B1%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%AE%E8%B5%B7%E5%8B%95
  - insert及びinsert時のkeyのauto incrementに関するサンプル
- https://qiita.com/yukihane/items/3effe753ce01a2cadd84
  - H2DBのWebコンソール利用のための設定について

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/fc4c286802a72ee6eed5db69169348e80d51d85d
- application.properties
  - DB関連の設定
- Sample3BasicAuthConfiguration.java
  - csrfやX-Frame-Optionsの設定
- FruitsMapper.java
  - INSERT文
- Sample4Controller.java
- sample43.html

### 関連する機能
- @GetMapping
- @PostMapping
- @ModelAttribute
- @Insert
- @Options
- @Transactional
  - @TransactionalをDBに書き込みを行う場合はつけておくと良いらしい（失敗した際に自動でロールバックしてくれる）

### 動作確認
- http://localhost:8000/sample43 にブラウザでアクセスし，名前に果物の名前を数に数値を入れて「送信」ボタンをクリックするとターミナルに以下のように入力した果物名や数値が表示されればOK
- フォームに入力して「送信」すると，id2として（auto increment）送信した内容がDBに登録され，それがそのままフルーツ2としてターミナルに表示される

```
ぶどう
100
0.0
null
false
```

### 動作確認（H2DBコンソール）
- http://localhost:8000/h2-console にアクセスし，application.propertiesの以下の項目に従って入力する
  - [Saved Settings] Generic H2(Embedded)
  - [Driver Class] org.h2.Driver
  - [JDBR URL] jdbc:h2:mem:testdb
  - [User Name] sa
- Connectをクリックするとjdbc:h2:mem:testdbに接続される．
- FRUITSというテーブルが作成されているので選択し，SELECT文などをRunさせると，テーブルにデータがINSERTされていることが確認できる．
- Sample3BasicAuthConfiguration.javaに設定したようにCSRFとX-Frameの設定を解除しないとh2-consoleは正しくConnectできない．

```java
spring.datasource.url=jdbc:h2:mem:testdb
# H2DBを利用する場合のドライバ名，ユーザ名，パスワード（なし）
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

## [Sample4-4] DBから複数の値をArrayListで取得し，htmlで表示するサンプル

### 参考
- https://qiita.com/NagaokaKenichi/items/c6d1b76090ef5ef39482#%E7%B9%B0%E3%82%8A%E8%BF%94%E3%81%97%E3%83%AB%E3%83%BC%E3%83%97
  - タイムリーフにおける繰り返し処理やステータス変数(stat)について

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/c9914b2fc6e25a3a0e338ce3b26714e55e7f8658
- Sample4Controller.java
- FruitsMapper.java
- sample44.html

### 関連する機能
- @Select
- @GetMapping
- Mapperを利用したFruitsオブジェクトのArrayList取得

### 動作確認
- http://localhost:8000/sample43 にアクセスし，果物を追加で登録する
- http://localhost:8000/sample44 にアクセスし，下記のようにブラウザにFruitsのリストが表示されればOK

```
index:0 id:1 さがほのか 10 5.8 いちご false
index:1 id:2 レモン 100 0.0 false
```
- 最初のindexはステータス変数(stat.index)の値．他のステータス変数については参考資料参照．

# Samples(非同期呼び出し)

## [Sample5-1] @Asyncを利用した非同期処理
- URLにアクセスすると一瞬でレスポンスがあるが，実際の処理はそのあと行われる

### 参考
- https://qiita.com/aono-masashi/items/0ef2a0ddc8d901ff27dd
  - @Asyncの使い方

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/91f99fd6dd87d46154f69d2363c06865d0d6a16b
- DemoApplication.java
- Sample5RestSseController.java
  - この時点ではまだSse使わず
- AsyncService.java
  - 非同期処理が行われるメソッドの実装

### 関連する機能
- @EnableAsync // 非同期処理のためのアノテーション
- @RestController
- @RequestMapping("sample5")
- @GetMapping
- @Autowired
- @Service
- @Async

### 動作確認
- `curl -i -s -N http://localhost:8000/sample5/sample51` と実行すると，すぐに結果(`Tue Feb 25 12:05:50 JST 2020
`などの現在時刻)が返ってきて，内部の処理自体は5秒後に完了していればOK．async startからasync endまでgradleを実行したターミナルに表示されている．
  - -i:Respnse Header, Body 両方を出力
  - -s:silent mode
  - -N: No buffer
- 同じURLにブラウザでアクセスしてもOK

## [Sample5-2] Push型の非同期処理
- ブラウザから対象のAPIを呼び出すと，開いている間Push形式でJava側の処理が終わるたびにデータをブラウザで受け取って表示することができる．
- サーバ->クライアントへの通信のみ対応．
- IEとEdgeでは対応してないっぽい．

### 参考
- Java側
  - https://qiita.com/kazuki43zoo/items/53b79fe91c41cc5c2e59
  - https://www.codeflow.site/ja/article/spring-mvc-sse-streams
  - https://developer.mozilla.org/ja/docs/Web/API/Server-sent_events/Using_server-sent_events
- JS側
  - https://uhyohyo.net/javascript/13_2.html
  - https://developer.mozilla.org/ja/docs/Web/API/EventSource
    - EventSourceについて
- その他サンプル実装：https://github.com/igakilab/springboot_samples/commit/8149268a777e03bce7dfda0c6bba3ef28df52ffe
  - 確認1: `curl -i -s -N http://localhost:8000/api/streaming?eventNumber=5\&intervalSec=1`
  - 確認2: `curl -i -s -N http://localhost:8000/api/sse`
    - SseController内の一部の処理が非同期に呼び出される(L28-L43)．ただ，一部を非同期にするためにConcurrentパッケージのExecutorServiceが必要なのでおすすめしない

### 関連するファイル
- 実装：https://github.com/igakilab/springbootsamples/commit/3aadeb619671712ae291ac093da8f438bdcb99d3
- Sample5RestSseController.java
- AsyncService.java
- sample52-1.html
  - 同期呼び出し（一般的なAjax呼び出し）．PUSHではない．
- sample52-2.html
  - EventSourceを利用した非同期呼び出し（PUSH）
  - サーバからメッセージが送られるたびに受け付ける

### 関連する機能
- Java側
  - emitter.send()
    - 対象メソッドの引数に与えられたSseEmitterにsend()で引数として他クラスのオブジェクトや文字列を与えることで，javascript側でオブジェクトの場合はjsonオブジェクトとして，文字列の場合は文字列として受け取ることができる．
  - emitter.complete()
    - これを呼び出すことで，emitterを利用して呼び出し処理が明示的に終了される．多分呼び出さないとemitterが終了されないままで，再利用できなくなる気がする．
    - また，これが呼び出されていると，JS側でEventSourceに指定されたapiが何度も呼び出されて，streamingメソッドも何度も呼び出されるが，complete()していないと，streamingメソッドは再度呼び出されることはなくなる（正確には呼ばれていてもemitterが機能しない？）．
  - 発生する例外について
    - asyncService.async()内の処理を実行している最中にブラウザが終了する等でクライアントとの接続が切れた場合，以下のような例外が発生する．
      - [組み込みTomcat] `java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state [MUST_DISPATCH]`
      - [組み込みjetty]`org.eclipse.jetty.io.EofException: null`
      - TomcatのほうはSpringbootで発生してる？のか，catchできない．
      - jettyのほうはemitter.send()でIOExceptionとして発生するので，catchすればクライアント切断時の処理を正しく実装できる．
- EventSource(JS側)
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

### 動作確認
- `curl -i -s -N http://localhost:8000/sample5/sample52` と実行すると下記のようなヘッダやレスポンスが返る
  - -i:Respnse Header, Body 両方を出力
  - -s:silent mode
  - -N: No buffer．これがついていないとデータがまとめて返ってくる
  - text/event-streamになっていること，dataがemitter.sendのタイミングで送信されてくることを確認する

```sh
HTTP/1.1 200 OK
Date: Wed, 26 Feb 2020 00:29:08 GMT
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
Content-Type: text/event-stream;charset=UTF-8
Transfer-Encoding: chunked

data:{"id":0,"name":"メロン","num":100,"weight":1.7,"details":null,"sent":false}

data:{"id":0,"name":"メロン","num":100,"weight":1.7,"details":null,"sent":false}

data:{"id":0,"name":"メロン","num":100,"weight":1.7,"details":null,"sent":false}

data:{"id":0,"name":"メロン","num":100,"weight":1.7,"details":null,"sent":false}
```
- ブラウザで`http://localhost:8000/sample5/sample52`にアクセスすると↑と同様emitter.sendのタイミングでデータが送信される．10回送信された時点で終了する．
- ブラウザで`http://localhost:8000/sample52-1.html`にアクセスするとasyncService.async52()の処理がすべて完了後(約20秒後)にブラウザにすべてのデータ(10個分)が表示される．emitterがほぼ意味がない状態．
- ブラウザで`http://localhost:8000/sample52-2.html`にアクセスすると，emitter.sendが実行されるたびにデータが画面に1つずつ表示される．また，一通り終わったあと続けてsample52が再呼び出しされるため，ブラウザを表示している限りデータを受信し続ける．
