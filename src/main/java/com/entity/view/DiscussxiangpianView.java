package com.entity.view;

import com.entity.DiscussxiangpianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 相片信息评论表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-30
 */
@TableName("discussxiangpian")
public class DiscussxiangpianView extends DiscussxiangpianEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public DiscussxiangpianView() {

	}

	private String xpname;
	private String yhname;

	public String getXpname() {
		return xpname;
	}

	public void setXpname(String xpname) {
		this.xpname = xpname;
	}

	public String getYhname() {
		return yhname;
	}

	public void setYhname(String yhname) {
		this.yhname = yhname;
	}

	public DiscussxiangpianView(DiscussxiangpianEntity discussxiangpianEntity) {
		try {
			BeanUtils.copyProperties(this, discussxiangpianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}














}
