package com.util.management;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.dao.merchandise.MGenreD;
import com.dao.merchandise.MGenreDI;
import com.dao.merchandise.MPictureD;
import com.dao.merchandise.MPictureDI;
import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.merchandise.PriceLogD;
import com.dao.merchandise.PriceLogDI;
import com.dao.merchandise.StockLogD;
import com.dao.merchandise.StockLogDI;
import com.util.util.GetFull;
import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.PriceLog;
import com.vo.StockLog;

public class MerchanManage implements MerchanManageUtil {

	public boolean addStock(StockLog sl) {
		boolean flag = false;
		StockLogD sld = new StockLogDI();
		MerchandiseD md = new MerchandiseDI();
		try {
			Merchandise m = new Merchandise(sl.getM_id());
			m = md.selectMerchan(m);
			m = md.selectStockLog(m);
			m.setM_num(m.getStockLog().get(0).getSl_num());
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(date);
			sl = new StockLog(m.getM_id(),m.getM_num()+sl.getSl_num(),time);
			sl = sld.insertLog(sl);
			if(m.getM_status() == 0) {
				md.updateStatus(m, 1);
			}
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean addGenre(MGenre mg) {
		boolean flag = false;
		MGenreD mgd = new MGenreDI();
		try {
			if(mgd.insertGenre(mg) != null) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean updateGenre(MGenre mg) {
		boolean flag = false;
		MGenreD mgd = new MGenreDI();
		try {
			if(mgd.updateGenre(mg)) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
		
	public Merchandise addMerchan(Merchandise m,ArrayList<MPicture> am,int price,int num) {
		MerchandiseD md = new MerchandiseDI();
		MPictureD pd = new MPictureDI();
		PriceLogD pld = new PriceLogDI();
		StockLogD sd = new StockLogDI();
		ArrayList<MPicture> amp = new ArrayList<MPicture>();
		ArrayList<PriceLog> apl = new ArrayList<PriceLog>();
		ArrayList<StockLog> asl = new ArrayList<StockLog>();
		Merchandise res = null;
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
			pl = pld.insertLog(pl);
			sl = sd.insertLog(sl);
			apl.add(pl);
			asl.add(sl);
			m.setPriceLog(apl);
			m.setStockLog(asl);
			res = m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
