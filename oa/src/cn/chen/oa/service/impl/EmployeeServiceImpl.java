package cn.chen.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chen.oa.entity.Employee;
import cn.chen.oa.mapper.EmployeeMapper;
import cn.chen.oa.query.EmployeeQuery;
import cn.chen.oa.service.IEmployeeService;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:04:07
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public void add(Employee employee) {
		employeeMapper.add(employee);
	}

	@Override
	public void remove(Long employee_id) {
		employeeMapper.remove(employee_id);
	}

	@Override
	public void update(Employee employee) {
		employeeMapper.update(employee);
	}

	@Override
	public List<Employee> allList(EmployeeQuery employeeQuery) {
		return null;
	}

	@Override
	public int count(EmployeeQuery employeeQuery) {
		return 0;
	}

}
