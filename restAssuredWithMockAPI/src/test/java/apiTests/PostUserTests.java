package apiTests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import Pojo.UserDTO;
import setup.BaseTestApi;
import utilities.RequestBodyBuilder;

public class PostUserTests extends BaseTestApi {
	@Test
	public void VerifyPostUser() {
		String body = RequestBodyBuilder.postBodyProcessor(new UserDTO("Sammy", "QA"));
		given().body(body).header("Content-Type", "application/json").post("/api/users").then().statusCode(201);
	}

	@Test
	public void VerifyGetUser() {
		String body = RequestBodyBuilder.postBodyProcessor(new UserDTO("Test", "QA"));
		given().when().get("/api/test").then().statusCode(200);
	}

}
