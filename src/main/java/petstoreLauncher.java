import static spark.Spark.*;

public class petstoreLauncher {
	public static void main(String argsp[]) {
		petAPI petAPI = new petAPI();
		spark.Spark.port(5000);
		
		get("/hello", (request,response) -> "get Hello, world!");
		post("/pets", (request,response) -> petAPI.addPet(request,response) );
	}
}
