import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredPractice {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }
    
	@Test
	public void getReq() {
		Response response = RestAssured
	    .given()
	        
	    .when()
	        .get("/v2/store/inventory")
	    .then()
	        .statusCode(200)
	        .log().all()
	        .extract()
	        .response();
	}
	
	@Test
	public void postReq() {
        Map<String, Object> reqBody = new HashMap<>();
        
        reqBody.put("id", 12345);
        reqBody.put("username", "Rohit");
        reqBody.put("firstName", "Rohit");
        reqBody.put("lastName", "Sharma");
        reqBody.put("email", "abc@gmail.com");
        reqBody.put("password", "Rohit@264");
        reqBody.put("phone", "883864834837847837");
        reqBody.put("userStatus", 1);
        
		
		Response response = 
		 RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(reqBody)
				
				.when()
				.post("/v2/user")
				
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		
		System.out.println(response.asString());
		
	}
	
	@Test
	public void putReq() {
		Map<String, Object> updateReqBody = new HashMap<>();
		
		updateReqBody.put("username", "Rohit updated");
		
		Response response = 
				 RestAssured
						.given()
						.contentType(ContentType.JSON)
						.body(updateReqBody)
						
						.when()
						.put("/v2/user/Rohit")
						
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
				
		System.out.println(response.asString());
	}
	
	@Test
	public void deleteReq(){
		
		Response response = 
				 RestAssured
						.given()
						.contentType(ContentType.JSON)
						
						.when()
						.delete("/v2/user/Rohit")
						
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
				
		System.out.println(response.asString());
		
	}
}
