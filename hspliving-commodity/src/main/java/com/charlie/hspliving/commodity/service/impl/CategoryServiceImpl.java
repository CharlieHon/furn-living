package com.charlie.hspliving.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charlie.common.utils.PageUtils;
import com.charlie.common.utils.Query;
import com.charlie.hspliving.commodity.dao.CategoryDao;
import com.charlie.hspliving.commodity.entity.CategoryEntity;
import com.charlie.hspliving.commodity.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 返回所有分类及其子分类（带有层级关系，即树形）
     * 这里会使用到java8的 流式计算 + 递归操作
     */
    @Override
    public List<CategoryEntity> listTree() {
        // 1. 查出所有的分类数据
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 2. 组装成层级树形结构（使用到java8的stream api + 递归擦欧总）
        List<CategoryEntity> categoryTree = entities.stream().filter(categoryEntity -> {
            // 2.1 对entities过滤filter，返回1级分类
            return categoryEntity.getParentId() == 0;
        }).map(category -> {
            // 2.2 进行map映射操作，给每个分类设置对应的子分类（递归）
            category.setChildrenCategories(null);   // 递归操作，最重要！
            return category;
        }).sorted((category1, category2) -> {
            // 2.3 进行排序sorted操作，按照sort升序排序
            return (category1.getSort() == null ? 0 : category1.getSort()) -
                    (category2.getSort() == null ? 0 : category2.getSort());
        }).collect(Collectors.toList());    // 将处理好的数据进行收集/转换到集合

        // 3. 返回带有层级关系的树形结构数据
        return categoryTree;
    }
}