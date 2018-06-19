package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.model.Type;
import cn.caijinbiao.assistant.model.TypeExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TypeMapper {
    @SelectProvider(type=TypeSqlProvider.class, method="countByExample")
    long countByExample(TypeExample example);

    @DeleteProvider(type=TypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TypeExample example);

    @Delete({
        "delete from t_type",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_type (f_name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Type record);

    @InsertProvider(type=TypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Type record);

    @SelectProvider(type=TypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Type> selectByExample(TypeExample example);

    @Select({
        "select",
        "f_id, f_name",
        "from t_type",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Type selectByPrimaryKey(Long id);

    @UpdateProvider(type=TypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    @UpdateProvider(type=TypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    @UpdateProvider(type=TypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Type record);

    @Update({
        "update t_type",
        "set f_name = #{name,jdbcType=VARCHAR}",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Type record);
}