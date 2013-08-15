package com.cdvtc.graduateemploy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_job")
public class Job {
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@ManyToMany(mappedBy="jobs", cascade=CascadeType.ALL)
	public Set<Graduate> getGraduates() {
		return graduates;
	}
	public void setGraduates(Set<Graduate> graduates) {
		this.graduates = graduates;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="eid")
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getWorkExper() {
		return workExper;
	}
	public void setWorkExper(String workExper) {
		this.workExper = workExper;
	}
	public String getEmployMode() {
		return employMode;
	}
	public void setEmployMode(String employMode) {
		this.employMode = employMode;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	private Set<Graduate> graduates = new HashSet<Graduate>();
	private Enterprise enterprise;
	private int id;
	private String name;
	private String age;
	private String sex;
	private int count;
	private String background;
	private String workExper;
	private String employMode;
	private String salary;
	private String workAddress;
	private Date publishDate;
	private Date endDate;
	private String require;
	
}
