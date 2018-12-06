package com.eshop.biz;

import java.util.List;
import java.util.Map;

import com.eshop.model.shopPet;

public interface IshopPetBiz extends IBaseBiz<shopPet> {
	List<shopPet> pager(Map<String,Integer> map);
}
