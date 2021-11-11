package com.servlet.seller_alter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.seller.SellerUI;
import com.util.seller.SellerUtil;



@WebServlet("/sellerpwdchangeServlet")
public class sellerpwdchangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("selleracnumber");
		String pwd = request.getParameter("selleroldpwd");
		String newpwd = request.getParameter("sellernewpwd");
		HttpSession session = request.getSession();
		SellerUtil su = new SellerUI();
			if(su.changePwd(account, pwd, newpwd)) {
				response.sendRedirect("seller_alter/sellerpwdchange_success.jsp");
			}else {
				response.sendRedirect("seller_alter/sellerpwdchange_fail.jsp");
			}
	}			
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
