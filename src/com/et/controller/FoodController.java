package com.et.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.entity.Food;
import com.et.service.MyFoodService;

@Controller
public class FoodController {
	/**
	 * 查询
	 * @RequestParam(required=false)不是必须项
	 */
	@Autowired
	MyFoodService service;
	@ResponseBody
	@RequestMapping("/queryFood")
	public List<Food> queryStudent(String foodname){
		return service.queryAllFood(foodname);
	}
	
	/**
	 * 删除方法
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodid,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			service.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
			
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 添加方法
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			service.saveFood( foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改方法
	 */
	@RequestMapping(value="/food/{foodid}",method={RequestMethod.PUT})
	public String updateFood(@PathVariable String foodid,String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			service.updateFood(foodid, foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
