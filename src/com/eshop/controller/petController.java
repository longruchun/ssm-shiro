package com.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.eshop.biz.IshopPetBiz;
import com.eshop.model.shopPet;
import com.eshop.util.systemContext;

@Controller
@RequestMapping(value="/pet")
public class petController {
    
	IshopPetBiz biz;
	
	
	
	@Resource(name="shopPetBizImpl")
	public void setBiz(IshopPetBiz biz) {
		this.biz = biz;
	}




	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String pager(Model model){

		model.addAttribute("list",biz.getAll());
		return "/pet/list";
	}
	
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		
		return "/pet/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(shopPet pet,Model model,@RequestParam("photo_1") CommonsMultipartFile photo_1,HttpServletRequest req) throws IllegalStateException, IOException {
		//�����ͼƬ�ϴ�������ɱ��浽���ݿ�Ĳ���
		//��һ�����ϴ�
		String virtual_path="/Public/upload/pet/"+new Date().getTime()+photo_1.getOriginalFilename();
       	String local_path=req.getRealPath(virtual_path);
        File newFile=new File(local_path);
        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��
        photo_1.transferTo(newFile);

        pet.setPhoto(virtual_path);
		
		biz.insert(pet);
		model.addAttribute("list",biz.getAll());
		return "redirect:/pet/list";
	}
	
	@RequestMapping(value="/{id}/del",method=RequestMethod.GET)
	public String del(@PathVariable int id) {
		System.out.println("ɾ�����id="+id+"�ĳ���");
		return "";
	}
}
