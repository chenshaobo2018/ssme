package cn.chen.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chen.oa.po.Department;
import cn.chen.oa.service.IDepartmentService;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:19:47
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired 
	private IDepartmentService departmentService;
	
	@RequestMapping("/list")
	public String list(){
		return "DepartmentList";
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Department> getAll(){
		List<Department> all = departmentService.getAll();
		for (Department department : all) {
			System.out.println(department);
		}
		return departmentService.getAll();
	}
}
