package ApiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.testng.annotations.Test;
import Pojo.UserDTO;
import io.restassured.specification.RequestSpecification;
import setup.BaseTest;
import utilities.RequestBodyBuilder;

public class PostUserTests extends BaseTest {
	@Test
	public  void VerifyPostUser()
	{
		String body = RequestBodyBuilder.postBodyProcessor("{\"name\":\"Test\"}");
		given().spec(rSpecObj).body(body).when()
				.post("/api/users").then().statusCode(201).body("name", equalTo("Test"))
				.body("job", equalTo("QA")).body("id", notNullValue()).log();
	}
	
	@Test
	public  void VerifyGetUser()
	{
		String body = RequestBodyBuilder.postBodyProcessor(new UserDTO("Test", "QA"));
		given().when()
				.get("/api/test").then().statusCode(200);
	}

}
