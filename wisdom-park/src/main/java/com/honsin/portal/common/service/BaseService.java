package com.honsin.portal.common.service;

import java.util.List;
import java.util.Map;

import com.honsin.portal.common.utils.AjaxResult;

public interface BaseService<T> {  
  

	/**
	 * 获取单条数据
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 条件查询数据列表，
	 * @return
	 */
	public List<T> selectByParams(Map<String, Object> params);
	
	
	/**
	 * 条件查询记录数
	 * @return
	 */
	public int count(Map<String, Object> params);
	
	
	/**
	 * 插入数据
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 逻辑删除数据
	 * @return
	 */
	public int deleteByMark(String id);
	
	/**
	 * 物理删除数据
	 * @return
	 */
	public int deleteByPhysic(String id);
	
  
}  