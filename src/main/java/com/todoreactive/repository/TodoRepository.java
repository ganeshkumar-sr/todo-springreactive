package com.todoreactive.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.todoreactive.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class TodoRepository {
	
	private static final Map<Long, Task> TASK_DATA;
	
	static {
		TASK_DATA = new HashMap<>();
		TASK_DATA.put(1L,new Task(1L,"Go to school", "Pick up", false));
		TASK_DATA.put(2L,new Task(2L,"Go to shop", "Buy Grocessories", false));
	}
	
	public Mono<Task> getTaskById(Long id){
		return Mono.just(TASK_DATA.get(id));
	}
	
	public Flux<Task> getAllTasks(){
		return Flux.fromIterable(TASK_DATA.values());
	}
	
	public Mono<Task> addTask(Task task) {
		TASK_DATA.put(task.getId(), task);
		return Mono.just(task);
	}
}
