package com.util.view;

import java.util.ArrayList;

import com.vo.BuyerInfo;

/**
 * @author 徐敏阳
 * 展示买家信息的接口
 */
public interface BuyerViewUtil {

	
	/**
	 * 用于展示所有的买家
	 * @return 成功则返回包含所有信息的BuyerInfo的数组,失败则返回空的数组
	 */
	public ArrayList<BuyerInfo> showAllBuyers();
	
	
}
