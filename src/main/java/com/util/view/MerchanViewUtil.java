package com.util.view;

import java.util.ArrayList;

import com.vo.Merchandise;

/**
 * @author ������
 * չʾ��Ʒ��Ϣ�Ľӿ�
 */
public interface MerchanViewUtil {

	
	/**
	 * ����չʾ�����ϼ��е���Ʒ
	 * @return �ɹ��򷵻ذ��������ϼܵ�Merchandise������,ʧ���򷵻ؿ�����
	 */
	public ArrayList<Merchandise> showAllMerchanOnSale();
	
	
	/**
	 * ����չʾ������Ʒ
	 * @return �ɹ��򷵻ذ�������Merchandise������,ʧ���򷵻ؿ�����
	 */
	public ArrayList<Merchandise> showAllMerchan();
	
	
	/**
	 * ���ڻ�������õ�������Ʒ
	 * @param �ַ���words,�����Ĺؼ���
	 * @return �ɹ��򷵻ذ�������ѡ����Merchandise������,ʧ���򷵻ؿ�����
	 */
	public ArrayList<Merchandise> showSelectedMerchan(String words);
	//�����㷨��wordsΪ�����Ĺؼ��֣�����������Merchandise�б�
	
	
}
