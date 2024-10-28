package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 相册信息
 *
 * @author 
 * @email
 * @date 2021-03-30
 */
@TableName("xiangche")
public class XiangcheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangcheEntity() {

	}

	public XiangcheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 相册编号
     */
    @TableField(value = "odd")

    private String odd;


    /**
     * 相册名称
     */
    @TableField(value = "xcname")

    private String xcname;


    /**
     * 相册封面
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 相册主人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 图片数量
     */
    @TableField(value = "number")

    private Integer number;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chuanjian_time",fill = FieldFill.UPDATE)

    private Date chuanjianTime;


    /**
     * 相册描述
     */
    @TableField(value = "xiangche_content")

    private String xiangcheContent;


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
	 * 设置：相册编号
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 获取：相册编号
	 */

    public void setOdd(String odd) {
        this.odd = odd;
    }
    /**
	 * 设置：相册名称
	 */
    public String getXcname() {
        return xcname;
    }


    /**
	 * 获取：相册名称
	 */

    public void setXcname(String xcname) {
        this.xcname = xcname;
    }
    /**
	 * 设置：相册封面
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：相册封面
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：相册主人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：相册主人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：图片数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：图片数量
	 */

    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getChuanjianTime() {
        return chuanjianTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setChuanjianTime(Date chuanjianTime) {
        this.chuanjianTime = chuanjianTime;
    }
    /**
	 * 设置：相册描述
	 */
    public String getXiangcheContent() {
        return xiangcheContent;
    }


    /**
	 * 获取：相册描述
	 */

    public void setXiangcheContent(String xiangcheContent) {
        this.xiangcheContent = xiangcheContent;
    }

    @Override
    public String toString() {
        return "Xiangche{" +
            "id=" + id +
            ", odd=" + odd +
            ", xcname=" + xcname +
            ", imgPhoto=" + imgPhoto +
            ", yonghuId=" + yonghuId +
            ", number=" + number +
            ", chuanjianTime=" + chuanjianTime +
            ", xiangcheContent=" + xiangcheContent +
        "}";
    }
}
