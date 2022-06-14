package samsung.java.sensor.client;

import java.io.Serializable;

public class Information implements Serializable {
	private String sensorID;
	private String sensorAddress;
	private float temperature;
	private float humidity;
	private String time;
	private String day;
	
	
	
	public Information(String sensorID,String sensorAddress,float temperature,float humidity,String time,String day){
		this.sensorID = sensorID;
		this.sensorAddress = sensorAddress;
		this.temperature =temperature;
		this.humidity = humidity;
		this.time = time;
		this.day = day;
	}
	/**
	 * @return the sensorID
	 */
	public String getSensorID() {
		return sensorID;
	}
	/**
	 * @param sensorID the sensorID to set
	 */
	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}
	/**
	 * @return the sensorAddress
	 */
	public String getSensorAddress() {
		return sensorAddress;
	}
	/**
	 * @param sensorAddress the sensorAddress to set
	 */
	public void setSensorAddress(String sensorAddress) {
		this.sensorAddress = sensorAddress;
	}
	/**
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
}
