package com.todoreactive.model;

public class Task {

	private Long id;
	
	private String name;
	
	private String description;
	
	public Task(Long id, String name, String description, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
