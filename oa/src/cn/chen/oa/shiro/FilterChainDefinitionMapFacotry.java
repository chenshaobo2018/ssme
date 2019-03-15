package cn.chen.oa.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilterChainDefinitionMapFacotry {
	
	/**
	 * 说明
	 * authc 指定需要认证的url
	 * anon 指定不需要认证的url
	 * logout 指定退出登录的url
	 */
	public  Map<String, String> getFilterChainDefinitionMap(){
		//配置拦截的url，顺序判断，但anon（不拦截）必须在authc（拦截）前面
		Map<String, String> map = new LinkedHashMap<String, String>();//不能是hashmap，参考文章http://www.cnblogs.com/shyroke/p/10138705.html
		//不拦截
		map.put("/loginLogout/loginJsp", "anon");//不拦截跳转到登录页面
		map.put("/loginLogout/login", "anon");//不拦登录
		
		//资源对应的权限需要访问数据库     user:list
		map.put("/user/list", "perms[user:list]");
		map.put("/user/delete", "perms[user:delete]");
		
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
		map.put("/logout", "logout");
		
		//拦截
		map.put("/**", "authc");
		return map;
	}
}
