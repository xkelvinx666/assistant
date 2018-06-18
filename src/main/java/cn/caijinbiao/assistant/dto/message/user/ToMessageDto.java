package cn.caijinbiao.assistant.dto.message.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

@Component
@Scope("prototype")
public class ToMessageDto extends BaseMessageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @JacksonXmlElementWrapper(localName = "Image")
    @JacksonXmlProperty(localName = "MediaId")
    private Collection<String> mediaId;
}
