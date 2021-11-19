package com.servlet.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.users.SellerD;
import com.dao.users.SellerDI;
import com.vo.SellerAccount;



@WebServlet("/sellerregisterServlet")
public class sellerregisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String s_acc = (String) request.getParameter("seller_acc");
		String s_pwd1 = (String) request.getParameter("seller_pwd1");
		String s_pwd2 = (String) request.getParameter("seller_pwd2");
		SellerAccount sa = new SellerAccount(s_acc,s_pwd1,0);
		SellerD sd = new SellerDI();
		boolean flag = true;
		if(s_pwd1.equals(s_pwd2)) {
			flag = true;
		}else {
			flag = false;
		}
			if(flag) {//后续增加新的函数来判断该账号是否已经存在，如果存在就进入else分支
				try {
					if(!sd.selectAct(sa)) {
					sd.insertAccount(sa);
					response.sendRedirect("authentication/seller_register/seller_register_success.jsp");
					}
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("authentication/seller_register/seller_register_fail.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
