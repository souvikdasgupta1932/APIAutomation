package sd;

import com.cucumber.listener.Reporter;

import actions.ActionClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import runner.API_Calls;
import runner.Inputs;

public class PostScenario {
	
	@When("^user post new pet$")
	public void user_post_new_pet() throws Throwable {
		Inputs.inputs();
	    ActionClass.API_PostPets();
	    Reporter.addStepLog("Pet Id= "+ActionClass.id);
	}

	@Then("^Verify new pet posted$")
	public void verify_new_pet_posted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    int status_code = ActionClass.API_GetStatus(ActionClass.id);
	    Reporter.addStepLog("Status Code= "+status_code);
	    Assert.assertEquals(status_code, 200);
	}

}
