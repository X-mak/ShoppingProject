package com.dao.merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Merchandise;

/**
 * @author 徐敏阳
 * 商品相关的连接数据库接口
 */
public interface MerchandiseD {

	
	/**
	 * 用于加入一个新商品
	 * @param 商品Merchandise,需要包括m_id外所有元素
	 * @return 成功则返回包含主键的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise insertMerchan(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获取商品的所有图片信息
	 * @param 商品Merchandise,需要包括m_id
	 * @return 成功则返回包含所有图片信息的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise selectMPicture(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获取商品的所有价格日志
	 * @param 商品Merchandise,需要包括m_id
	 * @return 成功则返回包含所有价格日志的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise selectPriceLog(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获取商品的所有库存日志
	 * @param 商品Merchandise,需要包括m_id
	 * @return 成功则返回包含所有库存日志的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise selectStockLog(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获取商品的类别信息
	 * @param 商品Merchandise,需要包括m_id
	 * @return 成功则返回包含类别信息的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise selectMGenre(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获取商品的基本信息
	 * @param 商品Merchandise,需要包括m_id
	 * @return 成功则返回包含基本信息的Merchandise,失败则返回原参数
	 * @throws SQLException
	 */
	public Merchandise selectMerchan(Merchandise m)throws SQLException;
	
	
	/**
	 * 用于获得所有销售中的商品
	 * @return 成功则返回所有销售中的Merchandise的数组,失败则返回空数组
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectAllMerchanStatus()throws SQLException;
	
	
	/**
	 * 用于获得所有商品
	 * @return 成功则返回所有Merchandise的数组,失败则返回空数组
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectAllMerchan()throws SQLException;
	
	
	/**
	 * 用于获得搜索相关的商品
	 * @param 字符串words,搜索的关键字
	 * @return 成功则返回所有搜索得到的Merchandise的数组,失败则返回空数组
	 * @throws SQLException
	 */
	public ArrayList<Merchandise> selectMerchanLike(String words)throws SQLException;
	
	
	/**
	 * 用于更新商品的上架状态
	 * @param 商品Merchandise,需要包括m_id
	 * @param 整数status,商品的状态,1为销售中,0为下架中
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateStatus(Merchandise m,int status)throws SQLException;
	
}
