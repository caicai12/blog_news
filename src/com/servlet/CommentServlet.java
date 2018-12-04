package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommentDao;
import com.model.Comment;
import com.model.User;

public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = -6030727340944647548L;

	/**
	 * Constructor of the object.
	 */
	public CommentServlet() {
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
		CommentDao cDao= new CommentDao();
		User u= (User)req.getSession().getAttribute("user");
		if(type.equals("1")){//添加后返回页面
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String var1=req.getParameter("var1");
			String var2=req.getParameter("var2");
			String var3=req.getParameter("var3");
			cDao.save(var1, var2, var3, sf.format(new Date()));
			
			List<Comment> list = cDao.findListgetaid(var2);
			req.getSession().setAttribute("listComment", list);
			resp.sendRedirect("article.jsp");
			return;
		}else if(type.equals("2")){//删除
			String id=req.getParameter("id");
			cDao.del(Integer.valueOf(id));
		}
		List<Comment> list = cDao.findList(u.getId());
		req.getSession().setAttribute("listComment", list);
		resp.sendRedirect("comment1.jsp");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
