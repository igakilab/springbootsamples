package jp.ac.igakilab.springbootsamples.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.ac.igakilab.springbootsamples.domain.Fruits;

/**
 * FruitsMapper
 */
@Mapper
public interface FruitsMapper {

  @Select("SELECT id, name,num,weight,details,sent FROM fruits WHERE id = #{id}")
  Fruits select(int id);
}
