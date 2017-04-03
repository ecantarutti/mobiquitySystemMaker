package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;

import com.jayway.restassured.RestAssured;

public class RestServiceSteps extends Steps{
	
	@Given("I DELETE the recently created computer")
	public void deletingComputer(){
		System.out.println(UiSteps.currentUrl);
		RestAssured.post(UiSteps.currentUrl+"/delete").andReturn().body().prettyPrint();
	}
	
	

}
