package com.servlet.management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.merchandise.MerchandiseDao;
import com.dao.merchandise.MerchandiseDaoImpl;
import com.vo.Merchandise;
import com.vo.UserAccount;


@WebServlet("/sellermerchandropServlet")
public class sellermerchandropServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserAccount as = (UserAccount)session.getAttribute("selleruser");
		int m_id = Integer.parseInt((String)request.getParameter("m_id"));
		MerchandiseDao md = new MerchandiseDaoImpl();
		try {
			md.updateStatus(new Merchandise(m_id), 0);
			session.setAttribute("msg3", "true");
		} catch (Exception e) {
			session.setAttribute("msg3", "false");
			e.printStackTrace();
		}
		response.sendRedirect("management/seller_merchanmanage/seller_merchandrop.jsp?m_id"+m_id);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
