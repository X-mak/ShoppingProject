package com.servlet.management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.management.OrdersManage;



@WebServlet("/dealServlet")
public class dealServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag;
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		HttpSession session = request.getSession();
		OrdersManage om = new OrdersManage();
		flag = om.finshDeal(o_id);
		if(flag){
			response.sendRedirect("authentication/seller_login/seller_login_success.jsp");
		}
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
