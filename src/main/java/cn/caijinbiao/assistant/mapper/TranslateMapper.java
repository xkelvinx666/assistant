package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.model.Translate;
import cn.caijinbiao.assistant.model.TranslateExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TranslateMapper {
    @SelectProvider(type=TranslateSqlProvider.class, method="countByExample")
    long countByExample(TranslateExample example);

    @DeleteProvider(type=TranslateSqlProvider.class, method="deleteByExample")
    int deleteByExample(TranslateExample example);

    @Delete({
        "delete from t_translate",
        "where f_id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_translate (f_source, f_target, ",
        "f_type, f_isp)",
        "values (#{source,jdbcType=VARCHAR}, #{target,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{isp,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insert(Translate record);

    @InsertProvider(type=TranslateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insertSelective(Translate record);

    @SelectProvider(type=TranslateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="f_source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_isp", property="isp", jdbcType=JdbcType.VARCHAR)
    })
    List<Translate> selectByExample(TranslateExample example);

    @Select({
        "select",
        "f_id, f_source, f_target, f_type, f_isp",
        "from t_translate",
        "where f_id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="f_source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="f_isp", property="isp", jdbcType=JdbcType.VARCHAR)
    })
    Translate selectByPrimaryKey(String id);

    @UpdateProvider(type=TranslateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Translate record, @Param("example") TranslateExample example);

    @UpdateProvider(type=TranslateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Translate record, @Param("example") TranslateExample example);

    @UpdateProvider(type=TranslateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Translate record);

    @Update({
        "update t_translate",
        "set f_source = #{source,jdbcType=VARCHAR},",
          "f_target = #{target,jdbcType=VARCHAR},",
          "f_type = #{type,jdbcType=VARCHAR},",
          "f_isp = #{isp,jdbcType=VARCHAR}",
        "where f_id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Translate record);
}