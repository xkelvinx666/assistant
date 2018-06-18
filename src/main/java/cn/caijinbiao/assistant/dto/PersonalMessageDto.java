package cn.caijinbiao.assistant.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Component
@XmlRootElement
public class PersonalMessageDto {
    @XmlElement(name = "ToUserName")
    public String ToUserName;
    @XmlElement(name = "FromUserName")
    public String FromUserName;
    @XmlElement(name = "CreateTime")
    public String CreateTime;
    @XmlElement(name = "MsgType")
    public String MsgType;
    @XmlElement(name = "Content")
    public String Content;
    @XmlElement(name = "MsgId")
    public String MsgId;
}
