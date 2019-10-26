package com.vcarpool.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.services.CarServiceImpl;
import com.vcarpool.services.UserServiceImpl;;

/**
 * Servlet implementation class UpdateSourceDestinationServlet
 */
@WebServlet("/UpdateSourceDestinationServlet")
public class UpdateSourceDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSourceDestinationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		CarServiceImpl carservice=new CarServiceImpl();
		String check="TS13EM3836";
		boolean checking=false;
		try {
			checking=carservice.updateSrcDest(check, source, destination);
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (checking) {

			out.println("Updated");

		} else {
			out.println("Not Updated");
		}
	}

}
