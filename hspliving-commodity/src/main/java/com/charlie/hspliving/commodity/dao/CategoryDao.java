package com.charlie.hspliving.commodity.dao;

import com.charlie.hspliving.commodity.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类表
 * 
 * @author charlie
 * @email charlie@gmail.com
 * @date 2024-08-22 20:19:14
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
