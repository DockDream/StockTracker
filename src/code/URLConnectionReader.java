package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.*;

import org.json.JSONObject;


public class URLConnectionReader {

	// MAYBE THIS METHOD RETURNS AN INSTANCE OF STOCK (uses overloaded constructor
	//    passing all parameters) TO CALCULATOR AT SYMBOLTEXT LISTENER
	// THEN THAT INSTANCE DOT GETTERS SETS TEXT FIELDS IN CALCULATOR
	// STOCK CONSTRUCTOR ADDS NEW INSTANCE TO DATABASE, VARAIBLES ONLY LIVE UNTIL A NEW
	//    INSTANCE IS CREATED 
	
	
	public static void getData(String s, Stock currentStock) throws Exception {
		
		// call individual methods for separate endpoint access to data
		getOneDay(s, currentStock);
		getSevenDay(s, currentStock);
		getThirtyDay(s, currentStock);
		getSector(s, currentStock);
		getEPSandVol(s, currentStock);
		getPE(s, currentStock);
		getALD(s, currentStock);
    	
    } // end getData method
	
	public static void getOneDay(String s, Stock currentStock) throws Exception{
		String address = new String("https://api.iextrading.com/1.0/stock/aapl/chart/1d?chartLast=1&filter=high");
        URL targetURL = new URL(address);
        URLConnection yc = targetURL.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        
        StringBuilder sb = new StringBuilder();
        String inputLine = "";
    
        while ((inputLine = in.readLine()) != null) { 
        	sb.append(inputLine);
        	
        	// println for testing, remove from final code
            System.out.println("first time:" + sb);
        } // end while
        
        in.close();
        
        // pull data from JSON array
        String jsonIn = sb.toString();
        JSONArray dayChartArray = new JSONArray(jsonIn);
        JSONObject dayObj = dayChartArray.getJSONObject(0);
        double dayHigh = dayObj.getDouble("high");
        
        currentStock.setDayHigh(dayHigh);
        
     // println for testing, remove from final code
    	System.out.println("This is the high: " + dayHigh);
    	
	} // end getOneDay method
	
	public static void getSevenDay(String s, Stock currentStock) throws Exception{
		// get today's date and put into String form
		Date date = new Date();
		String dateAsString = new SimpleDateFormat("yyyyMMdd").format(date);
		
		// NEED TO IDENTIFY DAY OF WEEK, SAT AND SUN RETURN NULL ARRAYS
		
		// create array to hold last 7 days of highs
		double [] arrayOfHighs = new double [7];
		
		String address = new String("https://api.iextrading.com/1.0/stock/aapl/chart/date/"
				+ dateAsString);
        URL targetURL = new URL(address);
        URLConnection yc = targetURL.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        
        StringBuilder sb = new StringBuilder();
        String inputLine = "";
    
        while ((inputLine = in.readLine()) != null) { 
        	sb.append(inputLine);
        	
        	// println for testing, remove from final code
            System.out.println("seven day method" + sb);
        } // end while
        
        in.close();
        
        // pull data from JSON array
        String jsonIn = sb.toString();
        JSONArray dayChartArray = new JSONArray(jsonIn);
        JSONObject dayObj = dayChartArray.getJSONObject(0);
        double dayHigh = dayObj.getDouble("high");
        
        currentStock.setDayHigh(dayHigh);
        
     // println for testing, remove from final code
    	System.out.println("This is the high: " + dayHigh);
		
	} // end getSevenDay method
	
	public static void getThirtyDay(String s, Stock currentStock) {
		
	} // end getThirtyDay method
	
	public static void getSector(String s, Stock currentStock) {
		
	} // end getSector method
	
	public static void getEPSandVol(String s, Stock currentStock) {
		
	} // end getEPSandVol method
	
	public static void getPE(String s, Stock currentStock) {
		
	} // end getPE method
	
	public static void getALD(String s, Stock currentStock) {
		
	} // end getALD method
	
} // end URLConnectionReader class
