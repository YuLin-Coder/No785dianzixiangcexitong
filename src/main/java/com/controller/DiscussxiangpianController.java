package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.DiscussxiangpianEntity;

import com.service.DiscussxiangpianService;
import com.entity.view.DiscussxiangpianView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 相片信息评论表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-30
*/
@RestController
@Controller
@RequestMapping("/discussxiangpian")
public class DiscussxiangpianController {
    private static final Logger logger = LoggerFactory.getLogger(DiscussxiangpianController.class);

    @Autowired
    private DiscussxiangpianService discussxiangpianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = discussxiangpianService.queryPage(params);

        //字典表数据转换
        List<DiscussxiangpianView> list =(List<DiscussxiangpianView>)page.getList();
        for(DiscussxiangpianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DiscussxiangpianEntity discussxiangpian = discussxiangpianService.selectById(id);
        if(discussxiangpian !=null){
            //entity转view
            DiscussxiangpianView view = new DiscussxiangpianView();
            BeanUtils.copyProperties( discussxiangpian , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxiangpianEntity discussxiangpian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,discussxiangpian:{}",this.getClass().getName(),discussxiangpian.toString());
        Wrapper<DiscussxiangpianEntity> queryWrapper = new EntityWrapper<DiscussxiangpianEntity>()
            .eq("refid", discussxiangpian.getRefid())
            .eq("userid", discussxiangpian.getUserid())
            .eq("content", discussxiangpian.getContent())
            .eq("reply", discussxiangpian.getReply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiscussxiangpianEntity discussxiangpianEntity = discussxiangpianService.selectOne(queryWrapper);
        if(discussxiangpianEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      discussxiangpian.set
        //  }
            discussxiangpianService.insert(discussxiangpian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussxiangpianEntity discussxiangpian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,discussxiangpian:{}",this.getClass().getName(),discussxiangpian.toString());
        //根据字段查询是否有相同数据
        Wrapper<DiscussxiangpianEntity> queryWrapper = new EntityWrapper<DiscussxiangpianEntity>()
            .notIn("id",discussxiangpian.getId())
            .andNew()
            .eq("refid", discussxiangpian.getRefid())
            .eq("userid", discussxiangpian.getUserid())
            .eq("content", discussxiangpian.getContent())
            .eq("reply", discussxiangpian.getReply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiscussxiangpianEntity discussxiangpianEntity = discussxiangpianService.selectOne(queryWrapper);
        if(discussxiangpianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      discussxiangpian.set
            //  }
            discussxiangpianService.updateById(discussxiangpian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        discussxiangpianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

