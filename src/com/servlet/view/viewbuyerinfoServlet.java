package com.servlet.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.view.BuyerView;
import com.vo.BuyerInfo;

@WebServlet("/viewbuyerinfoServlet")
public class viewbuyerinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerView bv = new BuyerView();
		HttpSession session = request.getSession();
		ArrayList<BuyerInfo> ab = bv.showAllBuyers();
		session.setAttribute("ab",ab);
		response.sendRedirect("view/seller_viewbuyerinfo/seller_viewbuyerinfo.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
