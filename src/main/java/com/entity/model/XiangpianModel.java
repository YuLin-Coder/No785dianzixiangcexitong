package com.entity.model;

import com.entity.XiangpianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 相片信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class XiangpianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 相册编号
     */
    private Integer xiangcheId;


    /**
     * 相片名称
     */
    private String xpname;


    /**
     * 拍摄地点
     */
    private String paishedidian;


    /**
     * 相片
     */
    private String xpimgPhoto;


    /**
     * 相片拍摄人
     */
    private String paisheren;


    /**
     * 相片大小
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xpsize;


    /**
     * 相片分类
     */
    private Integer fenleiTypes;


    /**
     * 相片描述
     */
    private String xiangpianContent;


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
    public Integer getXiangcheId() {
        return xiangcheId;
    }


    /**
	 * 设置：相册编号
	 */
    public void setXiangcheId(Integer xiangcheId) {
        this.xiangcheId = xiangcheId;
    }
    /**
	 * 获取：相片名称
	 */
    public String getXpname() {
        return xpname;
    }


    /**
	 * 设置：相片名称
	 */
    public void setXpname(String xpname) {
        this.xpname = xpname;
    }
    /**
	 * 获取：拍摄地点
	 */
    public String getPaishedidian() {
        return paishedidian;
    }


    /**
	 * 设置：拍摄地点
	 */
    public void setPaishedidian(String paishedidian) {
        this.paishedidian = paishedidian;
    }
    /**
	 * 获取：相片
	 */
    public String getXpimgPhoto() {
        return xpimgPhoto;
    }


    /**
	 * 设置：相片
	 */
    public void setXpimgPhoto(String xpimgPhoto) {
        this.xpimgPhoto = xpimgPhoto;
    }
    /**
	 * 获取：相片拍摄人
	 */
    public String getPaisheren() {
        return paisheren;
    }


    /**
	 * 设置：相片拍摄人
	 */
    public void setPaisheren(String paisheren) {
        this.paisheren = paisheren;
    }
    /**
	 * 获取：相片大小
	 */
    public Date getXpsize() {
        return xpsize;
    }


    /**
	 * 设置：相片大小
	 */
    public void setXpsize(Date xpsize) {
        this.xpsize = xpsize;
    }
    /**
	 * 获取：相片分类
	 */
    public Integer getFenleiTypes() {
        return fenleiTypes;
    }


    /**
	 * 设置：相片分类
	 */
    public void setFenleiTypes(Integer fenleiTypes) {
        this.fenleiTypes = fenleiTypes;
    }
    /**
	 * 获取：相片描述
	 */
    public String getXiangpianContent() {
        return xiangpianContent;
    }


    /**
	 * 设置：相片描述
	 */
    public void setXiangpianContent(String xiangpianContent) {
        this.xiangpianContent = xiangpianContent;
    }

    }
