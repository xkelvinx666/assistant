package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.mapper.HabitMapper;
import cn.caijinbiao.assistant.model.Habit;
import cn.caijinbiao.assistant.model.HabitExample;
import cn.caijinbiao.assistant.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {
    @Autowired
    HabitMapper habitMapper;

    @Override
    public void addHabit(long translate, long user) {
        Habit habit = new Habit();
        habit.setTranslate(translate);
        habit.setUser(user);
        habit.setCount(0);
        habitMapper.insert(habit);
    }

    @Override
    public void updateHabit(long translate, long user) {
        HabitExample habitExample = new HabitExample();
        HabitExample.Criteria criteria = habitExample.createCriteria();
        criteria.andTranslateEqualTo(translate);
        criteria.andUserEqualTo(user);
        List<Habit> habits = habitMapper.selectByExample(habitExample);
        if(null == habits || 0 == habits.size()) {
            addHabit(translate, user);
            habits = habitMapper.selectByExample(habitExample);
        }
        Habit habit = habits.get(0);
        habit.setCount(habit.getCount() + 1);
        habitMapper.updateByPrimaryKey(habit);
    }
}
