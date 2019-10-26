package com.vcarpool.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Car;
import com.vcarpool.services.CarServiceImpl;;
/**
 * Servlet implementation class FindCarServlet
 */
@WebServlet("/FindCarServlet")
public class FindCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(FindCarServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@ParameterNames
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		CarServiceImpl carsev=new CarServiceImpl();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String time = request.getParameter("time");
		String seats = request.getParameter("seats");
		Integer seat = Integer.parseInt(seats);
		HttpSession session= request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("time", time);
		session.setAttribute("seats", seat);
		RequestDispatcher dispatcher = null;
		try {
			ArrayList<Car> arr = carsev.showCars(source, destination, time, seat);
			session.setAttribute("resultArray", arr);
			if (arr.size() > 0) {
				log.info("cars returned: ");
				log.info(arr);
			}
			dispatcher = request.getRequestDispatcher("result.jsp");
			
		} catch (VCarpoolException e) {

			System.out.println(e.getMessage());
		}
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			log.error("error", e);
			System.out.println(e.getMessage());
		}

	}

}
