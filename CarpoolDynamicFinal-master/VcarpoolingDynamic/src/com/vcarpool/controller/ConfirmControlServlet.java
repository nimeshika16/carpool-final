	package com.vcarpool.controller;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Car;
import com.vcarpool.services.CarServiceImpl;


/**
 * Servlet implementation class ConfirmControlServlet
 */
@WebServlet("/ConfirmControlServlet")
public class ConfirmControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(ConfirmControlServlet.class);
	static CarServiceImpl carserv=new CarServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@ParameterNames
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String regNo=request.getParameter("bCarNo");
		System.out.println(regNo);
		int seats=Integer.parseInt(request.getParameter("bSeatsAvailable"));
		System.out.println("seats:\t"+seats);
		RequestDispatcher dispatcher=null;
		  
		try {
			boolean status=carserv.bookCar(regNo, seats);
			if(status) {
				dispatcher=request.getRequestDispatcher("bookingsuccess.jsp");
				
				dispatcher.forward(request, response);
				
			}
			else {
				out.println("<h1>seats unavailable failed</h1>");
			}
				
			
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			log.error("error",e);
			e.printStackTrace();
		}
		
		
				
		
	}

}
