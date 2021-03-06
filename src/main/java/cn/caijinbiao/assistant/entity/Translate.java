package cn.caijinbiao.assistant.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import cn.caijinbiao.assistant.entity.BaseEntity;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jinbiaocai
 * @since 2018-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_translate")
public class Translate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_id", type = IdType.AUTO)
    private Long id;
    @TableField("f_source")
    private String source;
    @TableField("f_target")
    private String target;
    @TableField("f_type")
    private Long type;
    @TableField("f_isp")
    private Long isp;
    @TableField("f_is_delete")
    @TableLogic
    private Integer isDelete;
    @TableField("f_name")
    private String name;


}
