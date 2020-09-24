package actions;

import java.io.IOException;
import java.util.List;

import io.restassured.response.Response;
import runner.API_Calls;
import runner.Inputs;

public class ActionClass {

	public static String petStatus = null;
	public static Response responseBody;
	public static String id = null;

	public static int API_GetPets(String field, String status) {

		Response response = API_Calls.doGetRequest(Inputs.PetEndpoint + "findByStatus", field, status);

		List<String> jsonResponse = response.jsonPath().getList("$");
		return jsonResponse.size();

	}

	public static int API_GetStatus(String field, String status) {
		int statuscode = API_Calls.doGetStatus(Inputs.PetEndpoint + "findByStatus", field, status);

		return statuscode;

	}

	public static int API_GetStatus(String id) {
		int statuscode = API_Calls.doGetStatus(Inputs.PetEndpoint, id);

		return statuscode;
	}

	public static void API_PostPets() {

		responseBody = API_Calls.doPostRequest(Inputs.PetEndpoint, Inputs.NewPetPostPath);
		id = String.valueOf(responseBody.getBody().jsonPath().getLong("id"));

	}

	public static String API_GetPetStatus(String id) {

		responseBody = API_Calls.doGetBody(Inputs.PetEndpoint, id);

		petStatus = responseBody.jsonPath().get("status").toString();

		System.out.println("Stop");
		return petStatus;

	}

	public static int API_UpdatePetStatusAndPost(String petStatus, String avStatus, String upStatus)
			throws IOException {

		String Body = responseBody.getBody().asString().toString().replace(avStatus.toLowerCase(),
				upStatus.toLowerCase());

		GenericUtility.writeTexttoFile(Inputs.TempFilePath, Body);

		responseBody = API_Calls.doPostRequest(Inputs.PetEndpoint, Inputs.TempFilePath + "temp.json");

		

		return responseBody.getStatusCode();

	}

	public static int API_DeletePet() {

		responseBody = API_Calls.doDelelete(Inputs.PetEndpoint, id);
		//System.out.println(responseBody.getBody().jsonPath().getString("message"));
		return responseBody.getStatusCode();
		

	}
	
	public static String API_GetMessage() {
		
		responseBody = API_Calls.doGetBody(Inputs.PetEndpoint, id);
		
		String message = responseBody.getBody().jsonPath().get("message").toString();
		
		System.out.println(message);
		
		return message;
		
	}
	
	

}
