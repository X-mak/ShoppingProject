package com.servlet.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.authentication.UserAuthentic;
import com.util.authentication.UserAuthenticaUtil;
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
		String flag1="True";
		HttpSession session=request.getSession();
		UserAuthenticaUtil userAuthentic = new UserAuthentic();
		if(account==null||pwd==null) {
			flag1="False";
			session.setAttribute("flag1", flag1);
			response.sendRedirect("authentication/seller_login/seller_login.jsp");
			return;
		}
		UserAccount ua = new UserAccount(account, pwd);
			if(userAuthentic.checkLogin(ua).equals("seller")) {
				session.setAttribute("selleruser", ua);
				String address = "authentication/seller_login/seller_login_success.jsp";
				response.sendRedirect(address);
			}else if(userAuthentic.checkLogin(ua).equals("buyer")) {
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
