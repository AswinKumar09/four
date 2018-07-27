package com.ibm.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.DepartmentDAO;
import com.ibm.model.Department;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//get the location id from the form
		 
		int locid=Integer.parseInt(request.getParameter("loc"));
		
		//aget the list of department by  using dao
		
		DepartmentDAO dao=new DepartmentDAO();
		ArrayList<Department> depts=dao.getDeptbyLoc(locid);
		
		
		//Add the list AS A REQUEST attribute
		
		request.setAttribute("depts", depts);
		
		
		RequestDispatcher disp=request.getRequestDispatcher("DepartmentList2.jsp");
		disp.forward(request, response);
	
	}

}
