package com.eshop.biz.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.biz.IshopAdminBiz;
import com.eshop.dao.IshopAdminMapper;
import com.eshop.dao.IshopRoleMapper;
import com.eshop.model.shopAdmin;
import com.eshop.model.shopRole;
import com.eshop.util.PasswordHelper;

@Service
public class shopAdminBizImpl implements IshopAdminBiz {

	@Autowired
	IshopAdminMapper dao;
	
	@Autowired
	IshopRoleMapper role_dao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(shopAdmin t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	@Override
	public int insertSelective(shopAdmin t) {
		// TODO Auto-generated method stub
		PasswordHelper helper=new PasswordHelper();
		helper.encryptPassword(t);
		return dao.insertSelective(t);
	}

	@Override
	public shopAdmin selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(shopAdmin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(shopAdmin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<shopAdmin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shopAdmin findByUserName(String name) {
		// TODO Auto-generated method stub
		return dao.findByUserName(name);
	}

	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		shopAdmin user=findByUserName(userName);
		String roleids=user.getRoleid();
		String[] role_ids=roleids.split(",");
		
		Set<String> roles=new HashSet<String>();
		
		for(String id:role_ids){
			shopRole role=role_dao.selectByPrimaryKey(Integer.parseInt(id));
		    roles.add(role.getRolename());
		
		}
		return roles;
	}

}
