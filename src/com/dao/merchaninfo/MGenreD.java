package com.dao.merchaninfo;

import java.sql.SQLException;

import com.vo.MGenre;

public interface MGenreD {

	
	public boolean updateGenre(MGenre mg)throws SQLException;
	
	
	public MGenre insertGenre(MGenre mg)throws SQLException;
	
	
}
