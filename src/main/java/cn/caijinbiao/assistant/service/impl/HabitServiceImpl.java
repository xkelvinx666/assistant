package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.entity.Habit;
import cn.caijinbiao.assistant.mapper.HabitMapper;
import cn.caijinbiao.assistant.service.HabitService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
    public boolean insertHabit(long translate, long user) {
        Habit habit = new Habit();
        habit.setTranslate(translate);
        habit.setUser(user);
        return insert(habit);
    }


    @Override
    public Habit updateHabit(long translate, long user) {
        Wrapper<Habit> wrapper = new EntityWrapper<Habit>()
                .eq("f_translate", translate)
                .eq("f_user", user);
        Habit habit = selectOne(wrapper);
        if(null == habit && insertHabit(translate, user)) {
            habit = selectOne(wrapper);
        }
        habit.setCount(habit.getCount() + 1);
        updateById(habit);
        return habit;
    }
}
