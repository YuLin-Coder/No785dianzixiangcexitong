package com.entity.view;

import com.entity.XiangpianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 相片信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("xiangpian")
public class XiangpianView extends XiangpianEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 相片分类的值
		*/
		private String fenleiValue;



		//级联表 xiangche
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
			private Date chuanjianTime;
			/**
			* 相册描述
			*/
			private String xiangcheContent;

	public XiangpianView() {

	}

	public XiangpianView(XiangpianEntity xiangpianEntity) {
		try {
			BeanUtils.copyProperties(this, xiangpianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 相片分类的值
			*/
			public String getFenleiValue() {
				return fenleiValue;
			}
			/**
			* 设置： 相片分类的值
			*/
			public void setFenleiValue(String fenleiValue) {
				this.fenleiValue = fenleiValue;
			}




				//级联表的get和set xiangche
					/**
					* 获取： 相册编号
					*/
					public String getOdd() {
						return odd;
					}
					/**
					* 设置： 相册编号
					*/
					public void setOdd(String odd) {
						this.odd = odd;
					}
					/**
					* 获取： 相册名称
					*/
					public String getXcname() {
						return xcname;
					}
					/**
					* 设置： 相册名称
					*/
					public void setXcname(String xcname) {
						this.xcname = xcname;
					}
					/**
					* 获取： 相册封面
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 相册封面
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 相册主人
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 相册主人
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 图片数量
					*/
					public Integer getNumber() {
						return number;
					}
					/**
					* 设置： 图片数量
					*/
					public void setNumber(Integer number) {
						this.number = number;
					}
					/**
					* 获取： 创建时间
					*/
					public Date getChuanjianTime() {
						return chuanjianTime;
					}
					/**
					* 设置： 创建时间
					*/
					public void setChuanjianTime(Date chuanjianTime) {
						this.chuanjianTime = chuanjianTime;
					}
					/**
					* 获取： 相册描述
					*/
					public String getXiangcheContent() {
						return xiangcheContent;
					}
					/**
					* 设置： 相册描述
					*/
					public void setXiangcheContent(String xiangcheContent) {
						this.xiangcheContent = xiangcheContent;
					}






}
