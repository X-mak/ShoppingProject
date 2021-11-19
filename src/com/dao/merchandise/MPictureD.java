package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.MPicture;

/**
 * @author 徐敏阳
 * 商品图片相关的连接数据库接口
 */
public interface MPictureD {

	
	/**
	 * 用于加入新的商品图片
	 * @param 商品图片MPicture,需要包括p_ads,m_id
	 * @return 成功则返回包含主键的MPicture,失败则返回原参数
	 * @throws SQLException
	 */
	public MPicture insertPicture(MPicture p)throws SQLException;
	
	
}
