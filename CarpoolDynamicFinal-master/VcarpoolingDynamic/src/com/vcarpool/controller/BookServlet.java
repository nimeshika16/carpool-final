package com.vcarpool.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vcarpool.model.Car;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(BookServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String carNo=request.getParameter("carno");
		String carName=request.getParameter("carname");
		String carSource=request.getParameter("carsource");
		String carDest=request.getParameter("cardest");
		String carTime=request.getParameter("cartime");
		String carSeats=request.getParameter("carseats");
		int seats=Integer.parseInt(carSeats);
		HttpSession session=request.getSession();
		Car car=new Car(carNo,carName,seats,carSource,carDest,carTime);
		session.setAttribute("bookCars", car);
		RequestDispatcher dispatcher=null;
		if(session.getAttribute("userid")==null) {
			try {

				dispatcher=request.getRequestDispatcher("login.jsp");

			} catch (NullPointerException e) {
				// TODO: handle exception
				log.error("error",e);
			}

		}
		else {
			dispatcher=request.getRequestDispatcher("booking.jsp");
		}

		dispatcher.forward(request, response);

	}

}
