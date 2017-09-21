package com.cg.mb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mb.bean.MovieBean;
import com.cg.mb.exception.MovieException;
import com.cg.mb.service.MovieService;
import com.cg.mb.service.MovieServiceImpl;


@WebServlet("*.obj")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Process() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieBean bean = null;
		MovieService service = null;
		String target="";
		List<MovieBean> list = new ArrayList<MovieBean>();
		
		HttpSession session = request.getSession(true);
		
		bean= new MovieBean();
		service = new MovieServiceImpl();
		
		String targetSuccess = "Success.jsp";
		String targetShow = "MovieDetails.jsp";
		String targetError = "error.jsp";
		String targetHome = "index.jsp";
		
		String path = request.getServletPath().trim();
		System.out.println(path);
		
		switch (path) {
		
		
			
		case "/validate.obj":
			
			
			String movie = request.getParameter("movie");
			String city  = request.getParameter("city");
			boolean result= false;
			System.out.println(city);
			
			try {
				result = service.validateMovie(city, movie);
				System.out.println(result);
			} catch (MovieException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result==true)
			{
				try {
					list = service.showMovieList(city, movie);
					System.out.println(list);
				} catch (MovieException e) {
					
					e.printStackTrace();
				}
				session.setAttribute("error", null);
				session.setAttribute("city", city);
				session.setAttribute("movie", movie);
				session.setAttribute("movielist", list);
				target = targetShow;

			}
			else
			{
				session.setAttribute("city", null);
				session.setAttribute("movie", null);
				session.setAttribute("movielist", null);
				session.setAttribute("error",
						"Sorry No data Found given city name and movie name");
				target = targetError;
			}
		
			break;
			
		case "/check.obj":
			
			boolean res=false;
			String status= request.getParameter("status");
			String id = request.getParameter("id");
			System.out.println(id);
			if(status.equals("NotAvailable"))
			{
				
				session.setAttribute("error",
						"Sorry seats are filled");
				target =targetError;
				
				
			}
			else
			{
				
					try {
						res=service.update(id);
						session.setAttribute("error", null);
						session.setAttribute("id", id);
						target =targetSuccess;
					} catch (MovieException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			break;
			
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.include(request, response);
		
	}

}
