package com.amdocs.propertySearch.main;

import java.util.List;
import java.util.Scanner;

import com.amdocs.propertySearch.DAO.PropertyDAO;
import com.amdocs.propertySearch.model.Property;
import com.amdocs.propertySearch.exception.*;


public class Main {

	public static void main(String[] args) throws ExceptionProperty{
    	int choice;
    	Scanner sc=new Scanner(System.in);
    	do {
    		System.out.println("Enter your choice:");
    		System.out.println("1.Add new property");
    		System.out.println("2.Update property cost");
    		System.out.println("3.Delete property");
    		System.out.println("4.Find by city");
    		System.out.println("5.View all properties");
    		System.out.println("6.Find by cost");
    		System.out.println("7.Find by no of rooms and city");
    		System.out.println("8.Exit");
    		
    		choice=sc.nextInt();
    		
    		switch(choice) {
    		case 1:
    			System.out.println("Enter property id: ");
    			int propertyId=sc.nextInt();
    			System.out.println("Enter no of rooms: ");
    			String noOfRooms=sc.next();
    			System.out.println("Enter area in sqft: ");
    			double areaInSqft=sc.nextDouble();
    			System.out.println("Enter Floor no: ");
    			int floorNo=sc.nextInt();
    			System.out.println("Enter city: ");
    			String city=sc.next();
    			System.out.println("Enter state: ");
    			String state=sc.next();
    			System.out.println("Enter cost: ");
    			double cost=sc.nextDouble();
    			System.out.println("Enter owner name: ");
    			String ownerName=sc.next();
    			System.out.println("Enter owner contact no: ");
    			String ownerContactNo=sc.next();
    			Property property=new Property();
    			property.setPropertyId(propertyId);
    			property.setNoOfRooms(noOfRooms);
    			property.setAreaInSqft(areaInSqft);
    			property.setFloorNo(floorNo);
    			property.setCity(city);
    			property.setState(state);
    			property.setCost(cost);
    			property.setOwnerName(ownerName);
    			property.setOwnerContactNo(ownerContactNo);
    			PropertyDAO p=new PropertyDAO();
    			int i= p.addProperty(property);
    			System.out.println("proprty added");
    			break;
    			
    		case 2:
    			System.out.println("Enter id:");
    			int id=sc.nextInt();
    			System.out.println("Enter new cost:");
    			double newCost=sc.nextDouble();
    			PropertyDAO p1=new PropertyDAO();
    			boolean b=p1.updatePropertyCost(id,newCost);
    			break;
    			
    		case 3:
    			System.out.println("Enter id:");
    			int id1=sc.nextInt();
    			PropertyDAO p2=new PropertyDAO();
    			p2.deleteProperty(id1);
    			break;
    			
    		case 4:
    			System.out.println("Enter city:");
    			String findCity=sc.next();
    			PropertyDAO p3=new PropertyDAO();
    			List<Property> cityResults=p3.searchByCity(findCity);
    			if(cityResults.isEmpty()) {
    				try{
    					throw new ExceptionProperty();
    				}catch(Exception e)
    				{
    					continue;
    					}
    				
    				//System.out.println("Property not available");
    			}
    			else {
    				    for(Property result:cityResults) {
    					  System.out.println(result);
    					}
    			}
    			break;
    			
    		case 5:
    			PropertyDAO p4=new PropertyDAO();
    			List<Property> viewAllProperties=p4.findAllProperties();
    			for(Property prop:viewAllProperties) {
    				System.out.println(prop);
    				}
    			break;
    			
    		case 6:
    			System.out.println("Enter cost:");
    			double cost1=sc.nextDouble();
    			System.out.println("Enter cost:");
    			double cost2=sc.nextDouble();
    			PropertyDAO p5=new PropertyDAO();
    			List<Property> costResults=p5.searchByCost(cost1,cost2);
    			if(costResults.isEmpty()) {
    				try{
    					throw new ExceptionProperty();
    				}catch(Exception e){
    					continue;
    					}
    				
    				//System.out.println("Property not available");
    				}else {
    					for(Property result:costResults) {
    						System.out.println(result);
    				}
    			}
    			break;
    			
    		case 7:
    			System.out.println("Enter city:");
    			String findRoomsCity=sc.next();
    			System.out.println("Enter number of rooms:");
    			String findRooms=sc.next();
    			PropertyDAO p6=new PropertyDAO();
    			List<Property> roomsCityResults=p6.findByRoomsAndCity(findRooms,findRoomsCity);
    			if(roomsCityResults.isEmpty()) {
    				try{
    					throw new ExceptionProperty();
    				}catch(Exception e){
    					continue;
    					}
    				
    				//System.out.println("Property not available");
    				}else {
    					for(Property result:roomsCityResults) {
    						System.out.println(result);
    				}
    			}
    			break;
    			
    		case 8:
    		  System.out.println("Exit");
    		  break;
    		  default:
    			  System.out.println("Invalid Choice");
    		
    		}
    	}while(choice!=8);
    	sc.close();
    }

	
}
