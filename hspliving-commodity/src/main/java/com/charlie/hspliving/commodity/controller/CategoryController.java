package com.charlie.hspliving.commodity.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.hspliving.commodity.entity.CategoryEntity;
import com.charlie.hspliving.commodity.service.CategoryService;
import com.charlie.common.utils.PageUtils;
import com.charlie.common.utils.R;

import javax.annotation.Resource;


/**
 * 商品分类表
 *
 * @author charlie
 * @email charlie@gmail.com
 * @date 2024-08-22 20:19:14
 */
@RestController
@RequestMapping("commodity/category")
public class CategoryController {
    // 装配Service
    @Autowired
    private CategoryService categoryService;

    /**
     * 编写一个方法/接口，查出所有分类及其子类，并要求带有其层级关系
     */
    @RequestMapping("/list/tree")
    public R listTree() {
        List<CategoryEntity> entities = categoryService.listTree();
        return R.ok().put("data", entities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("commodity:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("commodity:category:info")
    public R info(@PathVariable("id") Long id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("commodity:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("commodity:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("commodity:category:delete")
    public R delete(@RequestBody Long[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
