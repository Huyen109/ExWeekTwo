package samsung.java.sensor.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.print.attribute.standard.Severity;

import samsung.java.sensor.client.Sensor;


public class ServerController {
	private MainView mainView = new MainView();
	private StartServerForm startF = new StartServerForm();
	private ArrayList<Sensor> sensorList = new ArrayList<Sensor>();
	
	public ServerController(){
		startF.setStartButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//final MainView mainView = new MainView();
				int port = Integer.parseInt(startF.getServerPortOnStartForm());
				try(ServerSocket  socket = new ServerSocket(port)) {
					//System.out.print("ok");
					while(true){
						final Socket connSocket = socket.accept();
						Thread connect = new Thread(){
							public void run(){
								ObjectInputStream in;
								try {
									in = new ObjectInputStream(connSocket.getInputStream());
									sensorList.add((Sensor) in.readObject());
									sensorList.get(sensorList.size()-1).start();
									mainView.addSensor(sensorList.get(sensorList.size()-1).getSensorID());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						};
						connect.start();
					}
				

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mainView.setActionListenerCbSensorList(new ItemListener() {
					
					@Override
					public void itemStateChanged (ItemEvent e) {
								String ID = (String) mainView.getCbSensorList().getSelectedItem();
								mainView.displayValue(ID);
								mainView.setIDDisplay(ID);
								mainView.updateView();

					}
				});
				
			}
		});
	}

}
