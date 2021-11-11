package com.util.index;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.dao.seller.SellerD;
import com.dao.seller.SellerDI;
import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.Merchandise;
import com.vo.SellerAccount;

public class IndexUI implements IndexUtil {

	
	public BuyerInfo addBuyer(String act,String pwd,String ads,int tele) {
		BuyerInfo bi = null;
		BuyerD bd = new BuyerDI();
		try {
			ArrayList<BuyerAddress> aba = new ArrayList<BuyerAddress>();
			BuyerAccount ba = new BuyerAccount(act,pwd);
			if(!bd.selectAct(ba)) {
				bi = new BuyerInfo(act,tele);
				BuyerAddress bad = new BuyerAddress(act,ads);
				bd.insertAccount(ba);              //顺序和下一行反了
				bd.insertInfo(bi);
				aba.add(bd.insertAddress(bad));
				bi.setBuyerAccount(ba);
				bi.setBuyerAddress(aba);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bi;
	}
	
	
	
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
	
	
	
	
	public boolean checkLogin(String act,String pwd,String type) {
		BuyerD bd = new BuyerDI();
		SellerD sd = new SellerDI();
		boolean flag = false;
		try {
			if(type.equals("buyer")) {
				BuyerAccount ba = new BuyerAccount(act,pwd);
				flag = bd.selectAccount(ba);					
			}
			else if(type.equals("seller")) {
				
				SellerAccount sa = new SellerAccount(act,pwd);
				System.out.println(sa.toString());
				flag = sd.selectAccount(sa);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
