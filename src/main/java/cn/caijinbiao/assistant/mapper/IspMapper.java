package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.model.Isp;
import cn.caijinbiao.assistant.model.IspExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IspMapper {
    @SelectProvider(type=IspSqlProvider.class, method="countByExample")
    long countByExample(IspExample example);

    @DeleteProvider(type=IspSqlProvider.class, method="deleteByExample")
    int deleteByExample(IspExample example);

    @Delete({
        "delete from t_isp",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_isp (f_name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Isp record);

    @InsertProvider(type=IspSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Isp record);

    @SelectProvider(type=IspSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Isp> selectByExample(IspExample example);

    @Select({
        "select",
        "f_id, f_name",
        "from t_isp",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Isp selectByPrimaryKey(Long id);

    @UpdateProvider(type=IspSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Isp record, @Param("example") IspExample example);

    @UpdateProvider(type=IspSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Isp record, @Param("example") IspExample example);

    @UpdateProvider(type=IspSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Isp record);

    @Update({
        "update t_isp",
        "set f_name = #{name,jdbcType=VARCHAR}",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Isp record);
}