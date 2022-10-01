package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	//property
	private Courier courier;
	public Flipkart() {
		System.out.println("Flipkart::0-param constructor");
	}

	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier()");
		this.courier = courier;
	}
	//business method
	public String shoping(String[] items , float[] prices) {
		System.out.println("Flipkart.shoping()");
		float billAmt=0.0f;
		int oid=0;
		String msg=null;
		Random rad=null;
		
		//calculate bull amount
		for(float p:prices) 
	
		//billAmt=billAmt+p  
		billAmt+=+p;
		//generate oid dynamically as random number
		rad=new Random();
		oid=rad.nextInt(10000);
		//use courier service for delivering the product
		msg=courier.deliver(oid);
		//return bill amt and courier details to customer
		return Arrays.toString(items)+"are purchased having price"+Arrays.toString(prices)+"will bill amount"+billAmt+ "-----" +msg;
		
		
		
		
	}
	

}
