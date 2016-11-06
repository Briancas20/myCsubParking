/*
 * User.java
 * 4/16/14
 * myCsub Parking
 * 
 *
 * This class stores data about a user and furthermore. 
 */
package team7.myCsubParking.data;

import org.json.JSONObject;

import team1.parkingapp.rest.ValContract;
import android.util.Log;

public class User {
	public final static int PASSWORD_LENGTH_MIN = 4;
	
	private int uID;	//the users ID
	
	private String uEmail;				
	// User's email address
	
	private String uPassword;			
	//Password for the user
	
	private String uName;				
	//First name of the user
	
	private String uLastName;			
	//Last name of the user 
	
	private Reservation reservation;	
	// Current reservation
	
	private String role;				
	// User's Role
	
	//let's construc the user
	public User(int uID, String uEmail, String uPassword, String uName, String uLastName, String role) {
		this.uID = uID;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uLastName = uLastName;
		this.reservation = null;
		this.role = role;
	}
	
	
	 //Takes in a JSONObject containing user data and creates a user object from it.
	 
	//If any of the fields are null, default data is used.
	 
	public static User validateJSONData(JSONObject json) {
		int uID;
		String uEmail, uPassword, uName, uLastName, role;

		Log.i("Creating User from JSON", json.toString());
		
		if (json.has(ValContract.ERROR))
			return null;
		
		try {
			uID = json.getInt(ValContract.USER_ID);
		}
		catch (Exception e) {
			uID = -1;
		}	
		try {
			uEmail = json.getString(ValContract.USER_EMAIL);
		}
		catch (Exception e){
			uEmail = "";
		}
		try {
			uPassword = json.getString(ValContract.USER_PASSWORD);
		}
		catch (Exception e) {
			uPassword = "";
		}		
		try {
			uName = json.getString(ValContract.USER_PASSWORD);
		}
		catch (Exception e) {
			uName = "";
		}		
		try {
			uLastName = json.getString(ValContract.USER_LASTNAME);
		}
		catch (Exception e) {
			uLastName = "";
		}
		try {
			uLastName = json.getString(ValContract.USER_LASTNAME);
		}
		catch (Exception e) {
			uLastName = "";
		}
		try
		{
			role = json.getString(ValContract.USER_ROLE);
		}
		catch (Exception e)
		{
			role = "";
		}
		
		return new User(uID, uEmail, uPassword, uName, uLastName, role);
	}

	/*
	 * Mutators and accesors will follow
	 */
	public String getRole()
	{
		return role;
	}
	public String getEmail() {
		return uEmail;
	}

	public int getId() {
		return uID;
	}

	public void setId(int id) {
		this.uID = uID;
	}

	public void setEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getPassword() {
		return uPassword;
	}

	public void setPassword(String password) {
		this.uPassword = uPassword;
	}

	public String getName() {
		return uName;
	}

	public void setName(String name) {
		this.uName = uName;
	}

	public String getLastName() {
		return uLastName;
	}

	public void setLastName(String lastName) {
		this.uLastName = uLastName;
	}
	
	public String getFullName() {
		return this.uName + " " + this.uLastName;
	}
  
  // reservation can change to spot hold
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}