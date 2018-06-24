package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.entity.Habit;
import cn.caijinbiao.assistant.service.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jinbiaocai
 * @since 2018-06-24
 */
public interface HabitService extends BaseService<Habit> {
    Habit updateHabit(long translate, long user);
}
