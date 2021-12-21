package com.servlet.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.util.authentication.BuyerAuthentic;
import com.util.authentication.BuyerAuthenticUtil;
import com.util.util.Check;
import com.vo.BuyerAddress;
import com.vo.BuyerInfo;
import com.vo.UserAccount;


@WebServlet("/buyerregisterServlet")
public class buyerregisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		try {
		Check check = new Check();
		System.out.println("1");
		HttpSession session = request.getSession();
		String b_acc = (String) request.getParameter("buyer_acc");
		String b_pwd1 = (String) request.getParameter("buyer_pwd1");
		String b_pwd2 = (String) request.getParameter("buyer_pwd2");
		String b_tel1 = (String) request.getParameter("buyer_tel");

		String b_ads = (String) request.getParameter("buyer_ads");
		UserDao ud = new UserDaoImpl();
		UserAccount ba = new UserAccount(b_acc,b_pwd1);
		BuyerAuthenticUtil bac = new BuyerAuthentic();
		boolean flag = true;
		System.out.println("2");
		if(b_pwd1.equals(b_pwd2)&&!b_ads.equals("")&&check.nameiscorrect(b_acc)&&check.pwdiscorrect(b_pwd2)&&check.check_phone(b_tel1)) {
			flag = true;
		}else {
			flag = false;
		}
			if(flag) {
					if(ud.isValid(ba)) {//≤ª‘ –Ì’À∫≈÷ÿ∏¥
					BuyerInfo bi = new BuyerInfo(b_acc,b_tel1);
					BuyerAddress bAddress = new BuyerAddress(b_acc,b_ads);
					bac.addBuyer(ba,bi,bAddress);
					session.setAttribute("msg8", "true");
					response.sendRedirect("authentication/buyer_register/buyer_register.jsp");
					}else {
						session.setAttribute("msg8", "false");
					response.sendRedirect("authentication/buyer_register/buyer_register.jsp");
					}
				 
			}else {
				session.setAttribute("msg8", "false");
				response.sendRedirect("authentication/buyer_register/buyer_register.jsp");
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
