package com.servlet.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.seller.SellerD;
import com.dao.seller.SellerDI;
import com.util.authentication.SellerAuthentic;
import com.vo.SellerAccount;

/**
 * Servlet implementation class sellerloginServlet
 */
@WebServlet("/sellerloginServlet")
public class sellerloginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account=request.getParameter("selleracnumber");
		String pwd=request.getParameter("sellerpwd");
		SellerAccount sa = new SellerAccount(account,pwd,1);  //本次还没有管理员，所以选择没有status的构造方法构造
		SellerAuthentic sac = new SellerAuthentic();
		HttpSession session=request.getSession();
		String flag1="True";
			if(sac.checkLogin(account, pwd)) {
				session.setAttribute("selleruser", sa);
				String address = "authentication/seller_login/seller_login_success.jsp";
				response.sendRedirect(address);
			}else {
				flag1="False";
				session.setAttribute("flag1", flag1);
				response.sendRedirect("authentication/seller_login/seller_login.jsp");
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
