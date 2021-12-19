package com.servlet.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.users.UserDao;
import com.dao.users.UserDaoImpl;
import com.util.authentication.UserAuthentic;
import com.util.authentication.UserAuthenticaUtil;
import com.util.util.Check;
import com.vo.UserAccount;


@WebServlet("/sellerpwdchangeServlet")
public class sellerpwdchangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String pwd = request.getParameter("selleroldpwd");
		String newpwd = request.getParameter("sellernewpwd");
		Check check = new Check();
		HttpSession session = request.getSession();
		UserAccount selleruser = (UserAccount)(session.getAttribute("selleruser"));
		String account = selleruser.getU_act();
		UserAuthenticaUtil userAuthentic = new UserAuthentic();
		UserAccount sAccount = new UserAccount(account, pwd);
			if(check.pwdiscorrect(newpwd)&&userAuthentic.changePwd(sAccount, newpwd)) {
				session.setAttribute("msg9", "true");
			}else {
				session.setAttribute("msg9", "false");
			}
			response.sendRedirect("authentication/seller_alter/sellerpwdchange.jsp");
	}			
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
