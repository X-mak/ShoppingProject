package com.servlet.management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.management.MerchanManage;
import com.util.management.MerchanManageUtil;
import com.vo.StockLog;
import com.vo.UserAccount;

@WebServlet("/sellerstockmanageServlet")
public class sellerstockmanageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int m_id = Integer.parseInt((String)request.getParameter("m_id"));
		String newnum = (String)request.getParameter("newnum");
		 for (int i = newnum.length();--i>=0;){   
			   if (!Character.isDigit(newnum.charAt(i))){ 
				   session.setAttribute("msg3", "false");
				   response.sendRedirect("management/seller_merchanmanage/seller_stockmanage.jsp?m_id="+m_id); 
				   return;
			   } 
			  } 
		int num = Integer.parseInt(newnum);
		MerchanManageUtil mu = new MerchanManage();
		StockLog sl = new StockLog(m_id,num);
		if(mu.addStock(sl))
			session.setAttribute("msg3", "true");
		else
			session.setAttribute("msg3", "false");
		response.sendRedirect("management/seller_merchanmanage/seller_stockmanage.jsp?m_id="+m_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
