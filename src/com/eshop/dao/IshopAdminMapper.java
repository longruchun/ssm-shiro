package com.eshop.dao;

import java.util.List;

import com.eshop.model.shopAdmin;

public interface IshopAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shopAdmin record);

    int insertSelective(shopAdmin record);

    shopAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shopAdmin record);

    int updateByPrimaryKey(shopAdmin record);
    
    shopAdmin findByUserName(String name);
}