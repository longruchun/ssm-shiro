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
	 * Ϊ����ǰ��¼���û������ɫ��Ȩ
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
	 * ��֤��ǰ��¼���û�
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		    String username=(String)token.getPrincipal();
		   
		    
			shopAdmin user=biz.findByUserName(username);
			
			
	        //����AuthenticatingRealmʹ��CredentialsMatcher��������ƥ�䣬��������˼ҵĲ��ÿ����Զ���ʵ��
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	                user.getName(), //�û���
	                user.getPassword(), //����
	                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
	                getName()  //realm name
	        );
			
			
	        
	        return authenticationInfo;
	}

}
