package com.vcarpool.controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.mysql.cj.Session;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;
import com.vcarpool.services.UserServiceImpl;

/**
 * Servlet implementation class RegistrationControlServlet
 */
@WebServlet("/RegistrationControlServlet")
public class RegistrationControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Logger log= Logger.getLogger(RegistrationControlServlet.class);
	static UserServiceImpl usr=new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		User user=new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setType(request.getParameter("type"));
		RequestDispatcher dispatcher=null;
		log.info(user);
		Integer key=0;
		log.info("key is"+key);
		try {
			/*here key is userId
			 * */
			System.out.println("entered");
			key=usr.insert(user);
			System.out.println(key);
			String userid=key.toString();
			System.out.println(userid);
			if(key>0) {
				
				System.out.println("entered into key pass loop");
				if (user.getType().equals("provider")) {
					System.out.println("if provider");
					HttpSession Session=request.getSession();
					Session.setAttribute("userid", userid);
					System.out.println(userid);
					Session.setAttribute("username",user.getUserName());
					System.out.println(user);
					System.out.println("went to addcar.jsp");
					dispatcher=request.getRequestDispatcher("addcar.jsp");
					
				}
				else {
					HttpSession Session=request.getSession();
					Session.setAttribute("userid", userid);
					dispatcher=request.getRequestDispatcher("registersuccess.jsp");
					
				}
			}
			
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			log.error("reg-error",e);
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

}
