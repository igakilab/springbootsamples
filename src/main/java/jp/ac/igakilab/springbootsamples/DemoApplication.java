package jp.ac.igakilab.springbootsamples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.igakilab.springbootsamples.model.Fruits;
import jp.ac.igakilab.springbootsamples.model.FruitsMapper;

/**
 * CommandLineRunnerをimplementsし，runメソッドを実装すると，SpringBootアプリケーション起動時にそのrunメソッドを呼び出してくれる．sysoutはターミナルに表示される．
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  // FruitsMapperオブジェクトを宣言し，SpringBootApplicationクラス（要はこのクラス）の
  // コンストラクタの引数に渡せば，SpringBootがMapperオブジェクトを作成して代入してくれる
  // resourcesパッケージの直下にschema.sqlがあるとDBのスキーマを起動時に設定してくれる．data.sqlがあると初期データの投入を自動的にしてくれる．
  private final FruitsMapper fruitsMapper;

  public DemoApplication(FruitsMapper fruitsMapper) {
    this.fruitsMapper = fruitsMapper;
  }

  // Spring Boot起動時にCommandLineRunner#runメソッドが呼び出される
  // かんたんな動作確認や起動時の各種初期化処理に使える
  // 結果はgradleを実行するターミナルに表示される
  @Transactional // DBのトランザクション処理を利用したい場合につける
  @Override
  public void run(String... args) throws Exception {
    Fruits fruit = fruitsMapper.select(1);// IDが1のフルーツの情報をDBから取得する
    System.out.println(fruit.getName());
    System.out.println(fruit.getNum());
    System.out.println(fruit.getWeight());
    System.out.println(fruit.getDetails());
    System.out.println(fruit.isSent());
  }
}
