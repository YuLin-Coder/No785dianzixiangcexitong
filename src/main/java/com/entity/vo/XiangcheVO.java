package com.entity.vo;

import com.entity.XiangcheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 相册信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-30
 */
@TableName("xiangche")
public class XiangcheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "chuanjian_time")
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

}
