package com.util.management;

import java.util.ArrayList;

import com.vo.MGenre;
import com.vo.MPicture;
import com.vo.Merchandise;
import com.vo.StockLog;

/**
 * @author ������
 * ��Ʒ�����ܵĽӿ�
 */
public interface MerchanManageUtil {

	
	/**
	 * �������ӿ��
	 * @param �����־StockLog,��Ҫ����m_id,sl_num
	 * @return ����Ƿ�ɹ�
	 */
	public boolean addStock(StockLog sl);
	

	
	/**
	 * ���ڸ��������Ϣ
	 * @param ��Ʒ�����ϢMGenre,��Ҫ����m_id,genre1,genre2
	 * @return �����Ƿ�ɹ�
	 */	
	public boolean updateGenre(MGenre mg);
	
	
	/**
	 * ���������Ʒ
	 * @param ��Ʒ��ϢMerchandise,��Ҫ������m_id�������Ԫ��
	 * @param ��ƷͼƬ����ArrayList<MPicture>,��Ÿ���Ʒ��Ҫ�ϴ���������Ƭ
	 * @param ����price,��Ʒ�ļ۸�
	 * @param ����num,��Ʒ������
	 * @return �ɹ��򷵻ذ���������Ϣ��Merchandise,ʧ���򷵻�null
	 */
	public Merchandise addMerchan(Merchandise m,ArrayList<MPicture> am,Double price,int num);


}
