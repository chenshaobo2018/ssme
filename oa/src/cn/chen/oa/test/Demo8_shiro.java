package cn.chen.oa.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

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
	public static void main(String[] args) {
        // 读取配置文件，初始化SecurityManager工厂 读取shiro.ini文件
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        
        // 获取securityManager实例
        SecurityManager securityManager=factory.getInstance();
        
        // 把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        
        // 得到当前执行的用户
        Subject currentUser=SecurityUtils.getSubject();
        
        // 创建token令牌，用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("lisi", "123");
        
        try{
            //身份认证
        	System.out.println("已登录："+currentUser.isAuthenticated());
            currentUser.login(token);
            System.out.println("已登录："+currentUser.isAuthenticated());
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
        // 退出
        currentUser.logout();  
        System.out.println("已登录："+currentUser.isAuthenticated());
    }
}
