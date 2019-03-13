package cn.chen.oa.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.chen.oa.entity.Employee;

public class MyRealm extends AuthorizingRealm{

	
	/**
	 * 授权
	 * 告诉shiro当前用户拥有哪些权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//①拿到用户名(身份)
		Object principal = principals.getPrimaryPrincipal();
		System.out.println(principal);
		//②查询该用户的所有权限
		//③创建一个SimpleAuthorizationInfo对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//④将权限添加到info中返回给shiro
		Set<String> stringPermissions = new HashSet<>();
		stringPermissions.add("user:list");
		info.setStringPermissions(stringPermissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//明文认证
		//①获取到用户信息（用户名）
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String username = upt.getUsername();
		System.out.println("username="+username);
		//②通过用户名查询用户信息
		//User user = userService.getUserByUsername(username);
		Employee user = new Employee();//通过service查询出的数据库中的用户信息
		user.setEmployee_name(username);
		user.setPassword("3fdf8415b6b55b4e6f80999513837bb9");//数据库中加密加盐加次数的密码
		Object principal = user.getEmployee_name();
		Object credentials = user.getPassword();
		String realmName = getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes("ssm");//加盐
		//④将查询出来的用户信息交给shiro去比对
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials , realmName);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt , realmName);
		return info;
	}
	
	

	

}
