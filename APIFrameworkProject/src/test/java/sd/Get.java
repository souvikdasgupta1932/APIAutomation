package sd;

import com.cucumber.listener.Reporter;

import actions.ActionClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import runner.Inputs;


public class Get {
	
	static int count = 0;
	static int status_code=0;
	@When("^user get pets on \"([^\"]*)\" is \"([^\"]*)\"$")
	public void user_get_pets_on_is(String field, String status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Inputs.inputs();
		status_code = ActionClass.API_GetStatus(field,status);
		Reporter.addStepLog("Status Code= "+status_code);
		Assert.assertEquals(status_code, 200);
	    count = ActionClass.API_GetPets(field,status);
	    
	}

	@When("^verifies the total number pets$")
	public void verifies_the_total_number_pets() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(Inputs.TotalPets, count);
	}




}
