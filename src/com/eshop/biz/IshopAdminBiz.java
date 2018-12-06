package com.eshop.biz;

import java.util.List;
import java.util.Set;

import com.eshop.model.shopAdmin;

public interface IshopAdminBiz extends IBaseBiz<shopAdmin> {
	shopAdmin findByUserName(String name);
	
	public Set<String> getRoles(String userName);
}
