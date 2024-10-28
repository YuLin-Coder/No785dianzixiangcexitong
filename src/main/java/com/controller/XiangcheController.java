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

import com.entity.XiangcheEntity;

import com.service.XiangcheService;
import com.entity.view.XiangcheView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 相册信息
 * 后端接口
 * @author
 * @email
 * @date 2021-03-30
*/
@RestController
@Controller
@RequestMapping("/xiangche")
public class XiangcheController {
    private static final Logger logger = LoggerFactory.getLogger(XiangcheController.class);

    @Autowired
    private XiangcheService xiangcheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = xiangcheService.queryPage(params);

        //字典表数据转换
        List<XiangcheView> list =(List<XiangcheView>)page.getList();
        for(XiangcheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        PageUtils page = xiangcheService.queryPage(params);

        //字典表数据转换
        List<XiangcheView> list =(List<XiangcheView>)page.getList();
        for(XiangcheView c:list){
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
        XiangcheEntity xiangche = xiangcheService.selectById(id);
        if(xiangche !=null){
            //entity转view
            XiangcheView view = new XiangcheView();
            BeanUtils.copyProperties( xiangche , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xiangche.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody XiangcheEntity xiangche, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangche:{}",this.getClass().getName(),xiangche.toString());
        xiangche.setOdd(String.valueOf(new Date().getTime()));
        Wrapper<XiangcheEntity> queryWrapper = new EntityWrapper<XiangcheEntity>()
            .eq("xcname", xiangche.getXcname())
            .eq("yonghu_id", xiangche.getYonghuId())
            .eq("number", xiangche.getNumber())
            .eq("xiangche_content", xiangche.getXiangcheContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangcheEntity xiangcheEntity = xiangcheService.selectOne(queryWrapper);
        if(xiangcheEntity==null){
            xiangche.setChuanjianTime(new Date());
            xiangcheService.insert(xiangche);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangcheEntity xiangche, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangche:{}",this.getClass().getName(),xiangche.toString());
        //根据字段查询是否有相同数据
        Wrapper<XiangcheEntity> queryWrapper = new EntityWrapper<XiangcheEntity>()
            .notIn("id",xiangche.getId())
            .andNew()
            .eq("odd", xiangche.getOdd())
            .eq("xcname", xiangche.getXcname())
            .eq("yonghu_id", xiangche.getYonghuId())
            .eq("number", xiangche.getNumber())
            .eq("xiangche_content", xiangche.getXiangcheContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangcheEntity xiangcheEntity = xiangcheService.selectOne(queryWrapper);
        if("".equals(xiangche.getImgPhoto()) || "null".equals(xiangche.getImgPhoto())){
                xiangche.setImgPhoto(null);
        }
                xiangche.setChuanjianTime(new Date());
        if(xiangcheEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xiangche.set
            //  }
            xiangcheService.updateById(xiangche);//根据id更新
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
        xiangcheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

