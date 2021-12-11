package com.servlet.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.authentication.BuyerAuthentic;
import com.util.authentication.BuyerAuthenticUtil;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.UserAccount;


@WebServlet("/buyerinfochangeServlet")
public class buyerinfochangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserAccount bac = (UserAccount)session.getAttribute("buyeruser");
		String b_acc = bac.getU_act();
		String b_tel = request.getParameter("newtel");
		String b_ads = request.getParameter("newadd");
		for (int i = b_tel.length();--i>=0;){   
			   if (!Character.isDigit(b_tel.charAt(i))){ 
			    response.sendRedirect("authentication/buyer_alter/buyer_changeinfo.jsp"); 
			    session.setAttribute("msg6", "false");
			    return;
			   } 
		} 
		int b_tele = Integer.parseInt(b_tel);
		BuyerAuthenticUtil ba = new BuyerAuthentic();
		BuyerInfo bi = new BuyerInfo(b_acc,b_tele);
		BuyerAddress bAddress = new BuyerAddress(b_acc,b_ads);
		if(ba.changeInfo(bi,bAddress) == null)
			session.setAttribute("msg6", "false");
		else
			session.setAttribute("msg6", "true");
		response.sendRedirect("authentication/buyer_alter/buyer_changeinfo.jsp");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
