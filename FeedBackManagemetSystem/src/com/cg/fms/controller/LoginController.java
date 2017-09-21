package com.cg.fms.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static RequestDispatcher view = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doPost(request, response);
		
		String action = request.getParameter("action");
		
		switch(action){
		
		case "home":
			
			break;
		case "back":
			
			break;
		case "logout":
			
			break;
		default:
			
			break;
				
		
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		System.out.println("action : " + action );
		
		// Get the current session object, create one if necessary
	    HttpSession session = request.getSession(true);
		
		
		switch(action){
		
			case "login":
				view = getServletContext().getRequestDispatcher(
						"/pages/login.jsp");
				view.forward(request, response);
				break;
				
			case "doLogin":
				
				String userName = request.getParameter("userName");
				String password = request.getParameter("passowrd");
				System.out.println(userName + " : " + password);
				
				
				session.setAttribute("userName", userName);
				
				dispatchToUserHome(AuthFactory.Authenticate(userName, password),request,response);
				break;
			
			default:
				view = getServletContext().getRequestDispatcher(
						"/pages/error.jsp");
				view.forward(request, response);
				break;
		}
		
		
		
	}
	
	
	
	private void dispatchToUserHome(AuthFactory.Role authenticate, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		switch(authenticate){
			case ADMIN:
				request.getSession().setAttribute("role", "admin");
				view = getServletContext().getRequestDispatcher(
						"/pages/AdminHomepage.jsp");
				view.forward(request, response);
				break;
			case COORDINATOR:
				request.getSession().setAttribute("role", "coordinator");
				view = getServletContext().getRequestDispatcher(
						"/pages/coordinatorHomePage.jsp");
				view.forward(request, response);
				break;
			case PARTICIPANT:
				request.getSession().setAttribute("role", "participant");
				view = getServletContext().getRequestDispatcher(
						"/pages/participantHomePage.jsp");
				view.forward(request, response);
				break;
			case INVALID:
				request.getSession().setAttribute("role", "invalid");
				System.out.println("user not present");
				request.setAttribute("userName", request.getParameter("userName"));
				request.setAttribute("passowrd",request.getParameter("passowrd"));
				
				request.setAttribute("loginStatus",
						"Employee UserName and Password Does Not Match");
				view = getServletContext().getRequestDispatcher(
						"/pages/login.jsp");
				view.forward(request, response);
				break;
			default:
				break;
		}
		
		
	}

	private static class AuthFactory{
		
		enum Role{ ADMIN,COORDINATOR,PARTICIPANT,INVALID}
		
		private static Role Authenticate(String userName, String password){
			return Role.ADMIN;
		}
		
		private static void logout(HttpSession session){
			
			if(session != null){
				
				session.invalidate();
				session = null;
			}
		}
		
		private static void forwardHome(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			HttpSession session = request.getSession(false);
			
			if(session == null)
				return;
			
			String role = (String) session.getAttribute("role");
			
			if(role.equals("admin")){
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
			else if(role.equals("coordinator")){
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
			else if(role.equals("participant")){
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}else{
				request.setAttribute("errMsg", "Role Conflict");
				request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			}
				
				
		}
		
		private static void goBack(){
			// to do write logic
		}
	}

}
