package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude={"students","courses","professors"})
@EqualsAndHashCode(exclude={"students","courses","professors"})
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "departmentName")
    String name;

    @JsonIgnore
    @OneToMany(mappedBy="department", fetch = FetchType.LAZY)
    List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy="department", fetch = FetchType.LAZY)
    List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy="department", fetch = FetchType.LAZY)
    List<Professor> professors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
}
