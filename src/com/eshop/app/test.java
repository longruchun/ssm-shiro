package com.eshop.app;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eshop.biz.IshopAdminBiz;
import com.eshop.model.shopAdmin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext.xml"
})
public class test {
	@Resource
    IshopAdminBiz biz;
	
	@Test
	public void addAdmin() {
		
		shopAdmin user=new shopAdmin();
		user.setName("ÔÆ·É");
		user.setPassword("123456");
		user.setId(3);
		user.setRoleid("6");
    	biz.insertSelective(user);
    	
    	System.out.println("ok");
    	
    }
}
