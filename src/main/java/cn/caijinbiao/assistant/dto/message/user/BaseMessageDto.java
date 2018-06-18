package cn.caijinbiao.assistant.dto.message.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "xml")
public class BaseMessageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @JacksonXmlProperty(localName = "ToUserName")
    @JacksonXmlCData
    private String toUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    @JacksonXmlCData
    private String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    private long createTime;
    @JacksonXmlProperty(localName = "MsgType")
    @JacksonXmlCData
    private String msgType;

    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    private String content;
    @JacksonXmlProperty(localName = "PicUrl")
    @JacksonXmlCData
    private String picUrl;
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;
    @JacksonXmlProperty(localName = "Format")
    @JacksonXmlCData
    private String format;
    @JacksonXmlProperty(localName = "Title")
    @JacksonXmlCData
    private String title;
    @JacksonXmlProperty(localName = "Description")
    @JacksonXmlCData
    private String description;
    @JacksonXmlProperty(localName = "Url")
    @JacksonXmlCData
    private String url;
}
