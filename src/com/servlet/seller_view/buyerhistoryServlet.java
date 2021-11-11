package com.servlet.seller_view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.seller.SellerUI;
import com.util.seller.SellerUtil;
import com.vo.Orders;


@WebServlet("/buyerhistoryServlet")
public class buyerhistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String b_act = (String)session.getAttribute("b_act");
		SellerUtil su = new SellerUI();
		ArrayList<Orders> ao = su.showBuyerHistory(b_act);
		session.setAttribute("orders", ao);
		response.sendRedirect("seller_viewbuyerinfo/buyer_history.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
