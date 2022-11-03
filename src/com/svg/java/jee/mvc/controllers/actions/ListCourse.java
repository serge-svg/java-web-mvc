package com.svg.java.jee.mvc.controllers.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svg.java.jee.mvc.services.CourseService;

public class ListCourse implements Action {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService courseService = new CourseService();	
		request.setAttribute("listOfCourses", courseService.getAll());		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/courses.jsp");
		dispatcher.forward(request, response);		
	}

}
