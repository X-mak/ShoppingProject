package com.dao.merchaninfo;

import java.sql.SQLException;

import com.vo.MGenre;

public interface MGenreD {

	
	public boolean updateGenre2(int m_id,String genre2)throws SQLException;
	
	
	public MGenre insertGenre1(MGenre mg)throws SQLException;
	
	
}
