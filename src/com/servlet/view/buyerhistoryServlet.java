package com.servlet.view;

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


@WebServlet("/buyerhistoryServlet")
public class buyerhistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String b_act = (String)request.getParameter("b_act");
		System.out.println(b_act);
		OrdersView ov = new OrdersView();
		ArrayList<Orders> ao = ov.getBuyerOrders(b_act);
		session.setAttribute("orders", ao);
		response.sendRedirect("view/seller_viewbuyerinfo/buyer_history.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
