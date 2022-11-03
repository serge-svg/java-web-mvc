package com.svg.java.jee.mvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.svg.java.jee.mvc.business.Course;

public class CourseService {

	private static List<Course> listOfCourses = new ArrayList<>();

	static {
		listOfCourses.add(new Course("Java", 1));
		listOfCourses.add(new Course("Java", 2));
		listOfCourses.add(new Course("JS", 1));
		listOfCourses.add(new Course("JS", 2));
	}
	
	public void add(Course course) {
		listOfCourses.add(course);
	}

	public void delete(Course courseToDelete) {
		listOfCourses.remove(courseToDelete);
	}

	public List<Course> getAll() {
		return listOfCourses;
	}
	
	public List<Course> findByName(String name) {
		
		return name.isEmpty() ? getAll() : getAll().stream()
				.filter(c -> c.getName().toUpperCase().startsWith(name.toUpperCase()))
				.collect(Collectors.toList());
				
	}

	public Optional<Course> findCourse(String name, int level) {
		
		return getAll().stream()
				.filter(c -> c.getName().equalsIgnoreCase(name.trim()) && c.getLevel()==level)
				.findFirst();
	}

}
