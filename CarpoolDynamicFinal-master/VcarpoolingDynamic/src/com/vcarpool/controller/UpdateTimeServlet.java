package com.vcarpool.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.services.CarServiceImpl;
/**
 * Servlet implementation class UpdateTimeServlet
 */
@WebServlet("/UpdateTimeServlet")
public class UpdateTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String time=request.getParameter("time");
		System.out.println(time);
		CarServiceImpl carService=new CarServiceImpl();
		boolean check=false;
		String regNum="TS13EM3836";
		
		try {
			check=carService.updateDeptTime(regNum, time);
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check)
			System.out.println("updated time ");
		else
			System.out.println("time not updated ");
	}

	}


