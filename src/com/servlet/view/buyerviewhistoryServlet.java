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
import com.vo.BuyerAccount;
import com.vo.Orders;

@WebServlet("/buyerviewhistoryServlet")
public class buyerviewhistoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BuyerAccount ba = (BuyerAccount)session.getAttribute("buyeruser");
		OrdersView ov = new OrdersView();
		ArrayList<Orders> ao = ov.getBuyerOrders(ba.getB_act());
		session.setAttribute("orders", ao);
		response.sendRedirect("view/buyer_view/buyer_history.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
