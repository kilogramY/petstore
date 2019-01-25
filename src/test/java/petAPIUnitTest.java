import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;
import com.eclipsesource.json.JsonObject;

import spark.Request;
import spark.Response;

public class petAPIUnitTest {
	
	petService petService = mock(petService.class);
	petAPI petAPI = new petAPI(petService);
	Request request = mock(Request.class);
	Response response = mock(Response.class);
	
	@Test
	public void addPet() {
		//request.body = {"name":"doggie","..."};
		//Arrange
		given(request.body()).willReturn(petJson());
		given(petService.addPet(any())).willReturn(new Pet("id","doggie"));
		
		//Act
		String actualPet = petAPI.addPet(request, response);

		//Assert
		verify(petService).addPet(new petCreationData("doggie"));
		
		String expectedPetJson = "{\"id\":\"id\",\"name\":\"doggie\"}";
		assertEquals(expectedPetJson,actualPet);
				
	}
	
	private String petJson() {
		String pet = new JsonObject()
				.add("name","doggie")
				.add("photoUrls","http://localhost/photo/doggie.jpg")
				.toString();
		
		return pet;
	}
	
	@Test
	public void mypet() {
		
	}

}
