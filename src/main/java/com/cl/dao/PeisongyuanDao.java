package com.cl.dao;

import com.cl.entity.PeisongyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeisongyuanView;


/**
 * 配送员
 * 
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
public interface PeisongyuanDao extends BaseMapper<PeisongyuanEntity> {
	
	List<PeisongyuanView> selectListView(@Param("ew") Wrapper<PeisongyuanEntity> wrapper);

	List<PeisongyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PeisongyuanEntity> wrapper);
	
	PeisongyuanView selectView(@Param("ew") Wrapper<PeisongyuanEntity> wrapper);
	

}
