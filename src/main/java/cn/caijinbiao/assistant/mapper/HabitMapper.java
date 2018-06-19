package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.model.Habit;
import cn.caijinbiao.assistant.model.HabitExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HabitMapper {
    @SelectProvider(type=HabitSqlProvider.class, method="countByExample")
    long countByExample(HabitExample example);

    @DeleteProvider(type=HabitSqlProvider.class, method="deleteByExample")
    int deleteByExample(HabitExample example);

    @Delete({
        "delete from t_habit",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_habit (f_translate, f_user, ",
        "f_count)",
        "values (#{translate,jdbcType=BIGINT}, #{user,jdbcType=BIGINT}, ",
        "#{count,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Habit record);

    @InsertProvider(type=HabitSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Habit record);

    @SelectProvider(type=HabitSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_translate", property="translate", jdbcType=JdbcType.BIGINT),
        @Result(column="f_user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="f_count", property="count", jdbcType=JdbcType.INTEGER)
    })
    List<Habit> selectByExample(HabitExample example);

    @Select({
        "select",
        "f_id, f_translate, f_user, f_count",
        "from t_habit",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="f_id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="f_translate", property="translate", jdbcType=JdbcType.BIGINT),
        @Result(column="f_user", property="user", jdbcType=JdbcType.BIGINT),
        @Result(column="f_count", property="count", jdbcType=JdbcType.INTEGER)
    })
    Habit selectByPrimaryKey(Long id);

    @UpdateProvider(type=HabitSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Habit record, @Param("example") HabitExample example);

    @UpdateProvider(type=HabitSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Habit record, @Param("example") HabitExample example);

    @UpdateProvider(type=HabitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Habit record);

    @Update({
        "update t_habit",
        "set f_translate = #{translate,jdbcType=BIGINT},",
          "f_user = #{user,jdbcType=BIGINT},",
          "f_count = #{count,jdbcType=INTEGER}",
        "where f_id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Habit record);
}