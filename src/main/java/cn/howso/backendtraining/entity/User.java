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

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author horaoen
 * @since 2023-06-27
 */
@Getter
@Setter
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 工号
     */
    private String empNo;

    /**
     * 职级
     */
    private String userRank;

    /**
     * 人员性质
     */
    private String userNature;

    /**
     * 人员层级
     */
    private String userLevel;

    /**
     * 排序
     */
    private String sortNo;

    /**
     * 所属组织编码
     */
    private String orgCode;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 身份证
     */
    private String identityCard;

    /**
     * 学历
     */
    private String degree;

    /**
     * 毕业院校
     */
    private String finishSchool;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 服务机构编码
     */
    private String serviceCode;

    /**
     * 管理区域
     */
    private String manageArea;

    /**
     * 服务区域
     */
    private String serviceArea;

    /**
     * 所属企业
     */
    private String corpCode;

    /**
     * 状态
     */
    private Integer status;

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
}
