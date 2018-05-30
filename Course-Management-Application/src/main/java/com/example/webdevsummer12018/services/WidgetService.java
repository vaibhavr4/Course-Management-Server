package com.example.webdevsummer12018.services;
import com.example.webdevsummer12018.models.Widget;
import com.example.webdevsummer12018.repositories.WidgetRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*")
public class WidgetService {
	@Autowired
	WidgetRepository repository;
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets(){
		
		return (List<Widget>) repository.findAll();
		
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody List<Widget> widgets)
	{
		repository.deleteAll();
		for(Widget widget: widgets)
		{
			repository .save(widget);
		}
	}
	
	

}
