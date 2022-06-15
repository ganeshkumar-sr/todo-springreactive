package com.todoreactive.reactive;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.todoreactive.model.Task;
import com.todoreactive.repository.TodoRepository;

import reactor.core.publisher.Mono;

@Component
public class TodoHandler {

	@Autowired
	TodoRepository todoRepository ;
	
	
	public Mono<ServerResponse> getAllTasks(ServerRequest serverRequest){
		return ServerResponse.ok().body(todoRepository.getAllTasks(),Task.class);
	}
	
	public Mono<ServerResponse> getTask(ServerRequest serverRequest){
		return ServerResponse.ok().body(todoRepository.getTaskById(Long.valueOf(serverRequest.pathVariable("id"))),Task.class);
	}
	
	public Mono<ServerResponse> addTask(ServerRequest serverRequest) {
		return serverRequest.bodyToMono(Task.class)
				.flatMap(task -> todoRepository.addTask(task))
				.flatMap(newTask -> ServerResponse.created(URI.create("/tasks/"+newTask.getId()))
						.build());
	}
	
}
