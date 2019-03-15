package cn.chen.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chen.oa.entity.Department;
import cn.chen.oa.service.IDepartmentService;
import cn.chen.oa.utils.AjaxResult;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:19:47
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired 
	private IDepartmentService departmentService;
	
	/**
	 * 01.跳转到部门列表的页面
	 */
	@RequestMapping("/list")
	public String list(){
		return "DepartmentList";//自动的拼接了前后缀的
	}
	
	/**
	 * 02.部门列表
	 */
	@RequestMapping("/departmentList")
	@ResponseBody
	public List<Department> departmentList(){
		System.out.println("/department/departmentList");
		List<Department> departmentList = departmentService.getAll();
		for (Department department : departmentList) {
			System.out.println(department);
		}
		return departmentList;
	}
	
	/**
	 * 03.添加部门
	 */
	@RequestMapping("/insertDepartment")
	@ResponseBody
	public AjaxResult insertDepartment(String id){
		AjaxResult ajaxResult = new AjaxResult("操作成功");
		System.out.println("/department/insertDepartment");
		System.out.println(id);
		
		Department department = new Department();
		department.setDepartment_name("行政部");
		department.setManager_id(7);
		department.setDepartment_parent_id(1);
		System.out.println(department);
		//departmentService.add(department);
		
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}
}
