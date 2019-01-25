import static org.junit.Assert.*;

import org.junit.Test;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class minimalJasonTest {

	@Test
	public void jsonObject() {
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.add("id", "001");
		
		assertEquals("{\"id\":\"001\"}",jsonObject.toString());
	}
	
	@Test
	public void jsonObject_parse() {
		JsonObject object = Json.parse("{\"id\":\"001\"}").asObject();
		
		assertEquals("\"001\"",object.get("id").toString());
	}

}
