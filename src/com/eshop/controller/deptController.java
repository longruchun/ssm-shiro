package com.eshop.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="/dept")

public class deptController {
	@RequestMapping(value="/index")
	//@RequiresPermissions(value="dept:*")
	public String index() {
	   return "/dept/index";
   }
}
