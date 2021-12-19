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
import com.util.util.Check;
import com.vo.UserAccount;

@WebServlet("/buyerpwdchangeServlet")
public class buyerpwdchangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String pwd = request.getParameter("buyeroldpwd");
		String newpwd = request.getParameter("buyernewpwd");
		Check check = new Check();
		HttpSession session = request.getSession();
		UserAccount buyer = (UserAccount)(session.getAttribute("buyeruser"));
		String account = buyer.getU_act();
		UserAuthenticaUtil bu = new UserAuthentic();
		UserAccount ba = new UserAccount(account, pwd);
			if(bu.changePwd(ba, newpwd)&&check.pwdiscorrect(newpwd)) {
				session.setAttribute("msg7", "true");	
			}else {
				session.setAttribute("msg7", "false");
			}
		response.sendRedirect("authentication/buyer_alter/buyer_changepwd.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
