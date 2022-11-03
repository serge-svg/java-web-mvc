package com.svg.java.jee.mvc.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.svg.java.jee.mvc.business.Course;
import com.svg.java.jee.mvc.services.CourseService;

@Path(value = "/courses")
public class RestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> listOfCourses() {
		CourseService courseService = new CourseService();
		return courseService.getAll();
	}

	@GET
	@Path("/filter/{name:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> findByName(@PathParam("name") String name) {
		CourseService courseService = new CourseService();
		return courseService.findByName(name);

	}

}
