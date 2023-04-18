package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import io.restassured.path.json.JsonPath;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	TestDataBuild data= new TestDataBuild();
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String Name, String Language, String Homeaddresss) throws IOException  {
		 
		 res=given().spec(requestSpecification())
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		//Response res=given().queryParam("key", "qaclick123")
		.body(data.addPlacePayLoad(Name,Language,Homeaddresss));
		
    }

    @When("user calls {string} with Post http request")
    public void user_calls_something_with_post_http_request(String string)
    {    resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response=res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1)  {
    	assertEquals(response.getStatusCode(),200);
     
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue , String Expectedvalue){
      String resp= response.asString();
      JsonPath js=new JsonPath(resp);
  	assertEquals( js.get(keyValue).toString(),Expectedvalue);
    }
    

   
	
}
