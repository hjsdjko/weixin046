package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DingdanpeisongEntity;
import com.cl.entity.view.DingdanpeisongView;

import com.cl.service.DingdanpeisongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单配送
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
@RestController
@RequestMapping("/dingdanpeisong")
public class DingdanpeisongController {
    @Autowired
    private DingdanpeisongService dingdanpeisongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanpeisongEntity dingdanpeisong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanpeisong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("peisongyuan")) {
			dingdanpeisong.setPeisongyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanpeisongEntity> ew = new EntityWrapper<DingdanpeisongEntity>();

		PageUtils page = dingdanpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanpeisong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanpeisongEntity dingdanpeisong, 
		HttpServletRequest request){
        EntityWrapper<DingdanpeisongEntity> ew = new EntityWrapper<DingdanpeisongEntity>();

		PageUtils page = dingdanpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanpeisong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanpeisongEntity dingdanpeisong){
       	EntityWrapper<DingdanpeisongEntity> ew = new EntityWrapper<DingdanpeisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanpeisong, "dingdanpeisong")); 
        return R.ok().put("data", dingdanpeisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanpeisongEntity dingdanpeisong){
        EntityWrapper< DingdanpeisongEntity> ew = new EntityWrapper< DingdanpeisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanpeisong, "dingdanpeisong")); 
		DingdanpeisongView dingdanpeisongView =  dingdanpeisongService.selectView(ew);
		return R.ok("查询订单配送成功").put("data", dingdanpeisongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanpeisongEntity dingdanpeisong = dingdanpeisongService.selectById(id);
		dingdanpeisong = dingdanpeisongService.selectView(new EntityWrapper<DingdanpeisongEntity>().eq("id", id));
        return R.ok().put("data", dingdanpeisong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanpeisongEntity dingdanpeisong = dingdanpeisongService.selectById(id);
		dingdanpeisong = dingdanpeisongService.selectView(new EntityWrapper<DingdanpeisongEntity>().eq("id", id));
        return R.ok().put("data", dingdanpeisong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanpeisongEntity dingdanpeisong, HttpServletRequest request){
    	dingdanpeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanpeisong);
        dingdanpeisongService.insert(dingdanpeisong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanpeisongEntity dingdanpeisong, HttpServletRequest request){
    	dingdanpeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanpeisong);
        dingdanpeisongService.insert(dingdanpeisong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanpeisongEntity dingdanpeisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanpeisong);
        dingdanpeisongService.updateById(dingdanpeisong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanpeisongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
