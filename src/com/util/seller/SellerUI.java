package com.util.seller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
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
import com.dao.orders.OrdersD;
import com.dao.orders.OrdersDI;
import com.dao.seller.SellerD;
import com.dao.seller.SellerDI;
import com.vo.BuyerInfo;
import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.Orders;
import com.vo.PriceLog;
import com.vo.SellerAccount;
import com.vo.StockLog;

public class SellerUI implements SellerUtil {

	
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
	
	
	
	public Merchandise getFull(int m_id){
		MerchandiseD md = new MerchandiseDI();
		Merchandise m = null;
		try {
			m = md.selectMerchan(m_id);
			m = md.selectMPicture(m);
			m = md.selectPriceLog(m);
			m = md.selectStockLog(m);
			m.setM_price(m.getPriceLog().get(0).getPl_price());
			m.setM_num(m.getStockLog().get(0).getSl_num());
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	
	
	public boolean changePwd(String act,String old_pwd,String new_pwd) {
		boolean flag = false;
		SellerD sd = new SellerDI();
		try {
			SellerAccount s = new SellerAccount(act,old_pwd);
			if(sd.selectAccount(s)) {
				flag = true;
				sd.updatePwd(s, new_pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public ArrayList<BuyerInfo> showAllBuyers(){
		ArrayList<BuyerInfo> ab = new ArrayList<BuyerInfo>();
		BuyerD bd = new BuyerDI();
		try {
			ab = bd.selectAllInfo();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
	
	
	
	public ArrayList<Orders> showBuyerHistory(String b_act){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectByBuyerStatus(b_act, 2);
			Iterator<Orders> io = ao1.iterator();
			while(io.hasNext()) {
				Orders o = io.next();
				o = od.selectBuyerInfo(o);
				o = od.selectMerchandise(o);
				ao2.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
	}
	
	
	
	public ArrayList<Orders> showSellerHistory(){
		ArrayList<Orders> ao1 = new ArrayList<Orders>();
		ArrayList<Orders> ao2 = new ArrayList<Orders>();
		OrdersD od = new OrdersDI();
		try {
			ao1 = od.selectAllOrders();
			Iterator<Orders> io = ao1.iterator();
			while(io.hasNext()) {
				Orders o = io.next();
				o = od.selectBuyerInfo(o);
				o = od.selectMerchandise(o);
				ao2.add(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
	}
	
	
	
	public ArrayList<Merchandise> showAllMerchan(){
		ArrayList<Merchandise> ao1 = new ArrayList<Merchandise>();
		ArrayList<Merchandise> ao2 = new ArrayList<Merchandise>();
		MerchandiseD md = new MerchandiseDI();
		try {
			ao1 = md.selectAllMerchan();
			Iterator<Merchandise> im = ao1.iterator();
			while(im.hasNext()) {
				Merchandise m = im.next();
				m = md.selectMPicture(m);
				m = md.selectPriceLog(m);
				m = md.selectStockLog(m);
				m.setM_price(m.getPriceLog().get(0).getPl_price());
				m.setM_num(m.getStockLog().get(0).getSl_num());
				ao2.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
	}
}
