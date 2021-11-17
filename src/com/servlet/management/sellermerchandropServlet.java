package com.servlet.management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.management.MerchanManage;
import com.util.management.MerchanManageUtil;
import com.vo.SellerAccount;


@WebServlet("/sellermerchandropServlet")
public class sellermerchandropServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		SellerAccount as = (SellerAccount)session.getAttribute("selleruser");
		int m_id = Integer.parseInt((String)request.getParameter("m_id"));
		MerchanManageUtil mu = new MerchanManage();
		mu.dropMerchan(m_id);
		response.sendRedirect("management/seller_merchanmanage/seller_merchandrop_success.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
