package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.XiangcheDao;
import com.entity.XiangcheEntity;
import com.service.XiangcheService;
import com.entity.view.XiangcheView;

/**
 * 相册信息 服务实现类
 * @author 
 * @since 2021-03-30
 */
@Service("xiangcheService")
@Transactional
public class XiangcheServiceImpl extends ServiceImpl<XiangcheDao, XiangcheEntity> implements XiangcheService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XiangcheView> page =new Query<XiangcheView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
