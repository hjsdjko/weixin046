package com.cl.dao;

import com.cl.entity.DingdanpeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanpeisongView;


/**
 * 订单配送
 * 
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
public interface DingdanpeisongDao extends BaseMapper<DingdanpeisongEntity> {
	
	List<DingdanpeisongView> selectListView(@Param("ew") Wrapper<DingdanpeisongEntity> wrapper);

	List<DingdanpeisongView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanpeisongEntity> wrapper);
	
	DingdanpeisongView selectView(@Param("ew") Wrapper<DingdanpeisongEntity> wrapper);
	

}
