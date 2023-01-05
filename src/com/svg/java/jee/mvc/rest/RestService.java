package com.svg.java.jee.mvc.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.svg.java.jee.mvc.business.Course;
import com.svg.java.jee.mvc.services.CourseService;

@ApplicationScoped // It Indicates that will be available the whole life cycle  
@Path(value = "/courses")
public class RestService {
	
	@Inject
	CourseService courseService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> listOfCourses() {
		System.out.println("----------->RestService:listOfCourses");
		return courseService.getAll();
	}

	@GET
	@Path("/filter/{name:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> findByName(@PathParam("name") String name) {
		System.out.println("----------->RestService:findByName: "+name);
		return courseService.findByName(name);

	}

}
