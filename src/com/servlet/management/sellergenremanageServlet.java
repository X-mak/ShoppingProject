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
import com.vo.MGenre;


@WebServlet("/sellergenremanageServlet")
public class sellergenremanageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int m_id = Integer.parseInt((String)request.getParameter("id"));
		String goodgenre1 = request.getParameter("firstgenre");
		String goodgenre2 = request.getParameter("secondgenre");
		MerchanManageUtil mu = new MerchanManage();
		MGenre mg = new MGenre(m_id, goodgenre1, goodgenre2);
		mu.addGenre(mg);
		response.sendRedirect("management/seller_merchanmanage/seller_genremanage_success.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
