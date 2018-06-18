package cn.caijinbiao.assistant.dto.message.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class FromMessageDto extends BaseMessageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @JacksonXmlProperty(localName = "MsgId")

    private String msgId;
    @JacksonXmlProperty(localName = "Format")
    @JacksonXmlCData
    private String format;
    @JacksonXmlProperty(localName = "Recognition")
    @JacksonXmlCData
    private String recognition;
    @JacksonXmlProperty(localName = "ThumbMediaId")
    @JacksonXmlCData
    private String thumbMediaId;
    @JacksonXmlProperty(localName = "Location_X")
    @JacksonXmlCData
    private String locationX;
    @JacksonXmlProperty(localName = "Location_Y")
    @JacksonXmlCData
    private String locationY;
    @JacksonXmlProperty(localName = "Scale")
    @JacksonXmlCData
    private String scale;
    @JacksonXmlProperty(localName = "Label")
    @JacksonXmlCData
    private String label;
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;
}
