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
- gradle build -> gradle bootRun を実行すると組み込みTomcatでSpringBootアプリが起動する
  - build/libs/ 以下に作成されるjarを対象に，java -jar ???.jar でもSpringBootWebアプリケーションが起動する

## Samples
### templateを利用したhtmlファイルの表示
- 参考：https://qiita.com/yama9112/items/ff829561238440437b99
  - http://localhost:8080/sample

### RestControllerを利用したapiの定義と利用(GET)
- 参考：https://qiita.com/sugaryo/items/5695bfcc21365f429767
  - https://github.com/igakilab/springboot_samples/commit/dfb755c75f097ff1ef22293bf97173fc78c53ae3
- http://localhost:8000/api/hello
