  package com.eshop.util;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.eshop.biz.IshopAdminBiz;
import com.eshop.biz.IshopMenuBiz;
import com.eshop.model.shopAdmin;


public class MyRealm extends AuthorizingRealm {

	@Resource
    IshopAdminBiz biz;
	
	@Resource
    IshopMenuBiz menubiz;
	
	
	/**
	 * 为当限前登录的用户授予角色和权
	 */
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(biz.getRoles(userName));
		authorizationInfo.setStringPermissions(menubiz.getPermission(userName));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		    String username=(String)token.getPrincipal();
		   
		    
			shopAdmin user=biz.findByUserName(username);
			
			
	        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	                user.getName(), //用户名
	                user.getPassword(), //密码
	                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
	                getName()  //realm name
	        );
			
			
	        
	        return authenticationInfo;
	}

}
