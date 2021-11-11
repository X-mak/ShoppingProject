package com.servlet.buyer_register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.buyer.BuyerD;
import com.dao.buyer.BuyerDI;
import com.util.index.IndexUI;
import com.util.index.IndexUtil;
import com.vo.BuyerAccount;


@WebServlet("/buyerregisterServlet")
public class buyerregisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		try {
		HttpSession session = request.getSession();
		String b_acc = (String) request.getParameter("buyer_acc");
		String b_pwd1 = (String) request.getParameter("buyer_pwd1");
		String b_pwd2 = (String) request.getParameter("buyer_pwd2");
		int b_tel = Integer.parseInt(request.getParameter("buyer_tel"));
		String b_ads = (String) request.getParameter("buyer_ads");
		BuyerD bd = new BuyerDI();
		BuyerAccount ba = new BuyerAccount(b_acc,b_pwd1);
		IndexUtil iu = new IndexUI();
		boolean flag = true;
		if(b_pwd1.equals(b_pwd2)&&!b_acc.equals("")&&!b_ads.equals("")&&b_tel>10000) {
			flag = true;
		}else {
			flag = false;
		}
			if(flag) {
					if(!bd.selectAct(ba)) {//≤ª‘ –Ì’À∫≈÷ÿ∏¥
					iu.addBuyer(b_acc, b_pwd1, b_ads, b_tel);
					response.sendRedirect("buyer_register/buyer_register_success.jsp");
					}else {
					response.sendRedirect("buyer_register/buyer_register_fail.jsp");
					}
				 
			}else {
				response.sendRedirect("buyer_register/buyer_register_fail.jsp");
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
