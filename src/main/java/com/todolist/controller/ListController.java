package com.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.JobList;
import com.todolist.service.ListService;



@RestController
public class ListController {
	
	@Autowired
	private ListService listservice;
	JobList joblist=new JobList();
	
	
	@RequestMapping(value="/add",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public void addJob(@RequestBody JobList job) {
		
		listservice.addJob(job);
		//System.out.println("post method in controller");
	}
	
	@RequestMapping(value="/getAllJobs",produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public  List<JobList> getAllJobs() {
		return listservice.getAllJobs();
			
		}
	
	@RequestMapping(value="/deleteJob/{id}",method=RequestMethod.DELETE)
	public void deleteJob(@PathVariable("id") int id) {
		listservice.deleteJob(id);
		
	}
	
	@RequestMapping(value="/editJob/{id}",method=RequestMethod.PUT)
	public void editJob(@PathVariable("id") int id,@RequestBody JobList job) {
		System.out.println(id+""+job.getId());
		if(job.getId()==id) {
			listservice.editJob(job);
		}
	//System.out.println("edit method in controller");
	}

}
