package com.servlet.management;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.management.MerchanManage;
import com.util.util.Check;
import com.vo.MPicture;
import com.vo.Merchandise;



@WebServlet("/releasegoodServlet")
public class releasegoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String goodname = null;
		String goodprice = null ;
		String goodnum = null ;
		String goodinf = null;
		String fileName = null;
		Check check = new Check();
		HttpSession session=request.getSession();	
		session.setAttribute("msg1", "false");
		//上传
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		try {
			if(isMultipart) {//判断前台的form是否有multipart的属性
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				ArrayList<MPicture> am = new ArrayList<MPicture>();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					//判断前台字段是普通form表单字段还是，文件字段
					if(item.isFormField()) {
						if(itemName.equals("goodname") && !item.getString().equals("")) {
							goodname = item.getString("utf-8");
						}else if(itemName.equals("goodprice") && !item.getString().equals("")){
								goodprice = item.getString("utf-8"); //Double.parseDouble(item.getString());
						}else if(itemName.equals("goodinf") && !item.getString().equals("")) {
							goodinf = item.getString("utf-8");
						}else if(itemName.equals("goodnum") && !item.getString().equals("")) {
							if(!item.getString().equals(""))
								goodnum = item.getString("utf-8"); //Integer.parseInt(item.getString());
						}
						}else {
							//文件上传
							//文件名 getFieldName是获取普通表单字段的Name值
							//getName（）获取 文件名
							fileName = (new File(item.getName())).getName();
							MPicture mp = new MPicture(fileName);	
							am.add(mp);
							//获取文件内容并上传
							//定义文件路径：指定上传的位置
							//String path = System.getProperty("user.dir").replace("bin", "webapps") + "wp/imgs";
							//System.out.println(path);
							String path = request.getSession().getServletContext().getRealPath("imgs");
							File file = new File(path,fileName);
							item.write(file);
				}
				}
				if(goodname == null || goodinf == null || !check.check_num(goodnum) || !check.check_price(goodprice)) {
					response.sendRedirect("management/seller_releasegood/releasegood.jsp");
					return;
				}
				else{		
			Double	goodprice1 = Double.parseDouble(goodprice);
			int goodnum1 = Integer.parseInt(goodnum);
			Merchandise m = new Merchandise(goodname,goodinf);   //商铺id，商品名称，商品信息
			MerchanManage mm = new MerchanManage();					   //获取商品信息，获取图片信息，但是图片只有p_ads属性，不知道后面会不会出错
			//ArrayList<MPicture> am = new ArrayList<MPicture>();
			//MPicture mp = new MPicture(fileName);				   //单单创建p_ads属性的mpicture
			//am.add(mp);
			mm.addMerchan(m, am, goodprice1, goodnum1);
			session.setAttribute("msg1", "true");
			response.sendRedirect("management/seller_releasegood/releasegood.jsp");}
		}
		}catch (FileUploadException e) {
			e.printStackTrace();
			response.sendRedirect("management/seller_releasegood/releasegood.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("management/seller_releasegood/releasegood.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
