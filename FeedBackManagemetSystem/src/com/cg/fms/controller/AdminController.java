package com.cg.fms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.fms.dto.Course;
import com.cg.fms.dto.FacultySkill;
import com.cg.fms.dto.TrainingProgram;
import com.cg.fms.exception.FeedbackSysException;
import com.cg.fms.service.TrainingAdminService;
import com.cg.fms.service.TrainingAdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TrainingAdminService adminService = null;
	private ArrayList<FacultySkill> facultyArrayList = null;
	private ArrayList<Course> courseArrayList = null;
	
	private ArrayList<String> facultiesNameList = null;
	private HashMap<Integer,String> facultiesMap = null;
	
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

			if(courseArrayList == null){
				
			// contains names of all faculties	
			facultiesNameList = new ArrayList<String>();
			
			// contains employee id and name of all faculties
			facultiesMap = new HashMap<Integer,String>();
			
			
				try {
					
					setUpFacultyMaintancePage();
					
				
					
					request.setAttribute("facultiesMap", facultiesMap);
					request.setAttribute("facultyList", facultyArrayList);
					request.setAttribute("courseArrayList", courseArrayList);
					request.setAttribute("facultiesNameList", facultiesNameList);
					
					request.setAttribute("pageHeading","Faculty Maintenance Page");
					request.getSession().setAttribute("role", "admin");
					
					view = getServletContext().getRequestDispatcher(
							"/pages/facultyMaintenance.jsp");
					view.forward(request, response);
					
					
				} catch (FeedbackSysException e) {
					
					forwardToErrorPage(request,response,e.getMessage());

				}
						
			}
			
			
			
			break;
			
		case "trainingMaintenancePage":
			
			try {
				
				
				List<TrainingProgram> trainingProgramList = adminService.getAllTrainingProgramList();
					getFacultyNames();
				
				request.setAttribute("trainingPrograms",trainingProgramList);
				request.setAttribute("pageHeading","Faculty Maintenance Page");
				request.setAttribute("facultiesNameList", facultiesNameList);
				request.getSession().setAttribute("role", "admin");
				
				view = getServletContext().getRequestDispatcher(
						"/pages/trainingMaintenance.jsp");
				view.forward(request, response);
				
			} catch (FeedbackSysException e) {
				
				forwardToErrorPage(request,response,e.getMessage());
			}
			
			
			break;
		
		case "feedbackReportPage":
			// Dispatch to Feedback Report Page
			break;
		
		default:
			forwardToErrorPage(request,response,"default case");
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
			
			int courseTableIndex = Integer.parseInt(request.getParameter("courseCounterNo"));
			String facultyNameToAdd = request.getParameter("ddfacultyNameList"+courseTableIndex);
			
			try {
			
				if(request.getParameter("btAssignFaculty"+courseTableIndex) != null){
				
					assignFacultyToCourse(facultyNameToAdd,courseTableIndex);
				
				}else{
					
					reomveFacultyFromCourse(facultyNameToAdd,courseTableIndex,request);
				}
				
				
				request.setAttribute("facultyList", facultyArrayList);
				request.setAttribute("courseArrayList", courseArrayList);
				request.setAttribute("facultiesNameList", facultiesNameList);
				
			
				request.setAttribute("pageHeading","Faculty Maintenance Page");
				view = getServletContext().getRequestDispatcher(
						"/pages/facultyMaintenance.jsp");
				
				view.forward(request, response);
			
			} catch (FeedbackSysException e) {
				forwardToErrorPage(request,response,e.getMessage());
			}
			
			
			break;
		
		default:
			forwardToErrorPage(request,response,"default case");
			break;
		}
	}

	private void reomveFacultyFromCourse(String facultyNameToAdd,
			int jspTableIndex, HttpServletRequest request) throws FeedbackSysException {
		
		List<String> assignedFacultylist = courseArrayList.get(jspTableIndex).getFacultyNames();
		
		List<Integer> assignedFacltyIdsList = courseArrayList.get(jspTableIndex).getFaculty();
		
		for(int i=0;i< assignedFacultylist.size() ;i++){
			
			String name = request.getParameter("btRemoveFaculty"+jspTableIndex +i);
			
			if(name != null){
				assignedFacultylist.remove(i);
				assignedFacltyIdsList.remove(i);
			}
		}
		
		courseArrayList.get(jspTableIndex).setFacultyNames(assignedFacultylist);
		courseArrayList.get(jspTableIndex).setFaculty(assignedFacltyIdsList);
		adminService.updateCourseWithId(courseArrayList.get(jspTableIndex));
		
	}

	private void assignFacultyToCourse(String facultyNameToAdd, int jspTableIndex) throws FeedbackSysException {
		
		List<String> assignedFacultylist = courseArrayList.get(jspTableIndex).getFacultyNames();
		
		List<Integer> assignedFacltyIdsList = courseArrayList.get(jspTableIndex).getFaculty();
		
		
		if(!assignedFacultylist.contains(facultyNameToAdd)){
			
			assignedFacultylist.add(facultyNameToAdd);
			
			
			
			Set<Integer> keys = facultiesMap.keySet();
			
			for(int id : keys){
				
				if(facultiesMap.get(id).equals(facultyNameToAdd))
				{
					assignedFacltyIdsList.add(id);
					System.out.println("doing : " + id + " : " + facultiesMap.get(id));
				}
				
			}
				
		}
		
		
		courseArrayList.get(jspTableIndex).setFacultyNames(assignedFacultylist);
		courseArrayList.get(jspTableIndex).setFaculty(assignedFacltyIdsList);
			
		adminService.updateCourseWithId(courseArrayList.get(jspTableIndex));
		
		
	}
	
	private void forwardToErrorPage(HttpServletRequest request,
			HttpServletResponse response, String message) throws ServletException, IOException {
		
		request.setAttribute("errMsg", message);
		 getServletContext().getRequestDispatcher(
				"/pages/error.jsp").forward(request, response);
		
	}

	
	
	private void setUpFacultyMaintancePage() throws FeedbackSysException {
		
		facultyArrayList = (ArrayList<FacultySkill>) adminService.getAllFacultyList();
		
		courseArrayList = (ArrayList<Course>) adminService.getAllCourseList();
		
		for(FacultySkill fs : facultyArrayList){
			facultiesNameList.add(fs.getName());
			facultiesMap.put(fs.getId(),fs.getName());
		}
		
		
		for(Course course : courseArrayList){
			
			for(int i=0;i<course.getFaculty().size();i++){
				
				course.getFacultyNames().add(facultiesMap.get(course.getFaculty().get(i)));
				
			}
			
		}
		
	}
	
	private void getFacultyNames() throws FeedbackSysException{
		
		facultiesNameList = new ArrayList<String>();
		
		facultyArrayList = (ArrayList<FacultySkill>) adminService.getAllFacultyList();
		
		for(FacultySkill fs : facultyArrayList){
			facultiesNameList.add(fs.getName());
			//facultiesMap.put(fs.getId(),fs.getName());
		}
		
	}
	
	
}
