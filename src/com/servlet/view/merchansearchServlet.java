package com.servlet.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.view.MerchanView;
import com.vo.Merchandise;


@WebServlet("/merchansearchServlet")
public class merchansearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String words = request.getParameter("search");
		MerchanView mv = new MerchanView(); 
		ArrayList<Merchandise> am = mv.showSelectedMerchan(words);
		if(words.equals("")) {
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("value", words);
			session.setAttribute("am", am);
			response.sendRedirect("searchindex.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
