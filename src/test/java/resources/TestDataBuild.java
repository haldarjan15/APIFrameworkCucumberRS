package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	
	
	public AddPlace addPlacePayLoad()
	{
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
		return p;
	}

}
