package samsung.java.sensor.model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

public class Sensor extends Thread{
	private String sensorID;
	private float latitude;
	private float longitude;
	private Date date ;
	

	/** Constructs the main windows of the sensor
	 * 
	 * @param sensorID the sensorID
	 * @param latitude the latitude of sensor
	 * @param longitude the longitude of sensor
	 */
	 
	public Sensor(String sensorID, float latitude, float longitude){
		this.sensorID = sensorID;
		this.latitude = latitude;
		this.longitude =  longitude;
	}
	/** write on file
	 * 
	 */
	public void run(){
		Random rd = new Random();
		while(true){
			date = new Date();
			String time = String.valueOf(date.getHours()) + ':' + String.valueOf(date.getMinutes()) + ':' +String.valueOf(date.getSeconds());
			String day = String.valueOf(date.getDate()) + '/' + String.valueOf(date.getMonth()+1) + '/' + String.valueOf(date.getYear()+1900);
			float temperature = 50 - rd.nextFloat()*100;
			try(PrintWriter writer  = new PrintWriter(new FileWriter(sensorID+".txt",true),true)){
				writer.println(time + "|" + day + "|" + temperature + "|" + rd.nextFloat()*100);
				writer.close();
			}
			catch(FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}
			int random = rd.nextInt(10)*1000;
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * @return the senSorID
	 */
	public String getSensorID() {
		return sensorID;
	}

	/**
	 * @param senSorID the senSorID to set
	 */
	public void setsensorID(String senSorID) {
		this.sensorID = senSorID;
	}

	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
}
