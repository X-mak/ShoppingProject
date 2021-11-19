package com.util.management;

import java.util.ArrayList;

import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.StockLog;

/**
 * @author 徐敏阳
 * 商品管理功能的接口
 */
public interface MerchanManageUtil {

	
	/**
	 * 用于增加库存
	 * @param 库存日志StockLog,需要包含m_id,sl_num
	 * @return 添加是否成功
	 */
	public boolean addStock(StockLog sl);
	
	
	/**
	 * 用于增加类别信息
	 * @param 商品类别信息MGenre,需要包含m_id,genre1,genre2
	 * @return 添加是否成功
	 */
	public boolean addGenre(MGenre mg);
	
	/**
	 * 用于更新类别信息
	 * @param 商品类别信息MGenre,需要包含m_id,genre1,genre2
	 * @return 更新是否成功
	 */	
	public boolean updateGenre(MGenre mg);
	
	
	/**
	 * 用于添加商品
	 * @param 商品信息Merchandise,需要包含除m_id外的所有元素
	 * @param 商品图片数组ArrayList<MPicture>,存放该商品需要上传的所有照片
	 * @param 整数price,商品的价格
	 * @param 整数num,商品的数量
	 * @return 成功则返回包含所有信息的Merchandise,失败则返回null
	 */
	public Merchandise addMerchan(Merchandise m,ArrayList<MPicture> am,int price,int num);


}
