package com.util.view;

import java.util.ArrayList;

import com.vo.Merchandise;

public interface MerchanViewUtil {

	
	public ArrayList<Merchandise> showAllMerchanOnSale();
	
	
	public ArrayList<Merchandise> showAllMerchan();
	
	
	public ArrayList<Merchandise> showSelectedMerchan(String words);
	//搜索算法，words为搜索的关键字，返回完整的Merchandise列表
	
	
}
