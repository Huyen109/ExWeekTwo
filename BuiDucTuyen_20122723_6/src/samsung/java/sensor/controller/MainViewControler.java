package samsung.java.sensor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;

import samsung.java.sensor.model.Sensor;
import samsung.java.sensor.view.AddSensor;
import samsung.java.sensor.view.MainView;

public class MainViewControler {
	private ArrayList<Sensor> sensor = new ArrayList<Sensor>();;
	private MainView mainView;

	/**
	 * Constructs the main windows of the mainView
	 */
	public MainViewControler(){
		mainView = new MainView();
		
		// set acction buttom add sensor
		mainView.setActionListenerBtCreat(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final AddSensor addSensor = new AddSensor();
				addSensor.setActionListenerBtAdd(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String sensorID = addSensor.getSensorID().getText();
						boolean check = true;
						for(int i=0; i<sensor.size();i++){
							if(sensor.get(i).getSensorID().compareTo(sensorID) == 0) {
								check = false;
								break;
							}
						}
						if(check){
							Float latitude = Float.parseFloat(addSensor.getLatitude().getText());
							Float longitude = Float.parseFloat(addSensor.getLongitude().getText());
							//sensor = new ArrayList<Sensor>();
							sensor.add(new Sensor(sensorID, latitude, longitude));
							sensor.get(sensor.size()-1).start();
							sensor.get(sensor.size()-1);
							mainView.addSensor(sensorID);
							JOptionPane.showMessageDialog(null, "Succseful!");
						}
						else JOptionPane.showMessageDialog(null, "Error!");
					}
				});
				
			}
		}); 
		
		// set Action combobox
		mainView.setActionListenerCbSensorList(new ItemListener() {
			
			@Override
			public void itemStateChanged (ItemEvent e) {
						String ID = (String) mainView.getCbSensorList().getSelectedItem();
						mainView.displayValue(ID);
						mainView.updateView(ID);

			}
		});
	}
	
}
