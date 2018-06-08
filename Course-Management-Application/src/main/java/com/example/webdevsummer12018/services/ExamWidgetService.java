package com.example.webdevsummer12018.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer12018.models.Lesson;
import com.example.webdevsummer12018.models.ExamWidget;
import com.example.webdevsummer12018.repositories.LessonRepository;
import com.example.webdevsummer12018.repositories.ExamWidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class ExamWidgetService {
	@Autowired
	ExamWidgetRepository repository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/lesson/{lessonId}/examwidget")
	public List<ExamWidget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
		if(optionalLesson.isPresent()) {
			Lesson lesson = optionalLesson.get();
			return lesson.getExamWidget();
			
		}
		return null;
	}
	
	@PostMapping("/api/examwidget/save")
	public void saveAllWidgets(@RequestBody
			List<ExamWidget> widgets) {
		repository.deleteAll();
		for(ExamWidget widget: widgets) {
			repository.save(widget);
		}
	}
	
	@GetMapping("/api/examwidget")
	public List<ExamWidget> findAllWidgets() {
		return (List<ExamWidget>) repository.findAll();
	}
}