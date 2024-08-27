package com.cl.entity.view;

import com.cl.entity.DiscusscantingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 餐厅信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 18:38:57
 */
@TableName("discusscantingxinxi")
public class DiscusscantingxinxiView  extends DiscusscantingxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusscantingxinxiView(){
	}
 
 	public DiscusscantingxinxiView(DiscusscantingxinxiEntity discusscantingxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusscantingxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
