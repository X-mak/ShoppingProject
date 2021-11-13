package com.util.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.vo.Merchandise;

public class MerchanView implements MerchanViewUtil {

	
	
	public ArrayList<Merchandise> showAllMerchanOnSale() {
		MerchandiseD md = new MerchandiseDI();
		ArrayList<Merchandise> am1 = new ArrayList<Merchandise>();
		ArrayList<Merchandise> am2 = new ArrayList<Merchandise>();
		try {
			am1 = md.selectAllMerchanStatus();
			Iterator<Merchandise> im = am1.iterator();
			while(im.hasNext()) {
				Merchandise m = im.next();
				m = md.selectMPicture(m);
				m = md.selectPriceLog(m);
				m = md.selectStockLog(m);
				am2.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return am2;
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
