package cn.chen.oa.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class PasswordRealm extends AuthorizingRealm {

	private static final String String = null;

	@Override
	public String getName() {
		return "PasswordRealm";
	}
	
	//授权操作
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
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
		
		//假设下面这个数据是从数据库中查找到的
		String password = "e270555223cc0126bbf1c3b5e4884d7c";
		
		//info对象表示realm登录比对信息
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password,ByteSource.Util.bytes("thisisyan"),getName());
		
		return info;
	}

}
