package com.util.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.merchandise.MerchandiseD;
import com.dao.merchandise.MerchandiseDI;
import com.util.util.GetFull;
import com.vo.Merchandise;

public class MerchanView implements MerchanViewUtil {

	
	
	public ArrayList<Merchandise> showAllMerchanOnSale() {
		MerchandiseD md = new MerchandiseDI();
		GetFull gf = new GetFull();
		ArrayList<Merchandise> am1 = new ArrayList<Merchandise>();
		ArrayList<Merchandise> am2 = new ArrayList<Merchandise>();
		try {
			am1 = md.selectAllMerchanStatus();
			Iterator<Merchandise> im = am1.iterator();
			while(im.hasNext()) {
				Merchandise m = im.next();
				m = gf.getAllMerchan(m);
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
		GetFull gf = new GetFull();
		MerchandiseD md = new MerchandiseDI();
		try {
			ao1 = md.selectAllMerchan();
			Iterator<Merchandise> im = ao1.iterator();
			while(im.hasNext()) {
				Merchandise m = im.next();
				m = gf.getAllMerchan(m);
				ao2.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ao2;
	}
	
	
	public ArrayList<Merchandise> showSelectedMerchan(String words){
		MerchandiseD md = new MerchandiseDI();
		GetFull gf = new GetFull();
		ArrayList<Merchandise> l = new ArrayList<Merchandise>();
		try {
			ArrayList<Merchandise> am = md.selectMerchanLike(words);
			Iterator<Merchandise> im = am.iterator();
			while(im.hasNext()) {
				Merchandise m = im.next();
				m = gf.getAllMerchan(m);
				l.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
