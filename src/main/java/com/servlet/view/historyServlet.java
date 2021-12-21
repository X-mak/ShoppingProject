package com.servlet.view;

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

import com.util.view.OrdersView;
import com.vo.Orders;




@WebServlet("/historyServlet")
public class historyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrdersView ov = new OrdersView();
		ArrayList<Orders> ListOrder = ov.showAllOrders();
		ArrayList<Orders> res = new ArrayList<Orders>();
		Iterator<Orders> io = ListOrder.iterator();
		while(io.hasNext()) {
			Orders o = io.next();
			if(o.getO_status() == 2) {
				res.add(o);
			}
		}
		session.setAttribute("orders", res);
		response.sendRedirect("view/seller_history/historicalgoods.jsp?pages=1");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
