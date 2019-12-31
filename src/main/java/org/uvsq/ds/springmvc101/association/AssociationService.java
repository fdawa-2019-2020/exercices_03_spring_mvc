package org.uvsq.ds.springmvc101.association;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.uvsq.ds.springmvc101.person.Person;
import org.uvsq.ds.springmvc101.person.PersonService;
import org.uvsq.ds.springmvc101.project.Nature;
import org.uvsq.ds.springmvc101.project.Project;
import org.uvsq.ds.springmvc101.project.ProjectService;

@Service
public class AssociationService {

	private Logger logger = LoggerFactory.getLogger(AssociationService.class);
	
	private ProjectService projectService;
	private PersonService personService;

	public AssociationService(PersonService personService, ProjectService projectService) {
		this.personService = personService;
		this.projectService = projectService;
	}

	public Association createOrUpdate(Association association) {
		Optional<Project> opProject = projectService.getProjectById(association.getProjectId());
		Optional<Person> opPerson = personService.getPersonById(association.getPersonId());

		if (opPerson.isPresent() && opProject.isPresent()) {
			personService.updateProjectAssociation(opPerson.get(), opProject.get(), association.getRate());
		} else {
			logger.info("Missing element for association {} ", association);
		}

		return association;
	}
	
	public Nature getNaturePerProjectName(String name) {
		Optional<Project> opProject = projectService.getProjectByName(name);
		if ( opProject.isPresent() ) {
			return opProject.get().getNature();
		}
		return null;
	}

	public List<Association> getAllAssociations() {
		List<Association> associations =  new ArrayList<>();
		
		List<Person> persons = personService.getAllPersons();
		for (Person person : persons) {
			
			Map<String, Integer> participations = person.getParticipationPerProjectName();
			
			if ( participations != null ) {
				for (String projectName : participations.keySet()) {
					
					Optional<Project> opProject = projectService.getProjectByName(projectName);
					
					if ( opProject.isPresent() ) {
						
						Association association = new Association();
						association.setPersonId(person.getId());
						association.setProjectId(opProject.get().getId());
						association.setRate( person.getParticipationPerProjectName().get(projectName));
						
						associations.add(association);
					}
					
				}
			}
		}
		return associations;
	}

	/**
	 * 
	 * @param association
	 * @return rate
	 */
	public Integer delete(Association association) {
		Optional<Project> opProject = projectService.getProjectById(association.getProjectId());
		Optional<Person> opPerson = personService.getPersonById(association.getPersonId());

		if (opPerson.isPresent() && opProject.isPresent()) {
			return personService.deleteProjectAssociatation(opPerson.get(), opProject.get());
		}
		return -1;
	}

}
