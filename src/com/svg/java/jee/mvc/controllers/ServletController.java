package com.svg.java.jee.mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svg.java.jee.mvc.controllers.actions.Action;
import com.svg.java.jee.mvc.controllers.actions.DeleteCourse;
import com.svg.java.jee.mvc.controllers.actions.FilterCourse;
import com.svg.java.jee.mvc.controllers.actions.FormCourse;
import com.svg.java.jee.mvc.controllers.actions.InsertCourse;
import com.svg.java.jee.mvc.controllers.actions.ListCourse;


@WebServlet("/ServletController/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action myAction = null; 		
		
		String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		switch (action) {
			case "add":
				myAction = new InsertCourse();			
				break;
			case "insert":
				myAction = new FormCourse();
				break;
			case "delete":
				myAction = new DeleteCourse();
				break;
			case "filter":
				myAction = new FilterCourse();
				break;			
			default:
				myAction = new ListCourse();
		}
		
		myAction.ejecutar(request, response);
	}

}
