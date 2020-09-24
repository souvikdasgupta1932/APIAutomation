package sd;

import com.cucumber.listener.Reporter;

import actions.ActionClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import runner.API_Calls;

public class PutScenario {
	
	@When("^the user gets the pet status$")
	public void the_user_gets_the_pet_status() throws Throwable {
		String petStatus = ActionClass.API_GetPetStatus(ActionClass.id);
		Reporter.addStepLog("Pet Id= "+ActionClass.id);
		Reporter.addStepLog("Pet Status= "+petStatus);
		
		
	}

	
	@Then("^the user updates the status from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void the_user_updates_the_status_from_to(String avStatus, String upStatus) throws Throwable {
		int status_code = ActionClass.API_UpdatePetStatusAndPost(ActionClass.id, avStatus, upStatus);
		Reporter.addStepLog("Status Code= "+status_code);
		Reporter.addStepLog("Pet Status Successfully updated");
		Assert.assertEquals(status_code, 200);
	}


	@Then("^verifies the status is \"([^\"]*)\"$")
	public void verifies_the_status_is(String arg1) throws Throwable {
		String petStatus = ActionClass.API_GetPetStatus(ActionClass.id);
		Reporter.addStepLog("Pet Id= "+ActionClass.id);
		Reporter.addStepLog("Pet Status= "+petStatus);
	   
	}

}
