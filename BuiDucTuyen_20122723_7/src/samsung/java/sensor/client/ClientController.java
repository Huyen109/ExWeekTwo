package samsung.java.sensor.client;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientController {
	ConnectForm conect =new ConnectForm();
	
	public ClientController() {
		// TODO Auto-generated constructor stub
		conect.setConnectButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
						try(Socket clientSocket = new Socket(conect.getServerAddressOnConnectForm(), 5000);
								ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())){
							final StartForm startF = new StartForm();
							startF.setStartButtonActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									Float latitude = Float.parseFloat(startF.getLatitudeOnStartForm());
									Float longitude = Float.parseFloat(startF.getLongtitudeOnStartForm());
									Sensor sensor = new Sensor(startF.getSensorIDOnStartForm(), latitude, longitude);
									try {
										out.writeObject(sensor);
										out.flush();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}
							});
							
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Erorr! Can not connect");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Erorr! Can not connect");
						}

			}
		});
		
	}
	
		
}
