package cn.caijinbiao.assistant.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BroadcastMessageDto {
      private String errcode;
      private String errmsg;
      private int msg_id;
      private int msg_data_id;
}
