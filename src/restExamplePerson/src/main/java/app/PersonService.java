package app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonService {

	private static List<Person> persons;
	
		// login: metodot kje prima username i password -> da vrati success status i da
		// setira vreme koga se logiral userot
		// logout: metodot kje prima username i vrakja nazad poraka deka e odjaven
		// userot i go prazni vremeto, da go setira login statusot vo false
		// changePersonStatus
		// editPerson
		// getAllActivePersons


	@GET
	@Path("/getAll")
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		System.out.println("Test");
		return persons;
	}

	@GET
	@Path("/hello")
	public String hello() {
		return "Hello";

	}

	@POST
	@Path("/create")
//	@Consumes(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createPerson(Person person) {
		PersonDAO.insertpersonInDB(person);
		persons.add(person);
		return "Person with id: " + person.getId() + " is created succesfully!";
	}
	
	@POST
	@Path("/login")
	public String login(LoginRequest request) {
		
		Person p = PersonDAO.findPersonByUsernamePassword(request.getUsername(), request.getPassword());
		
		if(p != null) {
			
			System.out.println("Firstname:" + p.getFirstName() + ", login status: " + p.getLoginStatus());
		
			PersonDAO.updateLoginStatus(p);
			
		}else {
			
			return "Invalid credentials";
		}
		
		return "User with username: " + request.getUsername() + " is logged in";
		
	}
	
	@PUT
	@Path("/logout/{username}")
	public String logout(@PathParam("username")String username) {
		
		Person p = PersonDAO.checkIfUserIsLoggedIn(username);
		
		if(p!=null) {
			
			PersonDAO.changeStatus(p);
		}else {
			return "User is not logged in";
		}
		
		return "Logout";
	}

	@GET
	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Person findById(@PathParam("id") Integer id) {

		for (Person p : persons) {
			if (p.getId() == id)
				return p;
		}

		try {
			throw new Exception("No person found with id " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePerson(@PathParam("id") Integer id, Person person) {
		for (Person p : persons) {

			if (p.getId() == id) {
				p.setFirstName(person.getFirstName());
				p.setLastName(person.getLastName());
				p.setEmail(person.getEmail());
				return "Person with id:" + p.getId() + "has been updated";
			}
		}

		return "No person with id " + id + "found";
	}

	@DELETE
	@Path("/delete/{id}")
	public String deletePerson(@PathParam("id") Integer id) {

//		Integer index = 0;

		for (Person person : persons) {

			if (person.getId() == id) {

//				index = persons.indexOf(person);
				persons.remove(person);

				return "User with id " + person.getId() + "is deleted";

			}

		}

		return "No person with id " + id + "found";
	}

	public PersonService() {
		
			initPerson();

	}

	private void initPerson() {

		if (persons == null) {
			persons = new ArrayList<Person>();
			persons.add(new Person(1, "Goran", "Stanic", "goran@gmail.com"));
			persons.add(new Person(2, "Aleksandar", "Vishinov", "aleksandar@gmail.com"));
			persons.add(new Person(3, "Vlatko", "Donchev", "vlatko@gmail.com"));
		}


	}

}
