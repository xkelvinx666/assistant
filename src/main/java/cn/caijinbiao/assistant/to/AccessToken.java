package cn.caijinbiao.assistant.to;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Scope("singleton")
@Data
@Component
public class AccessToken implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 微信access_token
     */
    private String access_token;
    /**
     * 过期时间expiresIn
     */
    private long expires_in = 0;

    /**
     * 将微信返回的相对秒级过期时间转为绝对毫秒时间
     */
    public void setExpires_in(long relativeExpires) {
        this.expires_in = relativeExpires * 1000 + System.currentTimeMillis();
    }

    public long getExpires_in() {
        return this.expires_in - System.currentTimeMillis();
    }

    /**
     * 预留10秒过期时间用于重新请求微信服务器
     */
    public boolean isExpires() {
        return getExpires_in() < 10000;
    }
}
