package org.uvsq.ds.springmvc101.project;

import java.util.Set;

public class Project implements Comparable<Project>{
	
	private Long id;
	private String name;
	private Nature nature;
	private Set<String> tags;
	private State state;

	public Project() {
	}
	
		
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


	public Nature getNature() {
		return nature;
	}


	public void setNature(Nature nature) {
		this.nature = nature;
	}


	@Override
	public int compareTo(Project o) {
		return Long.compare(this.id, o.id);
	}
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public Set<String> getTags() {
		return tags;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}

}
