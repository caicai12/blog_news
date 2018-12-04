package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GenreDao;
import com.model.Genre;

public class GenreServlet extends HttpServlet {

	private static final long serialVersionUID = -6030727340944647548L;

	/**
	 * Constructor of the object.
	 */
	public GenreServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getSession().getAttribute("user")==null){
			resp.sendRedirect("main.jsp");return;
		}
		String type=req.getParameter("type");
		if(type==null){return;}
		GenreDao gDao= new GenreDao();
		if(type.equals("1")){//添加
			String var1=req.getParameter("var1");
			var1=new String(var1.getBytes("ISO8859_1"),"UTF-8");
			gDao.save(var1);
		}else if(type.equals("2")){//删除
			String id=req.getParameter("id");
			gDao.del(Integer.valueOf(id));
		}else if(type.equals("3")){//跳转添加页面
			resp.sendRedirect("genre2.jsp");
			return;
		}
		List<Genre> list = gDao.findList();
		req.getSession().setAttribute("listGenre", list);
		resp.sendRedirect("genre1.jsp");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
