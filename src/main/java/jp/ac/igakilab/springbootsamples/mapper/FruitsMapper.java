package jp.ac.igakilab.springbootsamples.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import jp.ac.igakilab.springbootsamples.domain.Fruits;

/**
 * FruitsMapper
 */
@Mapper
public interface FruitsMapper {

  @Select("SELECT id, name,num,weight,details,sent FROM fruits WHERE id = #{id}")
  Fruits select(int id);

  @Insert("INSERT INTO fruits (name,num,weight,details,sent) VALUES (#{name}, #{num}, #{weight}, #{details}, #{sent})")
  @Options(useGeneratedKeys = true, keyProperty = "id") // idフィールドをkeyとして，数値を自動インクリメントして自動生成するようにOptionsで設定する
  void insert(Fruits fruits);

  @Select("SELECT * FROM fruits")
  ArrayList<Fruits> selectAll();
}
