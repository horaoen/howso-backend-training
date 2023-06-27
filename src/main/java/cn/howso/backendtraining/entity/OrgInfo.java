package cn.howso.backendtraining.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("t_org_info")
public class OrgInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 组织机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 组织级别
     */
    private Integer orgLevel;

    /**
     * 上级机构标识
     */
    private String orgParentCode;

    /**
     * 组织机构状态
     */
    private Integer enterpType;

    /**
     * 组织类别
     */
    private Integer orgStatus;

    /**
     * 排序字段
     */
    private Integer orgChange;

    /**
     * 地区级别
     */
    private Integer orgRelation;

    /**
     * 地区标识
     */
    private Integer orgRemarks;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateUser;

    /**
     * 删除标记
     */
    @TableLogic
    private Boolean deleteMark;

    private String orgSort;
}
