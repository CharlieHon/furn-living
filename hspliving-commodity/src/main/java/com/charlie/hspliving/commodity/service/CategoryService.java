package com.charlie.hspliving.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.charlie.common.utils.PageUtils;
import com.charlie.hspliving.commodity.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author charlie
 * @email charlie@gmail.com
 * @date 2024-08-22 20:19:14
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    // 返回所有分类及其子分类（带有层级关系，即树形）
    List<CategoryEntity> listTree();
}

