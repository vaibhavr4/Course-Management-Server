package com.example.webdevsummer12018.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Module module;
	
//	@OneToMany(mappedBy="lesson")
//	@JsonIgnore
//	private List<Topic> topic;
	
	@OneToMany(mappedBy="lesson")
	@JsonIgnore
	private List<ExamWidget> examWidget;

	public List<ExamWidget> getExamWidget() {
		return examWidget;
	}

	public void setExamWidget(List<ExamWidget> examWidget) {
		this.examWidget = examWidget;
	}

//	public List<Topic> getTopic() {
//		return topic;
//	}
//
//	public void setTopic(List<Topic> topic) {
//		this.topic = topic;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}