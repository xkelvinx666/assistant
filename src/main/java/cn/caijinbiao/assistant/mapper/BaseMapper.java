package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.entity.BaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseMapper<T extends BaseEntity> extends com.baomidou.mybatisplus.mapper.BaseMapper<T> {
}
