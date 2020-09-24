package runner;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.List;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

public class API_Calls {

	Response res = given().when().queryParam("status", "available")
			.get("https://petstore.swagger.io/v2/pet/findByStatus");

	public static Response doGetRequest(String endpoint, String Query1, String Key1) {
		RestAssured.defaultParser = Parser.JSON;

		return given().when().queryParam(Query1, Key1).get(endpoint).then().contentType(ContentType.JSON).extract()
				.response();
	}

	public static int doGetStatus(String endpoint, String Query1, String Key1) {

		int res = given().when().queryParam(Query1, Key1).get(endpoint).then().extract().statusCode();

		return res;

	}

	public static int doGetStatus(String endpoint, String id) {

		int res = given().when().get(endpoint + id).then().extract().statusCode();

		return res;

	}

	public static Response doPostRequest(String endpoint, String jsonPath) {

		File jsonDataInFile = new File(jsonPath);
		RestAssured.defaultParser = Parser.JSON;
		Response post = given().baseUri(endpoint).contentType(ContentType.JSON).body(jsonDataInFile).when().post()
				.then().contentType(ContentType.JSON).extract().response();

		return post;

	}

	

	public static Response doGetBody(String endpoint, String id) {

		Response response = given().when().get(endpoint + id).then().contentType(ContentType.JSON).extract().response();

		return response;

	}
	
	public static Response doDelelete(String endpoint, String id) {
		
		
		
		Response response  = given().when().delete(endpoint + id).then().contentType(ContentType.JSON).extract().response();
		return response;
	}

}