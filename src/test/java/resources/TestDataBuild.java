package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	
	
	public AddPlace addPlacePayLoad(String Name, String language, String Address)
	{
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(language);
		p.setPhone_number("8860408242");
		p.setWebsite("http://google.com");
		p.setName(Name);
		List<String> mylist= new ArrayList<String>();
		mylist.add("Shoe Park");
		mylist.add("Shoe Park2");
		p.setTypes(mylist);
		
		Location loc = new Location ();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		return p;
	}

}
