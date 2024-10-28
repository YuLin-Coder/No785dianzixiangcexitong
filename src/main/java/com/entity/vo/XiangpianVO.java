package com.entity.vo;

import com.entity.XiangpianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 相片信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("xiangpian")
public class XiangpianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 相册编号
     */

    @TableField(value = "xiangche_id")
    private Integer xiangcheId;


    /**
     * 相片名称
     */

    @TableField(value = "xpname")
    private String xpname;


    /**
     * 拍摄地点
     */

    @TableField(value = "paishedidian")
    private String paishedidian;


    /**
     * 相片
     */

    @TableField(value = "xpimg_photo")
    private String xpimgPhoto;


    /**
     * 相片拍摄人
     */

    @TableField(value = "paisheren")
    private String paisheren;


    /**
     * 相片大小
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xpsize")
    private Date xpsize;


    /**
     * 相片分类
     */

    @TableField(value = "fenlei_types")
    private Integer fenleiTypes;


    /**
     * 相片描述
     */

    @TableField(value = "xiangpian_content")
    private String xiangpianContent;


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
    public Integer getXiangcheId() {
        return xiangcheId;
    }


    /**
	 * 获取：相册编号
	 */

    public void setXiangcheId(Integer xiangcheId) {
        this.xiangcheId = xiangcheId;
    }
    /**
	 * 设置：相片名称
	 */
    public String getXpname() {
        return xpname;
    }


    /**
	 * 获取：相片名称
	 */

    public void setXpname(String xpname) {
        this.xpname = xpname;
    }
    /**
	 * 设置：拍摄地点
	 */
    public String getPaishedidian() {
        return paishedidian;
    }


    /**
	 * 获取：拍摄地点
	 */

    public void setPaishedidian(String paishedidian) {
        this.paishedidian = paishedidian;
    }
    /**
	 * 设置：相片
	 */
    public String getXpimgPhoto() {
        return xpimgPhoto;
    }


    /**
	 * 获取：相片
	 */

    public void setXpimgPhoto(String xpimgPhoto) {
        this.xpimgPhoto = xpimgPhoto;
    }
    /**
	 * 设置：相片拍摄人
	 */
    public String getPaisheren() {
        return paisheren;
    }


    /**
	 * 获取：相片拍摄人
	 */

    public void setPaisheren(String paisheren) {
        this.paisheren = paisheren;
    }
    /**
	 * 设置：相片大小
	 */
    public Date getXpsize() {
        return xpsize;
    }


    /**
	 * 获取：相片大小
	 */

    public void setXpsize(Date xpsize) {
        this.xpsize = xpsize;
    }
    /**
	 * 设置：相片分类
	 */
    public Integer getFenleiTypes() {
        return fenleiTypes;
    }


    /**
	 * 获取：相片分类
	 */

    public void setFenleiTypes(Integer fenleiTypes) {
        this.fenleiTypes = fenleiTypes;
    }
    /**
	 * 设置：相片描述
	 */
    public String getXiangpianContent() {
        return xiangpianContent;
    }


    /**
	 * 获取：相片描述
	 */

    public void setXiangpianContent(String xiangpianContent) {
        this.xiangpianContent = xiangpianContent;
    }

}
