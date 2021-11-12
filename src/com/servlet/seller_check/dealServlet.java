package com.servlet.seller_check;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.orders.OrdersUI;
import com.util.orders.OrdersUtil;



@WebServlet("/dealServlet")
public class dealServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag;
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		HttpSession session = request.getSession();
		OrdersUtil ou = new OrdersUI();
		flag = ou.finshDeal(o_id);
		if(flag){
			response.sendRedirect("authentication/seller_login/seller_login_success.jsp");
		}
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
