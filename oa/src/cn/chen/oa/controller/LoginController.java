package cn.chen.oa.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:19:47
 */
@Controller
@RequestMapping("/loginLogout")
public class LoginController {
	
	/**
	 * 01.跳转到登录页面
	 */
	@RequestMapping("/loginJsp")
	public String login(){
		//自动的拼接了前后缀的，http://localhost:8080/oa/webapp/WEB-INF/views/login.jsp
		return "login";
	}
	
	/**
	 * 02.登录
	 */
	@RequestMapping("login")
	public String save(String username,String password){
		//1.封装前台传来的账号密码，生成token
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		//2.获得Subject对象
		Subject currentUser = SecurityUtils.getSubject();
		
		//3.验证token是否正确
		currentUser.login(token);
		System.out.println("是否登录："+currentUser.isAuthenticated());
		
		//4.登录成功后跳转到部门列表（主页）
		//return "DepartmentList";//方式一，直接跳转到DepartmentList.jsp页面
		return "redirect:/department/list";//方式二：转发请求
	}
	
	/**
	 * 03.退出登录
	 */
	@RequestMapping("/logout")
	public String logout(){
		//1.获得Subject对象
		Subject currentUser = SecurityUtils.getSubject();
		
		//2.退出登录
		currentUser.logout();
		System.out.println("是否登录："+currentUser.isAuthenticated());
		
		//3.跳转到登录页面
		return "login";
	}
}
