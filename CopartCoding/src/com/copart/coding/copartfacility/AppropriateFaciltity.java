package com.copart.coding.copartfacility;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class AppropriateFaciltity {

	
	public static void main(String[] args) {
			
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter zip code: ");
				String zipCode = sc.next();
				
				System.out.println("Enter CustomerId: ");
				String customerID = sc.next();
				
				ArrayList<String> list = getPosition(zipCode);
				
				Double latitude = Double.parseDouble(list.get(0));
				Double longitude = Double.parseDouble(list.get(1));
				
				System.out.println("Latitude: " + latitude + " Longitude: " + longitude);
				
				Double distance = calculateShortestDistance(latitude,longitude);
				System.out.println("The shortest distance in miles from the current location is: " + (distance * 0.621371));				
				System.out.println("For customer " + customerID + " with zipcode of " + zipCode + " closest Copart Facility is at distance: " + (distance * 0.621371));
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			

		}
		private static Double calculateShortestDistance(Double referenceLatitude, Double referenceLongitude) throws Exception {
			 
			 /* 
			  * We fetch each latitude and longitude from the database using FetchData.java
			  
			  	FetchZipcode f = new FetchData();
			 	ResultSet rs = f.getData();
			 	Double min = Double.MAX_VALUE;
			 	
			  */
			 
			/*
			 
			Using the latitude and longitude for each zipcode and distance for the same from reference location and return the min
			
			 while(rs.next()) {
				 
				 Double sampleLatitude = Double.parseDouble(rs.getDouble(1));
				 Double sampleLongitude = Double.parseDouble(rs.getDouble(2));
				 Double distance = calculateDistance(referenceLatitude, referenceLongitude, sampleLatitude, sampleLongitude);
				 String closestZipCode = null;
				 if(distance < min) {
					 min = distance;
					 closestZipCode = rs.getString(3);
					  
				 }
				 return String[] min, closestZipCode ;
			 */
			 
				 
				//Sample values replaced for the one obtained from DB
				Double sampleLatitude = 20.0;
				Double sampleLongitude = -100.0;
				Double distance = calculateDistance(referenceLatitude, referenceLongitude, sampleLatitude, sampleLongitude);
					
				 return distance;
			 }
		
		public static Double calculateDistance(Double latitude, Double longitude, Double sampleLatitude, Double sampleLongitude) {
			
			final int R = 6371; // Radius of the earth
		    Double latDistance = Math.toRadians(sampleLatitude - longitude);
		    Double lonDistance = Math.toRadians(sampleLongitude - latitude);
		    
		    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		            + Math.cos(Math.toRadians(longitude)) * Math.cos(Math.toRadians(sampleLatitude))
		            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		    
		    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    
		    double distance = R * c ; // in kilometers

		    distance = Math.pow(distance, 2);
		    return Math.sqrt(distance);
		}
		
		
		public static ArrayList<String> getPosition(String zipCode) throws Exception
		  {
		    int responseCode = 0;
		    //String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(zipCode, "UTF-8") + "&sensor=true";
		    String address = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + zipCode + "&sensor=true";
		    
		    URL url = new URL(address);
		    
		    //Creating a HTTP connection
		    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
		    
		    //Connecting the above address
		    httpConnection.connect();
		    
		    //Response code
		    responseCode = httpConnection.getResponseCode();
		    
		    //Response XML from above address
		    InputStream responseXml = httpConnection.getInputStream();
		    
		    //DocumentBuilder is used to read XML response obtained from above address
		    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document document =  builder.parse(responseXml);
		    XPathFactory xPathfactory = XPathFactory.newInstance();
		    XPath xpath = xPathfactory.newXPath();
		    XPathExpression expr = xpath.compile("/GeocodeResponse/status");
		    String status = (String)expr.evaluate(document, XPathConstants.STRING);
		      
		    //Response Code 200 indicates that response is OK
		    if(responseCode == 200)
		    {
		    	/*
			      
			      if(status.equals("OK"))
			      {*/
			         expr = xpath.compile("//geometry/location/lat");
			         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
			         expr = xpath.compile("//geometry/location/lng");
			         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
			         
			         ArrayList<String> list = new ArrayList<>();
			         
			         list.add(latitude);
			         list.add(longitude);
			         return list;
			      
			      
			    }else
			      {
			         throw new Exception("Error in address - response status: "+status);
			      }
		  }

	}

