package com.coders.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coders.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	
}
