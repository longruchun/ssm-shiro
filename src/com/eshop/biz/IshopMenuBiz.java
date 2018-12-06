package com.eshop.biz;

import java.util.List;
import java.util.Set;

import com.eshop.model.shopMenu;
import com.eshop.model.sysmenu;

public interface IshopMenuBiz extends IBaseBiz<shopMenu> {
	List<shopMenu> getModelsByPid(int pid);
	List<sysmenu> getMenus(Set<String> permissions);
	
	Set<String> getPermission(String username);
}
