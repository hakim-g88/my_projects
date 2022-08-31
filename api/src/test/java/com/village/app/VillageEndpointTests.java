package com.village.app;

import com.village.app.testHelpers.TestHelper;
import com.village.app.testHelpers.fastTouches.VillageEndpointTestsFast;

import static org.hamcrest.Matchers.*;

import org.json.JSONException;
import org.junit.jupiter.api.*;

class VillageEndpointTests extends TestHelper {
	VillageEndpointTestsFast fast;

	@BeforeEach
	public void makeFast() {
		fast = new VillageEndpointTestsFast(request);
	}

//	@Test
//	public void createVillage() {
//		JSONObject json = new JSONObject();
//		json.put("name", "Lol");
//		json.put("civilians", 0);
//		request.contentType("application/json");
//		request.body(json.toString());
//		Response response = request.post("/village");
//		Assertions.assertEquals(response.getStatusCode(), 200);
//		Assertions.assertEquals(response.jsonPath().get("name"), "Lol");
//		Assertions.assertEquals(response.jsonPath().get("civilians"), Integer.valueOf(0));
//		Assertions.assertNotNull(response.jsonPath().get("id"));
//	}

	@Test
	public void createVillage2() throws JSONException {
		String id = fast.create(testData("KekTest")).assertThat().
				statusCode(200).
				body("name", equalTo(testData("KekTest", "name"))).
				body("civilians", equalTo(101)).
				body("id", notNullValue()).extract().jsonPath().get("id");
		getData().put("id", id);
	}

	@Test
	public void deleteVillage() throws JSONException {
				fast.delete(getData("id").toString()).
				statusCode(200);
	}
}
