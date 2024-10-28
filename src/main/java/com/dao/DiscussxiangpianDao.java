package com.dao;

import com.entity.DiscussxiangpianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxiangpianView;

/**
 * 相片信息评论表 Dao 接口
 *
 * @author 
 * @since 2021-03-30
 */
public interface DiscussxiangpianDao extends BaseMapper<DiscussxiangpianEntity> {

   List<DiscussxiangpianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
