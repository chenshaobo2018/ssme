package cn.chen.oa.service;

import java.util.List;

import cn.chen.oa.entity.Employee;
import cn.chen.oa.query.EmployeeQuery;

/**
 * @author BOBO
 * @version 2018年11月14日 下午9:38:57
 */
public interface IEmployeeService {
	/**
	 * 增
	 */
	void add(Employee employee);
	
	/**
	 * 删
	 */
	void remove(Long employee_id);
	
	/**
	 * 改
	 */
	void update(Employee employee);
	
	/**
	 * 查-分页
	 */
	List<Employee> allList(EmployeeQuery employeeQuery);
	
	/**
	 * 查总共有多少个数据
	 */
	int count(EmployeeQuery employeeQuery);
}
