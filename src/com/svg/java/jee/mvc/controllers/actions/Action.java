package com.svg.java.jee.mvc.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}