//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Feedback Management System
//  @ File Name : TrainingAdminServiceImpl.java
//  @ Date : 15-09-2017
//  @ Author : Vikas Chaudhary
//
//



package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dao.FMSDao;
import com.cg.fms.dao.FMSDaoImpl;
import com.cg.fms.dto.Course;
import com.cg.fms.dto.Employee;
import com.cg.fms.dto.FacultySkill;
import com.cg.fms.dto.Feedback;
import com.cg.fms.dto.TrainingProgram;
import com.cg.fms.exception.FeedbackSysException;


/** */
public class TrainingAdminServiceImpl implements TrainingAdminService {
	/** */
	
	private FMSDao fmsDao;
	
	public TrainingAdminServiceImpl() {
		super();
		fmsDao = new FMSDaoImpl(); 
	}
	
	public List<Feedback> getAllParticipantFeedback() {
		return null;
	}
	
	
	/** */
	public void getAllFeedbackDefaulterParticipant() {
	}
	
	/**
	 * @throws FeedbackSysException  */
	public List<FacultySkill> getAllFacultyList() throws FeedbackSysException {
		
		return fmsDao.getAllFacultyList();
	}
	
	/**
	 * @throws FeedbackSysException  */
	public List<Course> getAllCourseList() throws FeedbackSysException {
		return fmsDao.getAllCourseList();
	}
	
	/**
	 * @throws FeedbackSysException  */
	public boolean updateCourseWithId(Course course) throws FeedbackSysException {
		return fmsDao.updateCourseWithId(course);
	}
	
	/** */
	public List<Employee> getAllEmployeeList() {
		return null;
	}
	
	/**
	 * @throws FeedbackSysException  */
	public List<TrainingProgram> getAllTrainingProgramList() throws FeedbackSysException {
		return fmsDao.getAllTrainingProgramList();
	}
}
