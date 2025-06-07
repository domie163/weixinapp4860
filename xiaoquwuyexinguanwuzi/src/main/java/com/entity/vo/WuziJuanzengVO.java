package com.entity.vo;

import com.entity.WuziJuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资捐赠
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_juanzeng")
public class WuziJuanzengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 捐赠数量
     */

    @TableField(value = "wuzi_juanzeng_number")
    private Integer wuziJuanzengNumber;


    /**
     * 备注
     */

    @TableField(value = "wuzi_juanzeng_content")
    private String wuziJuanzengContent;


    /**
     * 审核状态
     */

    @TableField(value = "wuzi_juanzeng_yesno_types")
    private Integer wuziJuanzengYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "wuzi_juanzeng_yesno_text")
    private String wuziJuanzengYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：捐赠数量
	 */
    public Integer getWuziJuanzengNumber() {
        return wuziJuanzengNumber;
    }


    /**
	 * 获取：捐赠数量
	 */

    public void setWuziJuanzengNumber(Integer wuziJuanzengNumber) {
        this.wuziJuanzengNumber = wuziJuanzengNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getWuziJuanzengContent() {
        return wuziJuanzengContent;
    }


    /**
	 * 获取：备注
	 */

    public void setWuziJuanzengContent(String wuziJuanzengContent) {
        this.wuziJuanzengContent = wuziJuanzengContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getWuziJuanzengYesnoTypes() {
        return wuziJuanzengYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setWuziJuanzengYesnoTypes(Integer wuziJuanzengYesnoTypes) {
        this.wuziJuanzengYesnoTypes = wuziJuanzengYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getWuziJuanzengYesnoText() {
        return wuziJuanzengYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setWuziJuanzengYesnoText(String wuziJuanzengYesnoText) {
        this.wuziJuanzengYesnoText = wuziJuanzengYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
