package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangcheEntity;
import java.util.Map;

/**
 * 相册信息 服务类
 * @author 
 * @since 2021-03-30
 */
public interface XiangcheService extends IService<XiangcheEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}