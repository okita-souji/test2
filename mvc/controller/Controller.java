package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proccess;
import model.Student;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Proccess pc = new Proccess();
		try {
			if("list".equals(action)){
				List<Student> stus = pc.list();
				request.setAttribute("stus", stus);
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}
			else if("add".equals(action)) {
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
			else if("edit".equals(action)) {
				String xh = request.getParameter("xh");
				Student student = pc.findByXH(xh);
				request.setAttribute("stu", student);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
				
			}
			else if("save".equals(action)) {
				String oldXh = request.getParameter("oldXh");
				String xh = request.getParameter("xh");
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				
				Student student = new Student();
				student.setXh(xh);
				student.setName(name);
				student.setSex(sex);
				pc.save(student, oldXh);
				response.sendRedirect("ctrl?action=list");
				
			}
			else if("delete".equals(action)) {
				String xh = request.getParameter("xh");
				pc.delete(xh);
				response.sendRedirect("ctrl?action=list");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errMsg", e.getMessage());
		    request.getRequestDispatcher("error.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
	}

}
