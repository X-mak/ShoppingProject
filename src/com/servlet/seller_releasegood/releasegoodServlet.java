package com.servlet.seller_releasegood;

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

import com.util.merchan.MerchandiseUI;
import com.util.merchan.MerchandiseUtil;
import com.util.seller.SellerUI;
import com.util.seller.SellerUtil;
import com.vo.MPicture;
import com.vo.Merchandise;



@WebServlet("/releasegoodServlet")
public class releasegoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String goodname = null;
		int goodprice = 0 ;
		int goodnum = 0 ;
		String goodgenre = request.getParameter("selectName");
		String goodinf = null;
		String fileName = null;
		HttpSession session=request.getSession();	
		//上传
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		try {
			if(isMultipart) {//判断前台的form是否有multipart的属性
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					//判断前台字段是普通form表单字段还是，文件字段
					if(item.isFormField()) {
						if(itemName.equals("goodname")) {
							goodname = item.getString("utf-8");
						}else if(itemName.equals("goodprice")){
							goodprice = Integer.parseInt(item.getString());
						}else if(itemName.equals("goodinf")) {
							goodinf = item.getString("utf-8");
						}else if(itemName.equals("goodnum")) {
							goodnum = Integer.parseInt(item.getString());
						}
						}else {//文件上传
							//文件名 getFieldName是获取普通表单字段的Name值
							//getName（）获取 文件名
							fileName = (new File(item.getName())).getName();
							//获取文件内容并上传
							//定义文件路径：指定上传的位置
							//String path = System.getProperty("user.dir").replace("bin", "webapps") + "wp/imgs";
							//System.out.println(path);
							String path = request.getSession().getServletContext().getRealPath("imgs");
							File file = new File(path,fileName);
							item.write(file);
				}
				}
				if(goodname.equals("")||goodinf.equals("")||goodprice<=0||goodnum<=0) {
					response.sendRedirect("management/seller_releasegood/releasegood_fail.jsp");
				}
				else{											   //********需要重写
			Merchandise m = new Merchandise(1,goodname,goodinf);   //商铺id，商品名称，商品信息
			SellerUtil su = new SellerUI();						   //获取商品信息，获取图片信息，但是图片只有p_ads属性，不知道后面会不会出错
			ArrayList<MPicture> am = new ArrayList<MPicture>();
			MPicture mp = new MPicture(fileName);				   //单单创建p_ads属性的mpicture
			am.add(mp);
			su.addMerchan(m, am, goodprice, goodnum, goodgenre);
			response.sendRedirect("management/seller_releasegood/releasegood_success.jsp");}
		}
		}catch (FileUploadException e) {
			e.printStackTrace();
			response.sendRedirect("management/seller_releasegood/releasegood_fail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("management/seller_releasegood/releasegood_fail.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
