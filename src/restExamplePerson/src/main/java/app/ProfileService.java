package app;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/profile")
public class ProfileService {

	@POST
	@Path("/create")
	public String createProfile(@QueryParam("username") String username, UserProfile profile) {

		System.out.println(username);

		Person p = PersonDAO.findPersonByUsername(username);

		profile.setPerson(p);

		ProfileDAO.createProfile(profile);

		return "Success";
	}
	
	@PUT
	@Path("/update")
	public String updateProfile(@QueryParam("username")String username, UserProfile profileUpdates) {
		
		
		Person p = PersonDAO.findPersonByUsername(username);
		
		UserProfile userProfile = ProfileDAO.getProfileByUserId(p.getId(), username);
		
		userProfile.setEducation(profileUpdates.getEducation());
		userProfile.setSkills(profileUpdates.getSkills());
		userProfile.setInterests(profileUpdates.getInterests());
		
		ProfileDAO.updateUserProfile(userProfile);
		
		
		return "User: " + username +" made updates on his profile";
		
	}
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserProfile getProfileByUsername(@PathParam("username") String username) {
		
		Person p = PersonDAO.findPersonByUsername(username);
		
		UserProfile profile = ProfileDAO.getProfileByUserId(p.getId(), username);
		
		return profile;
	}

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserProfile> getAllProfiles(){
		
		return ProfileDAO.getAllProfiles();
	}
	
	//getProfileByUsername  - DONE
	//updateProfile  - DONE
	
	//getProfileByActiveUser
	
	
	//getAllProfiles

}
