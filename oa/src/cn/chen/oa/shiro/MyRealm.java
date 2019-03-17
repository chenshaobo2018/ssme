package cn.chen.oa.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm {

	private static final String String = null;

	//01.realm的名字
	@Override
	public String getName() {
		return "MyRealm";
	}
	
	//02.授权操作--告诉shiro当前用户拥有哪些权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.拿到用户名(身份)
		Object principal = principals.getPrimaryPrincipal();
		System.out.println(principal+"-----------");//拿到的就是用户名
		
		//2.模拟从数据库中查询该用户的所有权限
		Set<String> stringPermissions = new HashSet<>();
		stringPermissions.add("department:add");
		stringPermissions.add("department:edit");
		stringPermissions.add("department:del");
		
		//3.模拟从数据库中查询该用户的角色
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		
		//4.创建一个SimpleAuthorizationInfo对象，给予查到的角色二和权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(stringPermissions);
		info.setRoles(roles);
		
		return info;
	}

	//03.认证操作
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取token中的username
		String username = (String)token.getPrincipal();
		
		//查询数据库中的username信息，这里就写死
		
		//模拟从数据库获取对应用户名的用户
		if(!"zhangsan".equals(username)){
			return null;//throw new AccountException("不存在此用户");
		}
		
		//假设从数据库查到的账号和密码如下
		String usernameDb = "zhangsan";//数据库中的账户名
		String passwordDb = "e270555223cc0126bbf1c3b5e4884d7c";//数据库中的加密密码
		String saltDb = "thisisyan";//数据库中的盐
		
		
		//info对象表示realm登录比对信息
		ByteSource  salt = ByteSource.Util.bytes(saltDb);//盐值
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(usernameDb, passwordDb,salt,getName());
		
		return info;
	}

}
