package samsung.java.sensor.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddSensor extends JFrame{
	private JTextField sensorID, latitude, longitude;
	private JButton btAdd;
	
	/**
	 * Constructs the main windows of the Smart Store System
	 */
	public AddSensor(){
		JPanel pane = new JPanel(new GridLayout(4, 0));
		pane.add(new JLabel("SensorID:"));
		sensorID = new JTextField(15);
		pane.add(sensorID);
		
		pane.add(new JLabel("Latitude:"));
		latitude = new JTextField();
		pane.add(latitude);
		
		pane.add(new JLabel("Longitude:"));
		longitude = new JTextField();
		pane.add(longitude);
		
		JPanel pane1 = new JPanel();
		btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		pane1.add(btAdd);
		pane.add(pane1);
		
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(pane);
		//setSize(300, 100);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/** set rActionListenerBtAdd
	 * 
	 * @param e ActionListener
	 */
	public void setActionListenerBtAdd(ActionListener e){
		this.btAdd.addActionListener(e);
	}

	/**
	 * @return the latitude
	 */
	public JTextField getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(JTextField latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public JTextField getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(JTextField longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the sensorID
	 */
	public JTextField getSensorID() {
		return sensorID;
	}

	/**
	 * @param sensorID the sensorID to set
	 */
	public void setSensorID(JTextField sensorID) {
		this.sensorID = sensorID;
	}
}
