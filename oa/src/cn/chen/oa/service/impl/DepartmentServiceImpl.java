package cn.chen.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chen.oa.entity.Department;
import cn.chen.oa.mapper.DepartmentMapper;
import cn.chen.oa.query.DepartmentQuery;
import cn.chen.oa.service.IDepartmentService;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:03:06
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired DepartmentMapper departmentMapper;

	@Override
	public void add(Department department) {
		departmentMapper.add(department);

	}

	@Override
	public void remove(Long department_id) {
		departmentMapper.remove(department_id);
	}

	@Override
	public void update(Department department) {
		departmentMapper.update(department);
	}

	@Override
	public List<Department> allList(DepartmentQuery departmentQuery) {
		return null;
	}

	@Override
	public int count(DepartmentQuery departmentQuery) {
		return 0;
	}

	@Override
	public List<Department> getAll(){
		return departmentMapper.getAll();
	}

}
