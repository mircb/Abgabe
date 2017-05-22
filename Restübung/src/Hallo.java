import javax.ws.rs.*;
@Path("ubung")											//http://localhost/ubung
public class Hallo {


	@GET
	@Produces("text/plain")
	public String Start(){
		return "Willkommen im  besten sozialen Netzwerk(besser als Facebook) \n\n" +
				"/'username' 	     --> Willkomensseite\n" +
				"/Home       	     --> Deine Posts\n" +
				"/Freunde/'username'  --> Deine Freunde \n";
	}

	@Path("Post")
	@GET
	@Produces("text/plain")
	public String User(){
		return "Dein Zeug wurde gepostet ";
	}

	@Path("Home")
	@GET
	@Produces("text/plain")
	public String Home(){
		return "Deine Posts: \n\n #some random stuff ";
	}

	@GET
	@Path("{user}")
	@Produces("text/plain")
	public String Post(@PathParam("user") String user){
		return "Hallo "+ user;
	}
	
	@GET
	@Path("Freunde/{user}")
	@Produces("application/json")
	public String Freunde(@PathParam("user") String user)
	{
		return user+"'s Freunde sind: {Hans}[Peter}{Georg}{Walter}";
	}
}