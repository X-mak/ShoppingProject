package com.util.merchan;

import com.vo.Merchandise;

public interface MerchandiseUtil {

	
	public Merchandise getAllMerchan(Merchandise m);
	
	
	public boolean dropMerchan(int m_id);
	
	
	public boolean republishMerchan(int m_id);
	
	
	public Merchandise addStock(int m_id,int num);
	
	
	public Merchandise addGenre2(int m_id,String genre2);
	
}
