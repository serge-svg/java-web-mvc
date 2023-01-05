package com.svg.java.jee.mvc.controllers.actions;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
public class FormCourse implements Action {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		RequestDispatcher despachador = request.getRequestDispatcher("/courseForm.jsp");
		despachador.forward(request, response);

	}

}
