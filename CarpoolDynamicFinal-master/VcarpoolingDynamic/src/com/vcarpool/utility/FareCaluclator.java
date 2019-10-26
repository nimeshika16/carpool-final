package com.vcarpool.utility;

import com.vcarpool.exception.VCarpoolException;

public class FareCaluclator {

	public  FareCaluclator() {}
	
	public static double calculateFare(double dis) throws VCarpoolException {
		double x=0,y=0, fare=0;
		if(dis<=5){
	       // System.out.println("Fare for first 5KM : 20Rs");
	        System.out.println("Total distance: " +dis+ " fare:20" );
			
	    }   
	    else if((dis>5)&&(dis<=20))
	        {
	       // System.out.println("First 5 km fare : 20 Rs.");
	        x = dis-5;
	        y=x*10;
	       // System.out.println("For the next " +x+ " KM fare @10 : " +y+ " Rs.");
	        y=y+20;
	        //System.out.println("Total fare will be  : " +y+ " Rs.");
	        fare=y;
	    }
	    else if(dis>20){
	      //  System.out.println("First 5 km fare : 20 Rs.");
	        x=20;
	        y=20*10;
	       // System.out.println("For the next " +x+ " KM fare @10 : " +y+ " Rs.");
	        double z = dis-20;
	        double b = z*14;
	      //  System.out.println("For the next " +z+ " km  fare @14: " +b+ " Rs.");
	        double c=y+b+20;
	       fare = c;
	        // System.out.println("Total fare will be  : " +c+ " Rs.");
	    }   
		return fare;
		
	}
	
	
}
