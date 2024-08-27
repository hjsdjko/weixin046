package com.cl.entity.view;

import com.cl.entity.DingdanwanchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 订单完成
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 18:38:56
 */
@TableName("dingdanwancheng")
public class DingdanwanchengView  extends DingdanwanchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DingdanwanchengView(){
	}
 
 	public DingdanwanchengView(DingdanwanchengEntity dingdanwanchengEntity){
 	try {
			BeanUtils.copyProperties(this, dingdanwanchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
