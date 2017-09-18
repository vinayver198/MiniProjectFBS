package com.cg.fms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fms.dto.Course;
import com.cg.fms.dto.FacultySkill;
import com.cg.fms.service.TrainingAdminService;
import com.cg.fms.service.TrainingAdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TrainingAdminService adminService;
	
    /**
     * Default constructor. 
     */
    public AdminController() {
    	adminService = new TrainingAdminServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		String action = request.getParameter("action");
		System.out.println("action : " + action );
		
		
		switch(action){
		
		case "facultyMaintancePage":
			// get all faculty and course list from table
			// display the list in jsp page
			// display dynamic drop down
			// Dispatch to Faculty Maintance Page
			
			String[] skills = {"java","c#","android","angularJs"};
			
			ArrayList<FacultySkill> facultyArrayList = new ArrayList<FacultySkill>();
			
			for(int i=0;i<10;i++){
				facultyArrayList.add(new FacultySkill((i+1),skills,"faculty" + (i+1)));
			}
			
			request.setAttribute("facultyList", facultyArrayList);
			
			
			int[] faculties = {1,2,3,4};
			String[] facultiesNameList = {"vikas","vinay","karan","vegeta","itachi"};
			ArrayList<Course> courseArrayList = new ArrayList<Course>();
			
			for(int i=0;i<10;i++){
				courseArrayList.add(new Course((i+1),"Course",5,faculties));
			}
			
			request.setAttribute("courseArrayList", courseArrayList);
			request.setAttribute("facultiesNameList", facultiesNameList);
			
			request.getSession().setAttribute("role", "admin");
			view = getServletContext().getRequestDispatcher(
					"/pages/facultyMaintance.jsp");
			view.forward(request, response);
			
			break;
			
		case "trainingMaintancePage":
			// Dispatch to Training Maintance Page
			break;
		
		case "feedbackReportPage":
			// Dispatch to Feedback Report Page
			break;
		
		default:
			// Dispatch to error page
			break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		String action = request.getParameter("action");
		System.out.println("action : " + action );
		
		switch(action){
		
		case "mapfaculty":
			// update table
			break;
			
		case "Updatetraining":
			// update table
			break;
		
		case "generatefeedback":
			// update table
			break;
		
		default:
			// Dispatch to error page
			break;
		}
	}

}
