package cn.chen.oa.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.chen.oa.controller.DepartmentController;
import cn.chen.oa.po.Department;
import cn.chen.oa.service.IDepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentTest {
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private DepartmentController departmentController;
	
	@Test
	public void testName1() throws Exception {
		List<Department> all = departmentService.getAll();
		for (Department department : all) {
			System.out.println(department);
		}
	}
	
	@Test
	public void testName2() throws Exception {
		List<Department> all = departmentController.getAll();
		for (Department department : all) {
			System.out.println(department);
		}
	}
}
