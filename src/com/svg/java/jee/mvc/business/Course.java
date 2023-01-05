package com.svg.java.jee.mvc.business;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // To allow it to be used on rest services
public class Course {

	public Course() {
		super();
	}

	private String name;
	private int level;

	public Course(String name, int level) {
		super();
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(level, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return level == other.level && Objects.equals(name, other.name);
	}
	
}
