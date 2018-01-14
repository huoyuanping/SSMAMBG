package com.et.service;

import java.util.List;
import java.util.Map;

import com.et.entity.Food;

public interface MyFoodService {
	/**
	 * ��ѯ
	 * @param foodname
	 * @return
	 */
	public abstract List<Food> queryAllFood(String foodname);
	/**
	 * ɾ��
	 * @param foodId
	 */
	public abstract void deleteFood(String foodId);
	/**
	 * ���
	 * @param foodName
	 * @param price
	 */
	public abstract void saveFood(String foodName, String price);
	/**
	 * �޸�
	 * @param foodId
	 * @param foodName
	 * @param price
	 */
	public abstract void updateFood(String foodId, String foodName, String price);

}