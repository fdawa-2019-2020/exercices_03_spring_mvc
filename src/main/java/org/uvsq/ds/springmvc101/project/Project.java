package org.uvsq.ds.springmvc101.project;

public class Project implements Comparable<Project>{
	
	private Long id;
	private String name;
	private Nature nature;

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

}
