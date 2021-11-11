package com.servlet.seller_check;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.orders.OrdersUI;
import com.util.orders.OrdersUtil;
import com.vo.Orders;


@WebServlet("/buyerServlet")
public class buyerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		OrdersUtil ou = new OrdersUI();
		ArrayList<Orders> ListOrder = ou.showAllOrders();
		session.setAttribute("orders", ListOrder);
		response.sendRedirect("seller_check/buyerinf.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
