package stepDefinations;

import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;


public class StepDefination {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	@Given("Add Place Payload")
    public void add_place_payload()  {
		System.out.println("hello");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("English");
		p.setPhone_number("8860408242");
		p.setWebsite("http://google.com");
		p.setName("Amit");
		List<String> mylist= new ArrayList<String>();
		mylist.add("Shoe Park");
		mylist.add("Shoe Park2");
		p.setTypes(mylist);
		
		Location loc = new Location ();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		
		RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON)
		.build();
		
		 resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		 res=given().spec(req)
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		//Response res=given().queryParam("key", "qaclick123")
		.body(p);
    }

    @When("user calls {string} with Post http request")
    public void user_calls_something_with_post_http_request(String string)
    {    	
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
