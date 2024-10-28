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

import com.dao.DiscussxiangpianDao;
import com.entity.DiscussxiangpianEntity;
import com.service.DiscussxiangpianService;
import com.entity.view.DiscussxiangpianView;

/**
 * 相片信息评论表 服务实现类
 * @author 
 * @since 2021-03-30
 */
@Service("discussxiangpianService")
@Transactional
public class DiscussxiangpianServiceImpl extends ServiceImpl<DiscussxiangpianDao, DiscussxiangpianEntity> implements DiscussxiangpianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DiscussxiangpianView> page =new Query<DiscussxiangpianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
