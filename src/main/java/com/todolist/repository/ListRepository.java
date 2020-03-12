package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.JobList;

@Repository
public interface ListRepository extends JpaRepository<JobList, Long>{

}
