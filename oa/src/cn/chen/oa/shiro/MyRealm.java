package cn.chen.oa.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.tomcat.util.http.parser.Authorization;

public class MyRealm extends AuthorizingRealm {

	private static final String String = null;

	@Override
	public String getName() {
		return "MyRealm";
	}
	
	//授权操作
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//认证操作
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取token中的username
		String username = (String)token.getPrincipal();
		
		//查询数据库中的username信息，这里就写死
		
		//比对
		if(!"zhangsan".equals(username)){
			return null;
		}
		
		String password = "123";
		
		//info对象表示realm登录比对信息
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password,getName());
		
		return info;
	}

}
