package com.todoreactive.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@EnableWebFlux

public class TodoRouterconfig {
	
	@Autowired
	TodoHandler handler;

	@Bean
	public RouterFunction<ServerResponse> route(){
		return RouterFunctions.route(GET("/tasks"), handler :: getAllTasks)
				.and(RouterFunctions.route(GET("/tasks/{id}"),handler :: getTask))
				.and(RouterFunctions.route(POST("/tasks"), handler::addTask));
	}
}
