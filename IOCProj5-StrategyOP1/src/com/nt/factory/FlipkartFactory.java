package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class FlipkartFactory {
	public static Flipkart getIinstance(String CourierName) {
		Courier courier=null;
		Flipkart fpkt=null;
		//create dependent class object
		if(CourierName.equalsIgnoreCase("dtdc") )
			courier=new DTDC();
		else if(CourierName.equalsIgnoreCase("bluedart"))
			courier=new BlueDart();
		else
			throw new IllegalArgumentException("invalid courier type");
		//create target class object
		fpkt=new Flipkart();
		//assine dependent class obj. to target class obj
		fpkt.setCourier(courier);
		return fpkt;
			
		
	}

}
