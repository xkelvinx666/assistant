package cn.caijinbiao.assistant.to;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@Scope("prototype")
public class BroadcastMessageTo {
    private Map<String, Object> filter;
    private Map<String, String> text;
    private String msgtype;
}
