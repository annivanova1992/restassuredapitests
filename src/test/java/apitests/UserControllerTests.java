package apitests;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import io.restassured.response.ResponseBody;

import com.google.gson.*;

import static org.hamcrest.Matchers.equalTo;

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
	
	@Test
	public void getUserTestReturnsError() {
		given()
			.pathParam("uid", "59")
		.when()
			.get("http://checker.jettycloud.com:8080/api/public/user/info/{uid}")
		.then()
			.assertThat().statusCode(404);
	}
	
	@Test
	public void postUserStart() {
		int uid = 59; 
		given()
			.pathParam("uid", uid)
		.when()
			.post("http://checker.jettycloud.com:8080/api/public/user/start/{uid}")
		.then()
			.assertThat()
			.body("message", equalTo("User with uid " + uid + " not found"));
	}
}