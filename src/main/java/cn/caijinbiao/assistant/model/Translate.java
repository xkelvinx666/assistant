package cn.caijinbiao.assistant.model;

public class Translate {
    private Long id;

    private String source;

    private String target;

    private Long type;

    private Long isp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getIsp() {
        return isp;
    }

    public void setIsp(Long isp) {
        this.isp = isp;
    }
}