package com.servlet.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.view.OrdersView;
import com.vo.Orders;


@WebServlet("/sellerordermanageServlet")
public class sellerordermanageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		OrdersView ov = new OrdersView();
		ArrayList<Orders> ListOrder = ov.showAllOrders();
		session.setAttribute("orders", ListOrder);
		response.sendRedirect("management/seller_check/buyerinf.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
