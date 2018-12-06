package com.eshop.dao;

import java.util.List;
import java.util.Map;

import com.eshop.model.shopPet;


public interface IshopPetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shopPet record);

    int insertSelective(shopPet record);

    shopPet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shopPet record);

    int updateByPrimaryKey(shopPet record);
    
    List<shopPet> getAll();
    
    List<shopPet> pager(Map<String,Integer> map);
}