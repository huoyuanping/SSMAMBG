package com.et.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.FoodMapper;
import com.et.entity.Food;
import com.et.entity.FoodExample;
import com.et.entity.FoodExample.Criteria;
import com.et.service.MyFoodService;
@Service
public class MyFoodServiceImpl implements  MyFoodService {
	
	@Autowired
	FoodMapper fm;
	
	public List<Food> queryAllFood(String foodname){
		FoodExample fe=new FoodExample();
		Criteria c=fe.createCriteria();
		c.andFoodnameLike("%"+foodname+"%");
		return fm.selectByExample(fe);
	}

	
	public void deleteFood(String foodId){
		fm.deleteByPrimaryKey(Integer.valueOf(foodId));
	}
	
	
	public void saveFood(String foodName,String price){
		Food food=new Food();
		food.setFoodname(foodName);
		food.setPrice(Integer.valueOf(price));
		fm.insert(food);
		
	}
	
	
	public void updateFood(String foodId,String foodName,String price){
		Food food=new Food();
		food.setFoodid(Integer.valueOf(foodId));
		food.setFoodname(foodName);
		food.setPrice(Integer.valueOf(price));
		fm.updateByPrimaryKey(food);
	}
	
}
