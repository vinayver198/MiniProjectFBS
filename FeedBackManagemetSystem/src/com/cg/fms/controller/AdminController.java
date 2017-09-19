package com.cg.fms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fms.dto.Course;
import com.cg.fms.dto.FacultySkill;
import com.cg.fms.exception.FeedbackSysException;
import com.cg.fms.service.TrainingAdminService;
import com.cg.fms.service.TrainingAdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TrainingAdminService adminService;
	private ArrayList<FacultySkill> facultyArrayList = null;
	private ArrayList<Course> courseArrayList = null;
	
	private ArrayList<String> facultiesNameList = null;
	private HashMap<String,Integer> facultiesMap = null;
	
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

			if(facultyArrayList == null && courseArrayList == null){
				
			facultiesNameList = new ArrayList<String>();
			facultiesMap = new HashMap<String,Integer>();
				try {
				
					facultyArrayList = (ArrayList<FacultySkill>) adminService.getAllFacultyList();
				
					courseArrayList = (ArrayList<Course>) adminService.getAllCourseList();
				
					for(FacultySkill fs : facultyArrayList){
						facultiesNameList.add(fs.getName());
						facultiesMap.put(fs.getName(),fs.getId());
					}
				
				} catch (FeedbackSysException e) {
					e.printStackTrace();
				}
						
			}
			
			request.setAttribute("facultiesMap", facultiesMap);
			request.setAttribute("facultyList", facultyArrayList);
			request.setAttribute("courseArrayList", courseArrayList);
			request.setAttribute("facultiesNameList", facultiesNameList);
			
			request.getSession().setAttribute("role", "admin");
			view = getServletContext().getRequestDispatcher(
					"/pages/facultyMaintenance.jsp");
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
		
		case "AssignFaculty":
			// assign faculty to course
			
			String jspTableIndex = request.getParameter("courseCounterNo");
			String facultyNameToAdd = request.getParameter("ddfacultyNameList"+jspTableIndex);
			
			List<String> assignedFacultylist = courseArrayList.get(
													Integer.parseInt(jspTableIndex)).getFacultyNames();
			
			List<Integer> assignedFacltyIdsList = courseArrayList.get(
							Integer.parseInt(jspTableIndex)).getFaculty();
			
			if(request.getParameter("btAssignFaculty"+jspTableIndex) != null){
				
				if(!assignedFacultylist.contains(facultyNameToAdd)){
					assignedFacultylist.add(facultyNameToAdd);
					assignedFacltyIdsList.add(facultiesMap.get(facultyNameToAdd));
				}
				
			}else{
				
				for(int i=0;i< assignedFacultylist.size() ;i++){
					String name = request.getParameter("btRemoveFaculty"+Integer.parseInt(jspTableIndex)+i);
					
					if(name != null){
						assignedFacultylist.remove(i);
						assignedFacltyIdsList.remove(i);
					}
				}
				
			}
			
			
			courseArrayList.get(Integer.parseInt(jspTableIndex)).setFacultyNames(assignedFacultylist);
			courseArrayList.get(Integer.parseInt(jspTableIndex)).setFaculty(assignedFacltyIdsList);
			
			request.setAttribute("facultyList", facultyArrayList);
			request.setAttribute("courseArrayList", courseArrayList);
			request.setAttribute("facultiesNameList", facultiesNameList);
			
			view = getServletContext().getRequestDispatcher(
					"/pages/facultyMaintenance.jsp");
			
			view.forward(request, response);
			
			break;
		
		default:
			// Dispatch to error page
			break;
		}
	}

}
