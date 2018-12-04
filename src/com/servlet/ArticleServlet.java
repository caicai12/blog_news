package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ArticleDao;
import com.dao.CommentDao;
import com.dao.GenreDao;
import com.model.Article;
import com.model.Comment;
import com.model.Genre;
import com.model.User;

public class ArticleServlet extends HttpServlet {

	private static final long serialVersionUID = -6030727340944647548L;

	/**
	 * Constructor of the object.
	 */
	public ArticleServlet() {
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
		ArticleDao aDao= new ArticleDao();
		User u= (User)req.getSession().getAttribute("user");
		if(type.equals("1")){//增加的方法
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String var2=req.getParameter("var2");
			String var3=req.getParameter("var3");
			String var4=req.getParameter("var4");
			var2=new String(var2.getBytes("ISO8859_1"),"UTF-8");
			var3=new String(var3.getBytes("ISO8859_1"),"UTF-8");
			var4=new String(var4.getBytes("ISO8859_1"),"UTF-8");
			aDao.save(String.valueOf(u.getId()), var2, var3, var4, sf.format(new Date()));
		}else if(type.equals("2")){//删除
			String id=req.getParameter("id");
			aDao.del(Integer.valueOf(id));
		}else if(type.equals("3")){//跳转添加页面
			GenreDao gDao=new GenreDao();
			List<Genre> list= gDao.findList();
			req.getSession().setAttribute("listGenre", list);
			resp.sendRedirect("article2.jsp");
			return;
		}else if(type.equals("4")){//查询我的文章
			List<Article> list = aDao.findList(u.getId());
			req.getSession().setAttribute("listArticle", list);
			resp.sendRedirect("article3.jsp");
			return;
		}else if(type.equals("5")){//查询文章对象
			String id=req.getParameter("id");
			Article a = aDao.find(Integer.valueOf(id));
			req.getSession().setAttribute("Article", a);
			
			CommentDao cDao= new CommentDao();
			List<Comment> list = cDao.findListgetaid(id);
			req.getSession().setAttribute("listComment", list);
			resp.sendRedirect("article.jsp");
			return;
		}
		List<Article> list = aDao.findList(null);
		req.getSession().setAttribute("listArticle", list);
		resp.sendRedirect("article1.jsp");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
