package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDpTest {

	public static void main(String[] args) {
		Flipkart fpkt=null;
		fpkt=FlipkartFactory.getIinstance("dtdc");
		System.out.println(fpkt.shoping(new String[] {"tickets","umbrella","popcorn"},new  float[] {500,250,1000}));
		
		

	}

}
