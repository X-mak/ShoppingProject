package com.dao.merchandise;

import java.sql.SQLException;

import com.vo.MGenre;

/**
 * @author 徐敏阳
 * 商品类别相关的连接数据库接口
 */
public interface MGenreD {

	
	/**
	 * 用于更新商品的类别信息
	 * @param 商品类别信息MGenre,需要包含m_id,genre1,genre2
	 * @return 更新是否成功
	 * @throws SQLException
	 */
	public boolean updateGenre(MGenre mg)throws SQLException;
	
	
	/**
	 * 用于加入新的类别信息
	 * @param 商品类别信息MGenre,需要包含m_id,genre1,genre2
	 * @return 成功则返回插入的MGenre,失败则返回null
	 * @throws SQLException
	 */
	public MGenre insertGenre(MGenre mg)throws SQLException;
	
	
}
