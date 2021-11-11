package com.util.merchan;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.merchaninfo.MGenreD;
import com.dao.merchaninfo.MGenreDI;
import com.dao.merchaninfo.StockLogD;
import com.dao.merchaninfo.StockLogDI;
import com.vo.MGenre;
import com.vo.Merchandise;
import com.vo.StockLog;

public class MerchandiseUI implements MerchandiseUtil {

	
	
	public Merchandise getAllMerchan(Merchandise m) {
		MerchandiseD md = new MerchandiseDI();
		Merchandise new_m = m;
		try {
			new_m = md.selectMerchan(m.getM_id());
			new_m = md.selectMGenre(new_m);
			new_m = md.selectMPicture(new_m);
			new_m = md.selectPriceLog(new_m);
			new_m = md.selectStockLog(new_m);
			new_m.setM_price(new_m.getPriceLog().get(0).getPl_price());
			new_m.setM_num(new_m.getStockLog().get(0).getSl_num());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new_m;
	}
	
	
	
	public boolean dropMerchan(int m_id){
		boolean flag = false;
		MerchandiseD md = new MerchandiseDI();
		try {
			Merchandise m = new Merchandise(m_id);
			flag = md.updateStatus(m, 0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public boolean republishMerchan(int m_id) {
		boolean flag = false;
		MerchandiseD md = new MerchandiseDI();
		try {
			Merchandise m = new Merchandise(m_id);
			flag = md.updateStatus(m, 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public Merchandise addStock(int m_id,int num) {
		Merchandise m = null;
		StockLogD sld = new StockLogDI();
		MerchandiseD md = new MerchandiseDI();
		try {
			Merchandise m2 = md.selectMerchan(m_id);
			m2 = md.selectStockLog(m2);
			m2.setM_num(m2.getStockLog().get(0).getSl_num());
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(date);
			StockLog sl = new StockLog(m_id,m2.getM_num()+num,time);
			sl = sld.insertLog(sl);
			if(m2.getM_status() == 0) {
				md.updateStatus(m2, 1);
			}
			m = getAllMerchan(m2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	public Merchandise addGenre2(int m_id,String genre2) {
		Merchandise m = null;
		MGenreD mgd = new MGenreDI();
		MerchandiseD md = new MerchandiseDI();
		try {
			m = md.selectMerchan(m_id);
			m = md.selectMGenre(m);
			MGenre mg = m.getmGenre();
			mg.setGenre2(genre2);
			mgd.updateGenre2(m_id, genre2);
			m = getAllMerchan(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
