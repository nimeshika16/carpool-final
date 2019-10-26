package com.vcarpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.vcarpool.model.Car;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.services.CarServiceImpl;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServ")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
     
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @ParameterNames
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		com.vcarpool.model.Car car=new com.vcarpool.model.Car();
		car.setRegNo(request.getParameter("regno"));
		car.setCarName(request.getParameter("carname"));
		String number=request.getParameter("seat");
		int num=Integer.parseInt(number);
		car.setSeatsAvailable(num);
		car.setSource(request.getParameter("source"));
		car.setDestination(request.getParameter("destination"));
		car.setDeptTime(request.getParameter("time"));
		CarServiceImpl c= new CarServiceImpl();
		HttpSession session= request.getSession();
		Integer check= Integer.parseInt((String) session.getAttribute("userid"));
		boolean checking=false;
		RequestDispatcher dispatcher=null;
		try {
			checking=c.addCar(car, check);
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checking) {
			session.setAttribute("userId", check);
			dispatcher=request.getRequestDispatcher("registerSuccess.jsp");
			
		}
		else {
			out.println("car not added !");
		}
		dispatcher.forward(request, response);
	}

}
