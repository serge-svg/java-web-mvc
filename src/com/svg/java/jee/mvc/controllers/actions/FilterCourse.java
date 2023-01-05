package com.svg.java.jee.mvc.controllers.actions;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svg.java.jee.mvc.services.CourseService;

@Named
public class FilterCourse implements Action {

	@Inject
	CourseService courseService;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listOfCourses", courseService.findByName(request.getParameter("filterName").trim()));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/courses.jsp");
		dispatcher.forward(request, response);

	}

}
