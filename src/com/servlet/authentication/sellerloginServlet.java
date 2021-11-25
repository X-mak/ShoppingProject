package com.servlet.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.util.GetFull;
import com.util.util.GetFullUtil;
import com.vo.UserAccount;

/**
 * Servlet implementation class sellerloginServlet
 */
@WebServlet("/sellerloginServlet")
public class sellerloginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account=request.getParameter("selleracnumber");
		String pwd=request.getParameter("sellerpwd");
		GetFullUtil gf = new GetFull();
		UserAccount ua = new UserAccount(account, pwd);
		HttpSession session=request.getSession();
		ua = gf.getAllUser(ua);
		String flag1="True";
			if(ua.getUserGroup().getU_role().equals("seller")) {
				session.setAttribute("selleruser", ua);
				String address = "authentication/seller_login/seller_login_success.jsp";
				response.sendRedirect(address);
			}else if(ua.getUserGroup().getU_role().equals("buyer")) {
				session.setAttribute("buyeruser", ua);
				response.sendRedirect("authentication/buyer_login/buyer_login_success.jsp");
			}
			else {
				flag1="False";
				session.setAttribute("flag1", flag1);
				response.sendRedirect("authentication/seller_login/seller_login.jsp");
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
