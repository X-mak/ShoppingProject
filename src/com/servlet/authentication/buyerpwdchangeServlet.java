package com.servlet.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.authentication.BuyerAuthentic;
import com.util.authentication.BuyerAuthenticUtil;
import com.vo.BuyerAccount;

@WebServlet("/buyerpwdchangeServlet")
public class buyerpwdchangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("buyeracnumber");
		String pwd = request.getParameter("buyeroldpwd");
		String newpwd = request.getParameter("buyernewpwd");
		HttpSession session = request.getSession();
		BuyerAuthenticUtil bu = new BuyerAuthentic();
		BuyerAccount ba = new BuyerAccount(account, pwd);
			if(bu.changePwd(ba, newpwd)) {
				response.sendRedirect("authentication/buyer_alter/buyer_changepwd_success.jsp");
			}else {
				response.sendRedirect("authentication/buyer_alter/buyer_changepwd_fail.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
