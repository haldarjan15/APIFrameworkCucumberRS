Feature: Validate Place API's

Scenarios: Verify if place is successfully added using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with Post http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
  And "scope" in response body is "APP"
	
	