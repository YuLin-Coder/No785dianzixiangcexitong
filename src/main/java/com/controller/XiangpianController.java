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

import com.entity.XiangpianEntity;

import com.service.XiangpianService;
import com.entity.view.XiangpianView;
import com.service.XiangcheService;
import com.entity.XiangcheEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 相片信息
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31
*/
@RestController
@Controller
@RequestMapping("/xiangpian")
public class XiangpianController {
    private static final Logger logger = LoggerFactory.getLogger(XiangpianController.class);

    @Autowired
    private XiangpianService xiangpianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private XiangcheService xiangcheService;

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
        PageUtils page = xiangpianService.queryPage(params);

        //字典表数据转换
        List<XiangpianView> list =(List<XiangpianView>)page.getList();
        for(XiangpianView c:list){
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
        PageUtils page = xiangpianService.queryPage(params);
        //字典表数据转换
        List<XiangpianView> list =(List<XiangpianView>)page.getList();
        for(XiangpianView c:list){
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
        XiangpianEntity xiangpian = xiangpianService.selectById(id);
        if(xiangpian !=null){
            //entity转view
            XiangpianView view = new XiangpianView();
            BeanUtils.copyProperties( xiangpian , view );//把实体数据重构到view中

            //级联表
            XiangcheEntity xiangche = xiangcheService.selectById(xiangpian.getXiangcheId());
            if(xiangche != null){
                BeanUtils.copyProperties( xiangche , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setXiangcheId(xiangche.getId());
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
    public R save(@RequestBody XiangpianEntity xiangpian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangpian:{}",this.getClass().getName(),xiangpian.toString());
        Wrapper<XiangpianEntity> queryWrapper = new EntityWrapper<XiangpianEntity>()
            .eq("xiangche_id", xiangpian.getXiangcheId())
            .eq("xpname", xiangpian.getXpname())
            .eq("paishedidian", xiangpian.getPaishedidian())
            .eq("paisheren", xiangpian.getPaisheren())
            .eq("fenlei_types", xiangpian.getFenleiTypes())
            .eq("xiangpian_content", xiangpian.getXiangpianContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangpianEntity xiangpianEntity = xiangpianService.selectOne(queryWrapper);
        if(xiangpianEntity==null){
            boolean insert = xiangpianService.insert(xiangpian);
            if(insert){
                XiangcheEntity xiangche = xiangcheService.selectById(xiangpian.getXiangcheId());
                xiangche.setNumber(xiangche.getNumber()+1);
                xiangcheService.updateById(xiangche);
            }
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangpianEntity xiangpian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangpian:{}",this.getClass().getName(),xiangpian.toString());
        //根据字段查询是否有相同数据
        Wrapper<XiangpianEntity> queryWrapper = new EntityWrapper<XiangpianEntity>()
            .notIn("id",xiangpian.getId())
            .andNew()
            .eq("xiangche_id", xiangpian.getXiangcheId())
            .eq("xpname", xiangpian.getXpname())
            .eq("paishedidian", xiangpian.getPaishedidian())
            .eq("paisheren", xiangpian.getPaisheren())
            .eq("fenlei_types", xiangpian.getFenleiTypes())
            .eq("xiangpian_content", xiangpian.getXiangpianContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangpianEntity xiangpianEntity = xiangpianService.selectOne(queryWrapper);
        if("".equals(xiangpian.getXpimgPhoto()) || "null".equals(xiangpian.getXpimgPhoto())){
                xiangpian.setXpimgPhoto(null);
        }
        if(xiangpianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xiangpian.set
            //  }
            xiangpianService.updateById(xiangpian);//根据id更新
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
        xiangpianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

