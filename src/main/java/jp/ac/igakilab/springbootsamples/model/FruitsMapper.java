package jp.ac.igakilab.springbootsamples.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * FruitsMapper．FruitsオブジェクトのデータをDBと関連付けるためのマッパーインタフェース @Mapperアノテーションがマッパーインタフェースであることを示す．
 */
@Mapper
public interface FruitsMapper {

  /**
   * @Selectがセレクト文であることを示す．
   * idを引数にしてDBを対象にSELECT文を実行し，SELECT文の結果をFruitsオブジェクトに格納して返すメソッド．
   * DBのフィールド名とFruitsクラスのフィールド名は一緒が望ましい．
   *
   * @param id がメソッドの引数．@Selectの引数に記述するSELECT文に#{id}と記述することで利用できる．
   * @return DBから取り出した値をFruitsオブジェクトに格納して返す．
   */
  @Select("SELECT id, name,num,weight,details,sent FROM fruits WHERE id = #{id}")
  Fruits select(int id);

  /**
   * @InsertがInsert文であることを示す．
   * #{name}などは，下のinsert文の引数で与えられているFruitsクラスのオブジェクトfruitに含まれるnameフィールドなどの値を示している
   * ここで@Optionsはidフィールドをkeyとして，数値を自動インクリメントして自動生成するように設定している
   */
  @Insert("INSERT INTO fruits (name,num,weight,details,sent) VALUES (#{name}, #{num}, #{weight}, #{details}, #{sent})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Fruits fruit);
}
