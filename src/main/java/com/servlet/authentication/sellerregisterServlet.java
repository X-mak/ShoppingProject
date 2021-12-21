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
import com.util.authentication.SellerAuthentic;
import com.util.authentication.SellerAuthenticUtil;
import com.vo.SellerInfo;
import com.vo.UserAccount;



@WebServlet("/sellerregisterServlet")
public class sellerregisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String s_acc = (String) request.getParameter("seller_acc");
		String s_pwd1 = (String) request.getParameter("seller_pwd1");
		String s_pwd2 = (String) request.getParameter("seller_pwd2");
		UserAccount sa = new UserAccount(s_acc,s_pwd1);
		UserDao ud = new UserDaoImpl();
		SellerAuthenticUtil sellerAuthentic = new SellerAuthentic();
		boolean flag = true;
		if(s_pwd1.equals(s_pwd2)) {
			flag = true;
		}else {
			flag = false;
		}
			if(flag) {//���������µĺ������жϸ��˺��Ƿ��Ѿ����ڣ�������ھͽ���else��֧
				try {
					if(ud.isValid(sa)) {
						SellerInfo si = new SellerInfo(s_acc, 1);
						sellerAuthentic.addSeller(sa, si);
						session.setAttribute("msg10", "true");
						response.sendRedirect("authentication/seller_register/seller_register.jsp");
					}
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}else {
				session.setAttribute("msg10", "false");
				response.sendRedirect("authentication/seller_register/seller_register.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
