package com.svg.java.jee.mvc.controllers.actions;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svg.java.jee.mvc.business.Course;
import com.svg.java.jee.mvc.services.CourseService;

@Named
public class DeleteCourse implements Action {

	@Inject
	CourseService courseService; 
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course course = new Course(request.getParameter("name"), Integer.parseInt(request.getParameter("level")));
		courseService.delete(course);
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("courses");
		dispatcher.forward(request, response);
		*/
		response.sendRedirect("courses");
	}

}
