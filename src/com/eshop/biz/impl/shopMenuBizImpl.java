package com.eshop.biz.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authz.permission.WildcardPermission;

import org.springframework.stereotype.Service;

import com.eshop.biz.IshopMenuBiz;
import com.eshop.dao.IshopAdminMapper;
import com.eshop.dao.IshopMenuMapper;
import com.eshop.dao.IshopRoleMapper;
import com.eshop.model.shopMenu;
import com.eshop.model.shopRole;
import com.eshop.model.sysmenu;


@Service("shopMenuBizImpl")
public class shopMenuBizImpl implements IshopMenuBiz {
    
	@Resource
	public IshopMenuMapper dao;
	@Resource
	public IshopRoleMapper role_dao;
	@Resource
	public IshopAdminMapper admin_dao;
	

	@Override
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(shopMenu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(shopMenu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public shopMenu selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		shopMenu sm= dao.selectByPrimaryKey(id);
		System.out.println(sm.getText());
		return sm;
	}
	
	

	@Override
	public int updateByPrimaryKeySelective(shopMenu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(shopMenu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<shopMenu> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<shopMenu> getModelsByPid(int pid) {
		// TODO Auto-generated method stub
		return dao.getModelsByPid(pid);
	}
	
	
	public List<sysmenu> getMenus(Set<String> permissions) {
		// TODO Auto-generated method stub
		List<sysmenu> menus=new ArrayList<sysmenu>();
		
		
		List<shopMenu> items=dao.getModelsByPid(0);
		for(int i=0;i<items.size();i++) {
			
			 if(hasPermission(permissions,items.get(i))) {  
			   menus.add(getMenu(permissions,items.get(i).getId()));
			 }
		}
		
		
		return menus;
	}
	
	
	
	private sysmenu getMenu(Set<String> permissions,int menuId) {
		
		sysmenu menuNode=new sysmenu();
		
		shopMenu item=new shopMenu();
		List<sysmenu> nodes=new ArrayList<sysmenu>();

 	    item=dao.selectByPrimaryKey(menuId);
 	   if(hasPermission(permissions,item)) {
	 	   
	 	    menuNode.setId(item.getId());
	 	    menuNode.setText(item.getText());
	 	    menuNode.setHref(item.getHref());
	 
	 	   
	 	    List<shopMenu> sub_menuitems=new ArrayList<shopMenu>(); 
	 	    sub_menuitems=dao.getModelsByPid(menuId);
	 	    for(int i=0;i<sub_menuitems.size();i++) {
	 	    	
	 	    	     nodes.add(getMenu(permissions,sub_menuitems.get(i).getId()));
	 	    	
	 	    	
	 	    }
		
	 	    menuNode.setNodes(nodes);
 	   }
 		return menuNode;
	}
	
	@Override
	public Set<String> getPermission(String username) {
		// TODO Auto-generated method stub
		//1  声明 Set<String> set
		Set<String> set=new HashSet<String>();
		
		String roleids=admin_dao.findByUserName(username).getRoleid();
		
		//2 通过roleids获取所有的resource，将其中的permission字段值 装入set
		String[] role_Ids=roleids.split(",");
		
		
		for(int i=0;i<role_Ids.length;i++) {
			//调用role_dao中的方法，根据一个roleid获取一个role
			shopRole role_=role_dao.selectByPrimaryKey(Integer.parseInt(role_Ids[i]));
			
			String resource_ids=role_.getResourceIds();
			String[] R_Ids=resource_ids.split(",");
			
			
			
			for(int j=0;j<R_Ids.length;j++) {
				shopMenu item=dao.selectByPrimaryKey(Integer.parseInt(R_Ids[j]));
				if(item!=null) {
					set.add(item.getPermission());
				}
			}
		}
		
		
		
		return set;
	}
	
	private boolean hasPermission(Set<String> permissions, shopMenu resource) {
        if(resource.getPermission()==null||resource.getPermission().isEmpty()) {
            return true;
        }
        /*for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }*/
        
        if(permissions.contains(resource.getPermission())) {
        	return true;
        }
        return false;
    }

}
