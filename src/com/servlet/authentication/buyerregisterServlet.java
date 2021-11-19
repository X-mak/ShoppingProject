package com.servlet.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.users.BuyerD;
import com.dao.users.BuyerDI;
import com.util.authentication.BuyerAuthentic;
import com.util.authentication.BuyerAuthenticUtil;
import com.vo.BuyerAccount;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;


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
		BuyerAuthenticUtil bac = new BuyerAuthentic();
		boolean flag = true;
		if(b_pwd1.equals(b_pwd2)&&!b_acc.equals("")&&!b_ads.equals("")&&b_tel>10000) {
			flag = true;
		}else {
			flag = false;
		}
			if(flag) {
					if(!bd.selectAct(ba)) {//≤ª‘ –Ì’À∫≈÷ÿ∏¥
					BuyerInfo bi = new BuyerInfo(b_acc,b_tel);
					BuyerAddress bAddress = new BuyerAddress(b_acc,b_ads);
					bac.addBuyer(ba,bi,bAddress);
					response.sendRedirect("authentication/buyer_register/buyer_register_success.jsp");
					}else {
					response.sendRedirect("authentication/buyer_register/buyer_register_fail.jsp");
					}
				 
			}else {
				response.sendRedirect("authentication/buyer_register/buyer_register_fail.jsp");
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
