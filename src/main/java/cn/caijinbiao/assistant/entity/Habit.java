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
@TableName("t_habit")
public class Habit extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_id", type = IdType.AUTO)
    private Long id;
    @TableField("f_translate")
    private Long translate;
    @TableField("f_user")
    private Long user;
    @TableField("f_count")
    private Integer count;
    @TableField("f_is_delete")
    @TableLogic
    private Integer isDelete;
}
