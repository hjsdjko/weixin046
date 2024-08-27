package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanpeisongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanpeisongView;


/**
 * 订单配送
 *
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
public interface DingdanpeisongService extends IService<DingdanpeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanpeisongView> selectListView(Wrapper<DingdanpeisongEntity> wrapper);
   	
   	DingdanpeisongView selectView(@Param("ew") Wrapper<DingdanpeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanpeisongEntity> wrapper);
   	

}

