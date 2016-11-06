/*
 *ParkingSpotDesing

  Let's design the parking lot
*/


package team7.myCsubParking.data;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


 // this has to be modified for every parking lot, so far i just made it for a generic one 
public class ParkingSpotDesign extends View
{

	private float topLeftX;
	// top left x position 
	private float topLeftY;
	// top right y position 
	private float botRightX;
	//bottom right x position
	private float botRightY;
	// bottom right y position 
	private boolean isAvail;
	// The question we all want to know
	private double Latitude;
	// gps coordinates 
	private double Longitude;
	
	private int spotID;
	
	private Paint linePaint;
	
	private Paint circlePaint;
	
	private Paint unAvailPaint;
	
	private float radius;
	
	private static final float THICKNESS = 10;
	
	public ParkingSpotDesign(Context ctx, float topLeftX, float topLeftY, float botRightX, float botRightY,
			
			float radius, boolean isAvail, double Latitude, double Longitude, int spotID, Activity parent)
	{
		super(ctx);
		this.topLeftX = topLeftX;
	    
	    this.topLeftY = topLeftY;
		
		this.botRightX = botRightX;
		
		this.botRightY = botRightY;
		
		this.isAvail = isAvail;
		
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		
		this.spotID = spotID;
		this.radius = radius;
		
		linePaint = new Paint(); // this is where every spot is mapped 
		linePaint.setStrokeWidth(THICKNESS); // the design of the lines 
		linePaint.setColor(Color.rgb(32, 12, 21)); // colors could match official csub colors 
		circlePaint = new Paint();
		
		circlePaint.setColor(Color.BLUE);
		unAvailPaint = new Paint();
		// this color sets the availability of the parking lot 
		unAvailPaint.setColor(Color.YELLOW);
		
		unAvailPaint.setStrokeWidth(THICKNESS);
		
		this.setMeasuredDimension((int)(botRightX - topLeftX), (int)(botRightY - topLeftY));
		
	}
	
	// a better design can be inplemented of the canvas 
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvas.drawLine(topLeftX, topLeftY, botRightX, topLeftY, linePaint);
		
		canvas.drawLine(topLeftX, topLeftY, topLeftX, botRightY, linePaint);
		
		canvas.drawLine(botRightX, topLeftY, botRightX, botRightY, linePaint);
		
		canvas.drawLine(topLeftX, botRightY, botRightX, botRightY, linePaint);
		
		if(isAvail)
			canvas.drawCircle( (topLeftX + botRightX) / 2, (topLeftY + botRightY) / 2, radius, circlePaint);
		else
		{
			canvas.drawLine(topLeftX, topLeftY, botRightX, botRightY, unAvailPaint);
			
			canvas.drawLine(botRightX, topLeftY, topLeftX, botRightY, unAvailPaint);
		}
		
	}
	
	public boolean isAvail()
	{
		return isAvail;
	}
	public double getLatitude()
	{
		return Latitude;
	}
	public double getLongitude()
	{
		return Longitude;
	}
	public int getSpotID()
	{
		return spotID;
	}
	
}