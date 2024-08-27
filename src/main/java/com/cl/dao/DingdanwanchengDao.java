package com.cl.dao;

import com.cl.entity.DingdanwanchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanwanchengView;


/**
 * 订单完成
 * 
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
public interface DingdanwanchengDao extends BaseMapper<DingdanwanchengEntity> {
	
	List<DingdanwanchengView> selectListView(@Param("ew") Wrapper<DingdanwanchengEntity> wrapper);

	List<DingdanwanchengView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanwanchengEntity> wrapper);
	
	DingdanwanchengView selectView(@Param("ew") Wrapper<DingdanwanchengEntity> wrapper);
	

}
