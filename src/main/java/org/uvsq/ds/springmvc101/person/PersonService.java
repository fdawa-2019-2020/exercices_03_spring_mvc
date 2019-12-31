package org.uvsq.ds.springmvc101.person;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class PersonService {

	private Map<String,Person> personsByLogin = new HashMap<>();
	
	
	public List<Person> getAllPersons() {
		return personsByLogin.values().stream().sorted().collect(toList());
	}


	public synchronized Person createPerson(Person person) {
		String login= person.getLogin();
		if (login != null && personsByLogin.containsKey(login)) {
			throw new IllegalArgumentException(String.format("Login %s is already in use", login));
		} 
		
		if (login == null || login.trim().length() == 0) {
			login = generateUnusedLogin(person);
		}
		long id = (long) personsByLogin.size();
		person.setLogin(login);
		person.setId(id);
		personsByLogin.put(login, person);
		return person;		
	}


	private synchronized String generateUnusedLogin(Person person) {
		int indiceFirstname = 1;
		int indiceLastname = 3;
		String login = null;
		for(int i = 0; i < 10;i++) {
			login = person.getFirstname().substring(0, indiceFirstname)
					+"."
					+person.getLastname().substring(0,indiceLastname);
			login  = login.toLowerCase();
			if( ! personsByLogin.containsKey(login)) {
				return login;
			}
			if ( indiceLastname < person.getLastname().length() ) {
				indiceLastname++;
			} else if ( indiceFirstname < person.getFirstname().length() ) {
				indiceFirstname++;
			} else {
				throw new IllegalArgumentException(
						String.format("Unable to build a login. Last login is %s", login));
			}
		}
		throw new IllegalArgumentException(
				String.format("Unable to build a login. Last login is %s", login));
	}


	public Person getPersonByLogin(String login) {
		return personsByLogin.get(login);
	}


	public void updatePerson(Person p) {
		personsByLogin.put(p.getLogin(), p);
		
	}


	public Optional<Person> getPersonById(Long id) {
		return personsByLogin.values().stream().filter(p -> p.getId() == id).findFirst();
	}
}
