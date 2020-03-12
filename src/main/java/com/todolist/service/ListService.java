package com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todolist.JobList;
import com.todolist.repository.ListRepository;

@Service
public class ListService {

	@Autowired
	private ListRepository listrepository;
	
	public void addJob(JobList job) {
		listrepository.save(job);
	}
	public List<JobList> getAllJobs() {
		return listrepository.findAll();
	}
	
	public void deleteJob(int id) {
		listrepository.deleteById((long) id);
	}
	
	public void editJob(JobList job) {
		listrepository.save(job);
	}

}
