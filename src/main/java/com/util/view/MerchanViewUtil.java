package com.util.view;

import java.util.ArrayList;

import com.vo.Merchandise;

/**
 * @author 徐敏阳
 * 展示商品信息的接口
 */
public interface MerchanViewUtil {

	
	/**
	 * 用于展示所有上架中的商品
	 * @return 成功则返回包含所有上架的Merchandise的数组,失败则返回空数组
	 */
	public ArrayList<Merchandise> showAllMerchanOnSale();
	
	
	/**
	 * 用于展示所有商品
	 * @return 成功则返回包含所有Merchandise的数组,失败则返回空数组
	 */
	public ArrayList<Merchandise> showAllMerchan();
	
	
	/**
	 * 用于获得搜索得的所有商品
	 * @param 字符串words,搜索的关键字
	 * @return 成功则返回包含所有选择后的Merchandise的数组,失败则返回空数组
	 */
	public ArrayList<Merchandise> showSelectedMerchan(String words);
	//搜索算法，words为搜索的关键字，返回完整的Merchandise列表
	
	
}
