package com.svg.java.jee.mvc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;

import com.svg.java.jee.mvc.business.Course;

@Named
public class CourseService {

	@Resource(name="jdbc/courseWebMVC")
	private DataSource ds;
   
	public void add(Course course) {
		String sql = "INSERT INTO courses (name, level) VALUES (?, ?)";

		try(Connection connection = ds.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, course.getName());
			statement.setInt(2, course.getLevel());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Error SQL", e);
		}
	}

	public void delete(Course course) {
		String sql = "DELETE FROM courses WHERE name = ?  AND level = ? ";
		try(Connection connection = ds.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, course.getName());
			statement.setInt(2, course.getLevel());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Error SQL", e);
		}	
	}

	public List<Course> getAll() {
		System.out.println("----------->CourseService:getAll: ");
		List<Course> courses = new ArrayList<>(); 
		String sql = "SELECT * FROM courses";
		try(Connection connection = ds.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				courses.add(new Course(rs.getString("name"), rs.getInt("level")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error SQL", e);
		}	
		return courses;
	}
	
	
	public List<Course> findByName(String name) {
		System.out.println("----------->CourseService:findByName: "+name);
		List<Course> courses = new ArrayList<>(); 
		String sql = "SELECT * FROM courses WHERE UPPER(name) LIKE ?";
		try(Connection connection = ds.getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, "%"+ name.toUpperCase() +"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				courses.add(new Course(rs.getString("name"), rs.getInt("level")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error SQL", e);
		}	
		return courses;
	}

	public Optional<Course> findCourse(String name, int level) {
		return getAll().stream()
				.filter(c -> c.getName().equalsIgnoreCase(name.trim()) && c.getLevel()==level)
				.findFirst();
	}

}
