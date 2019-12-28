package org.uvsq.ds.springmvc101.project;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ProjectService {
	
	public Map<String, Project> projectByName = new HashMap<>();
	
	public List<Project> getAllProjects() {
		return projectByName.values().stream().sorted().collect(toList());
	}

	public Project createProject(Project p) {
		String name = p.getName();
		if ( projectByName.containsKey(name)) {
			throw new IllegalArgumentException("Name "+name+" is already in usage");
		} else {
			p.setId(new Long(projectByName.size()));
			projectByName.put(name, p);
		}
		return p;
	}

}
