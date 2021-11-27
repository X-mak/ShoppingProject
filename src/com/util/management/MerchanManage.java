package com.util.management;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.dao.merchandise.MGenreDao;
import com.dao.merchandise.MGenreDaoImpl;
import com.dao.merchandise.MPictureDao;
import com.dao.merchandise.MPictureDaoImpl;
import com.dao.merchandise.MerchandiseDao;
import com.dao.merchandise.MerchandiseDaoImpl;
import com.dao.merchandise.PriceLogDao;
import com.dao.merchandise.PriceLogDaoImpl;
import com.dao.merchandise.StockLogDao;
import com.dao.merchandise.StockLogDaoImpl;
import com.util.util.GetFull;
import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.PriceLog;
import com.vo.StockLog;

public class MerchanManage implements MerchanManageUtil {

	public boolean addStock(StockLog sl) {
		boolean flag = false;
		StockLogDao sld = new StockLogDaoImpl();
		MerchandiseDao md = new MerchandiseDaoImpl();
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

	
	
	public boolean updateGenre(MGenre mg) {
		boolean flag = false;
		MGenreDao mgd = new MGenreDaoImpl();
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
		MerchandiseDao md = new MerchandiseDaoImpl();
		MPictureDao pd = new MPictureDaoImpl();
		PriceLogDao pld = new PriceLogDaoImpl();
		StockLogDao sd = new StockLogDaoImpl();
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
			MGenre mg = new MGenre(m.getM_id());
			pl = pld.insertLog(pl);
			sl = sd.insertLog(sl);
			apl.add(pl);
			asl.add(sl);
			m.setmGenre(mg);
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
