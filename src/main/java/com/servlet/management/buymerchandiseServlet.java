package com.servlet.management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.management.OrdersManage;
import com.util.management.OrdersManageUtil;
import com.vo.UserAccount;

@WebServlet("/buymerchandiseServlet")
public class buymerchandiseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int m_id = Integer.parseInt((String) session.getAttribute("m_id"));
		String buynum = (String)session.getAttribute("buynum");
		UserAccount ba = (UserAccount)session.getAttribute("buyeruser");
		OrdersManageUtil om =new OrdersManage();
		for (int i = buynum.length();--i>=0;){   
			   if (!Character.isDigit(buynum.charAt(i))){ 
				   session.setAttribute("msg5", "false");
				   response.sendRedirect("management/buyer_buy/buyer_buy_fail.jsp"); 
				   return;
			   } 
		} 
		int buy_num = Integer.parseInt(buynum);
		if(om.havaOrder(m_id, ba.getU_act(), buy_num) == null)
			session.setAttribute("msg5", "false");
		else 
			session.setAttribute("msg5", "true");
		response.sendRedirect("management/buyer_buy/merchandiseinf.jsp?m_id="+m_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
