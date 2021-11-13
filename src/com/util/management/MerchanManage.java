package com.util.management;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.merchaninfo.MGenreD;
import com.dao.merchaninfo.MGenreDI;
import com.dao.merchaninfo.MPictureD;
import com.dao.merchaninfo.MPictureDI;
import com.dao.merchaninfo.PriceLogD;
import com.dao.merchaninfo.PriceLogDI;
import com.dao.merchaninfo.StockLogD;
import com.dao.merchaninfo.StockLogDI;
import com.util.util.GetFull;
import com.util.util.GetFullUtil;
import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.PriceLog;
import com.vo.StockLog;

public class MerchanManage implements MerchanManageUtil {

	
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
		GetFull gf = new GetFull();
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
			m = gf.getAllMerchan(m2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	public Merchandise addGenre2(int m_id,String genre2) {
		Merchandise m = null;
		MGenreD mgd = new MGenreDI();
		MerchandiseD md = new MerchandiseDI();
		GetFull gf = new GetFull();
		try {
			m = md.selectMerchan(m_id);
			m = md.selectMGenre(m);
			MGenre mg = m.getmGenre();
			mg.setGenre2(genre2);
			mgd.updateGenre2(m_id, genre2);
			m = gf.getAllMerchan(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	public Merchandise addMerchan(Merchandise m,ArrayList<MPicture> am,int price,int num,String genre1) {
		MerchandiseD md = new MerchandiseDI();
		MPictureD pd = new MPictureDI();
		PriceLogD pld = new PriceLogDI();
		StockLogD sd = new StockLogDI();
		MGenreD mgd = new MGenreDI();
		ArrayList<MPicture> amp = new ArrayList<MPicture>();
		ArrayList<PriceLog> apl = new ArrayList<PriceLog>();
		ArrayList<StockLog> asl = new ArrayList<StockLog>();
		try {
			m = md.insertMerchan(m);
			Iterator<MPicture> im = am.iterator();
			while(im.hasNext()) {
				MPicture mp = im.next();
				mp.setM_id(m.getM_id());
				mp = pd.insertPicture(mp);
				amp.add(mp); 
			}
			m.setmPicture(amp);			
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(date);
			PriceLog pl = new PriceLog(m.getM_id(),price,time);
			StockLog sl = new StockLog(m.getM_id(),num,time);
			MGenre mg = new MGenre(m.getM_id(),genre1);
			pl = pld.insertLog(pl);
			sl = sd.insertLog(sl);
			mg = mgd.insertGenre1(mg);
			apl.add(pl);
			asl.add(sl);
			m.setPriceLog(apl);
			m.setStockLog(asl);
			m.setmGenre(mg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
}
