package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.entity.Habit;
import cn.caijinbiao.assistant.mapper.HabitMapper;
import cn.caijinbiao.assistant.service.HabitService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinbiaocai
 * @since 2018-06-24
 */
@Service
public class HabitServiceImpl extends BaseServiceImpl<HabitMapper, Habit> implements HabitService {

    @Override
    public Habit updateHabit(long translate, long user) {
        Habit habit = selectOne(new EntityWrapper<Habit>()
                .eq("f_translate", translate)
                .eq("f_user", user));
        if(null != habit) {
            habit.setCount(habit.getCount() + 1);
        }
        return habit;
    }
}
