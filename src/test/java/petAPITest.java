import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.eclipsesource.json.JsonObject;

import static io.restassured.RestAssured.*;

public class petAPITest {

	@BeforeClass
	public static void setUp() {
		String[] args = null;
		petstoreLauncher.main(args);
	}
	
	@Test
	public void hello() {
		when()
			.get("http://localhost:5000/hello")
		.then().statusCode(200);
	}
	
	@Test
	public void addPet_should_succeed() {		
		String pet = new JsonObject()
				.add("name","doggie")
				.add("photoUrls","http://localhost/photo/doggie.jpg")
				.toString();
		given()
			.body(pet)
		.when()
			.post("http://localhost:5000/pets")
		.then()
			.statusCode(201)
			.body("name",equalTo("doggie"))
			.body("photoUrls",equalTo("http://localhost/photo/doggie.jpg"))
			;
	}

}
