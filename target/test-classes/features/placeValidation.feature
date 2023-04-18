Feature: Validate Place API

Scenario Outline: Verify if place is successfully added using AddPlaceAPI
	Given Add Place Payload "<Name>" "<language>" "<address>"
  When user calls "AddPlaceAPI" with Post http request
  Then the API call is success with status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
	
	
	
	Examples: 
			|Name						|language	|address			|
			|Tulsi daas khan| Bangla	|14-A Mahabali|
