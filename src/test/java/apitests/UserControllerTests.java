package apitests;

import static io.restassured.RestAssured.*;

import org.junit.Test;

public class UserControllerTests {
	@Test
	public void getUserTestReturns404IfNotFound() {
		given()
		.pathParam("uid", "59")
		.when()
			.get("http://checker.jettycloud.com:8080/api/public/user/info/{uid}")
		.then()
			.assertThat().statusCode(404);
	}
}