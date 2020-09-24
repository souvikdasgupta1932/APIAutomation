package sd;

import com.cucumber.listener.Reporter;

import actions.ActionClass;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class DeletePet {
	
	@Then("^the user deletes the pet from the store$")
	public void the_user_deletes_the_pet_from_the_store() throws Throwable {
		int status_code = ActionClass.API_DeletePet();
	}
	
	@Then("^verify pet is removed$")
	public void verify_pet_is_removed() throws Throwable {
		int status_code = ActionClass.API_GetStatus(ActionClass.id);
	    Reporter.addStepLog("Status Code= "+status_code);
	    Assert.assertEquals(status_code, 404);
	    String message = ActionClass.API_GetMessage();
	    Reporter.addStepLog("Pet Status= "+message);
	    Assert.assertEquals(message, "Pet not found");
	    
	}

}
