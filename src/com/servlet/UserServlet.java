package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -6030727340944647548L;

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		String type=req.getParameter("type");
		if(type==null){return;}
		String name= req.getParameter("name");
		String pwd= req.getParameter("pwd");
		String state= req.getParameter("state");
		String email= req.getParameter("email");
		UserDao uDao= new UserDao();
		if(type.equals("1")){
			User user= uDao.findUser(name, pwd,state);
			if(user!=null){
				req.getSession().setAttribute("user", user);
				
				List<User> list = uDao.findList();
				req.getSession().setAttribute("listuser", list);
				resp.sendRedirect("admin2.jsp");
			}else{
				resp.sendRedirect("main.jsp?msg=1");
			}
			return;
		}
		if(req.getSession().getAttribute("user")==null){
			resp.sendRedirect("main.jsp");return;
		}
		if(type.equals("2")){
			List<User> list = uDao.findList();
			req.getSession().setAttribute("listuser", list);
			resp.sendRedirect("admin2.jsp");
		}else if(type.equals("3")){
			if(name!=null && name.length()>0 && pwd!=null && pwd.length()>0){
				uDao.save(name, pwd,state,email);
				
				List<User> list = uDao.findList();
				req.getSession().setAttribute("listuser", list);
				resp.sendRedirect("admin2.jsp");
			}
		}else if(type.equals("4")){//
			req.getSession().removeAttribute("user");
			resp.sendRedirect("index.jsp");
		}else if(type.equals("5")){//
			String id= req.getParameter("id");
			uDao.del(Integer.valueOf(id));
			
			List<User> list = uDao.findList();
			req.getSession().setAttribute("listuser", list);
			resp.sendRedirect("admin2.jsp");
		}else if(type.equals("6")){//
			resp.sendRedirect("admin1.jsp");
		}else if(type.equals("7")){//
			String id= req.getParameter("id");
			User user =uDao.find(Integer.valueOf(id));
			req.getSession().setAttribute("userupdate", user);
			resp.sendRedirect("admin3.jsp");
		}else if(type.equals("8")){//
			String id= req.getParameter("id");
			uDao.update(Integer.valueOf(id), pwd);
			
			List<User> list = uDao.findList();
			req.getSession().setAttribute("listuser", list);
			resp.sendRedirect("admin2.jsp");
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
