package com.entity.model;

import com.entity.XiangcheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 相册信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-30
 */
public class XiangcheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 相册编号
     */
    private String odd;


    /**
     * 相册名称
     */
    private String xcname;


    /**
     * 相册封面
     */
    private String imgPhoto;


    /**
     * 相册主人
     */
    private Integer yonghuId;


    /**
     * 图片数量
     */
    private Integer number;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuanjianTime;


    /**
     * 相册描述
     */
    private String xiangcheContent;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：相册编号
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 设置：相册编号
	 */
    public void setOdd(String odd) {
        this.odd = odd;
    }
    /**
	 * 获取：相册名称
	 */
    public String getXcname() {
        return xcname;
    }


    /**
	 * 设置：相册名称
	 */
    public void setXcname(String xcname) {
        this.xcname = xcname;
    }
    /**
	 * 获取：相册封面
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 设置：相册封面
	 */
    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 获取：相册主人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：相册主人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：图片数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 设置：图片数量
	 */
    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getChuanjianTime() {
        return chuanjianTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setChuanjianTime(Date chuanjianTime) {
        this.chuanjianTime = chuanjianTime;
    }
    /**
	 * 获取：相册描述
	 */
    public String getXiangcheContent() {
        return xiangcheContent;
    }


    /**
	 * 设置：相册描述
	 */
    public void setXiangcheContent(String xiangcheContent) {
        this.xiangcheContent = xiangcheContent;
    }

    }
