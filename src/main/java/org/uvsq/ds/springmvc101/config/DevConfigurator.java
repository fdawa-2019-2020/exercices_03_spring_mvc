package org.uvsq.ds.springmvc101.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.uvsq.ds.springmvc101.association.Association;
import org.uvsq.ds.springmvc101.association.AssociationService;
import org.uvsq.ds.springmvc101.person.Person;
import org.uvsq.ds.springmvc101.person.PersonService;
import org.uvsq.ds.springmvc101.project.Nature;
import org.uvsq.ds.springmvc101.project.Project;
import org.uvsq.ds.springmvc101.project.ProjectService;
import org.uvsq.ds.springmvc101.project.State;

@Component
public class DevConfigurator implements ApplicationListener<ContextRefreshedEvent>{
	
	private Logger logger = LoggerFactory.getLogger(DevConfigurator.class);
	
	public DevConfigurator() {
		logger.info(this.getClass().getSimpleName()+" Creation");
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		logger.info("Configure projectService");
		
		createProjects(event.getApplicationContext().getBean(ProjectService.class));
		createPersons(event.getApplicationContext().getBean(PersonService.class));
		createAssociations(event.getApplicationContext().getBean(AssociationService.class));
		
	}		

	private void createAssociations(AssociationService bean) {
		List<List<Long>> list = createRandomId(5, 5);
		List<Long> personIds = list.get(0);
		List<Long> projectIds = list.get(1);
		for (int i = 0; i < personIds.size(); i++) {
			Association association = new Association();
			association.setPersonId(personIds.get(i));
			association.setProjectId(projectIds.get(i));
			association.setRate(createRandomRate());
			bean.createOrUpdate(association);
			
		}
		
	}

	private void createPersons(PersonService personService) {
		
		String[][] names = new String[][] {
			{ "Nola", "Lang" },
			{ "Marley", "Cole" },
			{ "Jack", "Davenport" },
			{ "Jocelyn", "Rich" },
			{ "Cameron", "Rosario" },
			{ "Jaime", "Morales" },
			{ "Evie", "Dudley" },
			{ "Anabella", "Buckley" },
			{ "Courtney", "Curtis" },
			{ "Alexander", "Williamson" },
			{ "Sarahi", "Weaver" },
			{ "Karma", "Sherman" },
			{ "Janae", "Gill" },
			{ "Clinton", "Burgess" },
			{ "Stacy", "Farley" },
			{ "Malik", "Howell" },
			{ "Nehemiah", "Combs" },
			{ "Marshall", "Pineda" },
			{ "Ruby", "Heath" },
			{ "Addisyn", "Hoffman" },
		};
		
		Arrays.stream(names).forEach(name -> {
			String firstname = name[0];
			String lastname  = name[1];
			Person person = new Person();
			person.setFirstname(firstname);
			person.setLastname(lastname);
			personService.createPerson(person);
		});
			
		
	};

	private void createProjects(ProjectService projectService) {
		
		Map<String, Nature> nameAndNature = new HashMap<>();
		nameAndNature.put("MagicCakeFactory", Nature.OFFICIAL);
		nameAndNature.put("BloodyMary", Nature.OPEN);
		nameAndNature.put("AwesomeBanck", Nature.OFFICIAL);
		nameAndNature.put("Open-sea-action", Nature.OPEN);
		nameAndNature.put("save-zi-planet", Nature.OPEN);
		nameAndNature.put("draw-futur", Nature.OFFICIAL);
		nameAndNature.put("be-boop-a-loup-la", Nature.OPEN);
		nameAndNature.put("toinfiniteandbeyond", Nature.OFFICIAL);
		nameAndNature.put("moneymoney", Nature.OFFICIAL);
		nameAndNature.put("same-player-shoot-again", Nature.OPEN);
		
		String[] tags = new String[] {"java", "nosql", "ia", "machine-learning", "devops", "green-it", "python", "agile"};
		
		nameAndNature.keySet().forEach(key -> {
			Project p = new Project();
			p.setName(key);
			p.setNature(nameAndNature.get(key));
			Set<String> pTags = createRandomTagSetFrom(tags);
			p.setTags(pTags);
			p.setState(createRandomState());
			projectService.createProject(p);
		});		
	}

	private Set<String> createRandomTagSetFrom(String[] tags) {
		Random r = new Random();
		return r.ints(3, 0, tags.length).mapToObj(i -> tags[i]).collect(Collectors.toSet());
	}
	
	private int createRandomRate() {
		Random r = new Random();
		return r.nextInt(100);
	}
	
	private State createRandomState() {
		Random r = new Random();
		return r.ints(1, 0, State.values().length).mapToObj(i -> State.values()[i]).findAny().get();
	}	
	
	private List<List<Long>> createRandomId(int maxPerson, int maxProject) {
		Random r = new Random();
		List<Long> randomPersonId = r.longs(5, 0, maxPerson).mapToObj(Long::new).collect(Collectors.toList());
		List<Long> randomProjectId = r.longs(5, 0, maxProject).mapToObj(Long::new).collect(Collectors.toList());
		List<List<Long>> result = new ArrayList<List<Long>>();
		result.add(randomPersonId);
		result.add(randomProjectId);
		return result;
		
	}

}
