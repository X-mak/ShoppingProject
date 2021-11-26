package com.servlet.view;

import java.io.IOException;
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
import com.vo.UserAccount;

@WebServlet("/buyerviewhistoryServlet")
public class buyerviewhistoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount ba = (UserAccount)session.getAttribute("buyeruser");
		OrdersView ov = new OrdersView();
		ArrayList<Orders> ao = ov.getBuyerOrders(ba.getU_act());
		ArrayList<Orders> res = new ArrayList<Orders>();
		Iterator<Orders> io = ao.iterator();
		while(io.hasNext()) {
			Orders o = io.next();
			if(o.getO_status() == 2) {
				res.add(o);
			}
		}
		session.setAttribute("orders", res);
		response.sendRedirect("view/buyer_view/buyer_history.jsp?pages=1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
