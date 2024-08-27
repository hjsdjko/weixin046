package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DingdanpeisongDao;
import com.cl.entity.DingdanpeisongEntity;
import com.cl.service.DingdanpeisongService;
import com.cl.entity.view.DingdanpeisongView;

@Service("dingdanpeisongService")
public class DingdanpeisongServiceImpl extends ServiceImpl<DingdanpeisongDao, DingdanpeisongEntity> implements DingdanpeisongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanpeisongEntity> page = this.selectPage(
                new Query<DingdanpeisongEntity>(params).getPage(),
                new EntityWrapper<DingdanpeisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanpeisongEntity> wrapper) {
		  Page<DingdanpeisongView> page =new Query<DingdanpeisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdanpeisongView> selectListView(Wrapper<DingdanpeisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanpeisongView selectView(Wrapper<DingdanpeisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
