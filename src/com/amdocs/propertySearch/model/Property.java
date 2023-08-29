package com.amdocs.propertySearch.model;


public class Property {
	public int propertyId;
	public String noOfRooms;
	public double areaInSqft;
	public int floorNo;
	public String city;
	public String state;
	public double cost;
	public String ownerName;  
	public String ownerContactNo;
	public Property() {
		
	}
	public Property(int int1, String string, double double1, int int2, String string2, String string3, double double2,
			String string4, String string5) {
		this.propertyId=int1;
		this.noOfRooms=string;
		this.areaInSqft=double1;
		this.floorNo=int2;
		this.city=string2;
		this.state=string3;
		this.cost=double2;
		this.ownerName=string4;
		this.ownerContactNo=string5;
		
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public double getareaInSqft() {
		return areaInSqft;
	}
	public void setAreaInSqft(double areaInSqft) {
		this.areaInSqft = areaInSqft;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContactNo() {
		return ownerContactNo;
	}
	public void setOwnerContactNo(String ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}
	 @Override
	    public String toString() {
	        return this.propertyId + " " + this.noOfRooms + " "+ this.areaInSqft+" "+
	    this.floorNo+" "+this.city+" "+this.state+" "+this.cost+" "+this.ownerName+" "+
	        		this.ownerContactNo;
	    }
	

}


