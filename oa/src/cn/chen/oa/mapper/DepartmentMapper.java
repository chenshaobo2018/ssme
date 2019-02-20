package cn.chen.oa.mapper;

import java.util.List;

import cn.chen.oa.po.Department;
import cn.chen.oa.query.DepartmentQuery;

/**
 * @author BOBO
 * @version 2018年11月14日 下午9:39:17
 */
public interface DepartmentMapper {
	/**
	 * 增
	 */
	void add(Department department);
	
	/**
	 * 删
	 */
	void remove(Long department_id);
	
	/**
	 * 改
	 */
	void update(Department department);
	
	/**
	 * 查
	 */
	List<Department> getAll();
	
	/**
	 * 查-分页
	 */
	List<Department> allList(DepartmentQuery departmentQuery);
	
	/**
	 * 查总共有多少个数据
	 */
	int count(DepartmentQuery departmentQuery);
}
