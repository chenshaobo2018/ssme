package cn.chen.oa.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class Demo8_shiro {
	//依赖
	/*
	  	<dependency>
	      <groupId>org.apache.shiro</groupId>
	      <artifactId>shiro-core</artifactId>
	      <version>1.2.4</version>
	    </dependency>
	    
	    <dependency>
	      <groupId>org.slf4j</groupId>
	      <artifactId>slf4j-log4j12</artifactId>
	      <version>1.7.12</version>
	    </dependency>
	 */
	/**
	 * 1.认证：简单登录登出认证
	 */
	@Test
	public void testName1() throws Exception {
		//1.配置文件路径
		String filePath = "classpath:shiro.ini";
		
		//2.获得当前执行的用户
		Subject currentUser = getCurrentUser(filePath);
        
        //3.创建token令牌，用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("lisi", "123");
        
        //4.身份认证
        try{
            //登录
            currentUser.login(token);
            // 退出
            currentUser.logout();  
            System.out.println("是否登录："+currentUser.isAuthenticated());
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
	}

	/**
	 * 2.认证：自定义realm登录登出
	 */
	@Test
	public void testName2() throws Exception {
        //1.配置文件路径
  		String filePath = "classpath:shiro-realm.ini";
  		
  		//2.获得当前执行的用户
  		Subject currentUser = getCurrentUser(filePath);
        
        //3.创建token令牌，用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "123");
        
        //4.身份认证
        try{
            //登录
            currentUser.login(token);
            // 退出
            currentUser.logout();  
            System.out.println("是否登录："+currentUser.isAuthenticated());
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
	}
	
	/**
	 * 3.加密
	 * 	shiro支持md5加密，SHA加密
	 */
	@Test
	public void testName3() throws Exception {
		String password = "123";
		
		//1.加密：md5
		Md5Hash md5Hash = new Md5Hash(password);
		System.out.println(md5Hash);//202cb962ac59075b964b07152d234b70
		
		//2.加密：md5 + 盐
		md5Hash = new Md5Hash(password,"thisisyan");
		System.out.println(md5Hash);//11055c8339cd6497bde6f266a5a1388f
		
		//3.加密：md5 + 盐  + 散列次数（重复之前的操作）
		md5Hash = new Md5Hash(password,"thisisyan",3);
		System.out.println(md5Hash);//e270555223cc0126bbf1c3b5e4884d7c
	}
	
	/**
	 * 4.加密认证
	 */
	@Test
	public void testName4() throws Exception {
		//1.配置文件路径
  		String filePath = "classpath:shiro-cryptography.ini";
  		
        //2.获得当前执行的用户
  		Subject currentUser = getCurrentUser(filePath);
        
        //3.创建token令牌，用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "123");
        
        //4.身份认证
        try{
            //登录
            currentUser.login(token);
            // 退出
            currentUser.logout();  
            System.out.println("是否登录："+currentUser.isAuthenticated());
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
	}
	
	/**
	 * 5.简单授权
	 */
	@Test
	public void testName5() throws Exception {
		//1.配置文件路径
  		String filePath = "classpath:shiro-permission.ini";
  		
  		//2.认证
  		Subject currentUser = getCurrentUser(filePath);
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "123");
        currentUser.login(token);
        
        //3.授权，必须先认证
        System.out.println("是否有角色role1："+currentUser.hasRole("role1"));//true，判断是否有该权限
        System.out.println("是否有角色role1和role3："+currentUser.hasAllRoles(Arrays.asList("role1","role3")));//false
        System.out.println("是否分别有角色role1、role2和role3："+Arrays.toString(currentUser.hasRoles(Arrays.asList("role1","role2","role3"))));//[true, true, false]
	}
	
	/**
	 * 抽取工具类，获得当前登录用户Subject
	 */
	private Subject getCurrentUser(String filePath) {
		//1.读取配置文件，初始化SecurityManager工厂 读取shiro.ini文件
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(filePath);
        
        //2.获取securityManager实例
        SecurityManager securityManager=factory.getInstance();
        
        //3.把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        //4.得到当前执行的用户
        Subject currentUser=SecurityUtils.getSubject();
		return currentUser;
	}
}
