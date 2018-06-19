package cn.caijinbiao.assistant.model;

public class Habit {
    private Long id;

    private Long translate;

    private Long user;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTranslate() {
        return translate;
    }

    public void setTranslate(Long translate) {
        this.translate = translate;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}