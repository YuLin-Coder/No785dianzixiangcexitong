package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangpianEntity;
import java.util.Map;

/**
 * 相片信息 服务类
 * @author 
 * @since 2021-03-31
 */
public interface XiangpianService extends IService<XiangpianEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}