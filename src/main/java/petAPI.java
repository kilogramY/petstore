import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import spark.Request;
import spark.Response;

public class petAPI {

	private petService petService;
	
	public petAPI(petService petService) {
		this.petService = petService;
	}
	
	public String addPet(Request request, Response response) {
		// TODO Auto-generated method stub
		petCreationData petCreationData = preparePetCreationData(request);
		
		Pet pet = petService.addPet(petCreationData);
		
		// pet -> jsonObject
		JsonObject jsonObject = new JsonObject()
								.add("id",pet.getId())
								.add("name", pet.getName())
								;
		
		JsonObject a = prepareResponse(response);
		
		return jsonObject.toString();
	}
	
	private JsonObject prepareResponse(Response response) {
		response.status(201);
		response.type("application/json");
		
		JsonObject jsonObject = new JsonObject();
		
		return jsonObject;
	}
	
	private petCreationData preparePetCreationData(Request request) {
		String body = request.body();
		System.out.println("addPet is called: "+body);
		
		// body -> petCreationData
		JsonObject jsonObject = Json.parse(body).asObject();
		
		petCreationData petCreationData = new petCreationData(jsonObject.getString("name",""));
		
		return petCreationData;
	}

}
