package com.charlie.hspliving.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 商品分类表
 * 
 * @author charlie
 * @email charlie@gmail.com
 * @date 2024-08-22 20:19:14
 */
@Data
@TableName("commodity_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 父分类id
	 */
	private Long parentId;
	/**
	 * 层级
	 */
	private Integer catLevel;
	/**
	 * 0不显示，1显示
	 */
	private Integer isShow;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 统计单位
	 */
	private String proUnit;
	/**
	 * 商品数量
	 */
	private Integer proCount;

	/**
	 * 增加一个属性，childrenCategories
	 * 1. 表示某个分类的子分类集合
	 * 2. 没有对应表 commodity_category 的字段
	 * 3. @TableFiled(exit = false) 表示属性不对应表的字段
	 */
	@TableField(exist = false)
	private List<CategoryEntity> childrenCategories;

}
