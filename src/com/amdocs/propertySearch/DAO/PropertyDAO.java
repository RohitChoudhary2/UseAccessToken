package com.amdocs.propertySearch.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.propertySearch.model.Property;

public class PropertyDAO {

	public int addProperty(Property property) {
		// TODO Auto-generated method stub
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		int count=0;
		try {
		PreparedStatement ps=c.prepareStatement("insert into properties values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,property.getPropertyId());
		 ps.setString(2,property.getNoOfRooms());
		 ps.setDouble(3,property.getareaInSqft());
		 ps.setInt(4,property.getFloorNo());
		 ps.setString(5,property.getCity());
		 ps.setString(6, property.getState());
		 ps.setDouble(7,property.getCost());
		 ps.setString(8,property.getOwnerName());
		 ps.setString(9,property.getOwnerContactNo());
		 
		 count=ps.executeUpdate();
	}
	catch(Exception e) {System.out.println("e");}
		return count;
	}
	public  boolean updatePropertyCost(int id, double newCost) {
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		int count=0;
		PreparedStatement ps;
		try {
			ps=c.prepareStatement("Update Properties Set cost=? where propertyId=?");
			ps.setDouble(1, newCost);
			ps.setInt(2,id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;}
	
	public int deleteProperty(int propertyId) {
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		int count=0;
		try {
			PreparedStatement ps=c.prepareStatement("Delete from Properties where PropertyId="+propertyId);
			count=ps.executeUpdate();		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return count;
	}
	
	public List<Property> searchByCity(String city){
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		List<Property> p=new ArrayList<>();
		int count=0;PreparedStatement ps;
		try {
			ps=c.prepareStatement("select * from properties where city=?");
			ps.setString(1, city);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Property pr=new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(pr);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return p;
		}
	
	public List<Property> findAllProperties(){
	DBConnection dbc = new DBConnection();
	Connection c=dbc.getConnection();
	List<Property> p=new ArrayList<>();
	PreparedStatement ps;
	try {
		ps=c.prepareStatement("select * from properties");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Property p3=new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(p3);	}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	return p;
	
	
	}
	public List<Property> searchByCost(Double cost1,double cost2){
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		List<Property> p=new ArrayList<>();
		int count=0;PreparedStatement ps;
		try {
			ps=c.prepareStatement("select * from properties where cost between ? and ?");
			ps.setDouble(1, cost1);
			ps.setDouble(2, cost2);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Property pr=new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(pr);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return p;
		}
	public List<Property> searchByCost(String rooms,String city){
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		List<Property> p=new ArrayList<>();
		int count=0;PreparedStatement ps;
		try {
			ps=c.prepareStatement("select * from properties where noofrooms=? and city=?");
			ps.setString(1, rooms);
			ps.setString(2,city);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Property pr=new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(pr);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return p;
		}
	public List<Property> findByRoomsAndCity(String rooms,String city){
		DBConnection dbc = new DBConnection();
		Connection c=dbc.getConnection();
		List<Property> p=new ArrayList<>();
		int count=0;PreparedStatement ps;
		try {
			ps=c.prepareStatement("select * from properties where noofrooms=? and city=?");
			ps.setString(1, rooms);
			ps.setString(2,city);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Property pr=new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(pr);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return p;
		}
}

	


