package com.cdvtc.graduateemploy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_profile")
public class Profile {
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="gid")
	public Graduate getGraduate() {
		return graduate;
	}
	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Graduate graduate;
	private int id;
	private String explain;
	private String type;
}
