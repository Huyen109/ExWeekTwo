package samsung.java.sensor.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bui Trong Tung
 * The ConnectFormForm class inheriting the JFrame displays the signing form 
 */
@SuppressWarnings("serial")
public class StartForm extends JFrame{

	private JTextField tfSensorID;
	private JTextField tfSensorAddress;
	private JTextField tfLatitude;
	private JTextField tfLongtitude;
	private JButton btnStart;
	private JButton btnQuit;
	private JButton btnStop;

	
	/**
	 * Constructs the form for the user signs in
	 */
	public StartForm(){
		
		this.tfSensorID = new JTextField(15);
		this.tfSensorAddress = new JTextField(15);
		this.tfLatitude = new JTextField(15);
		this.tfLongtitude = new JTextField(15);
		this.btnStart = new JButton("Start");
		this.btnQuit = new JButton("Quit");
		this.btnStop = new JButton("Stop");
		
		btnQuit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Close the Sign in window when the user cancels  
				Container frame = btnQuit.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
			
		});
		JLabel lbSensorID = new JLabel("Sensor ID:");
		JLabel lbSensorAddress = new JLabel("Sensor Address:");
		JLabel lbLatitude = new JLabel("Latitude:");
		JLabel lbLongtitude = new JLabel("Longtitude:");
		
/*		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lbUserName)
						.addComponent(lbPassword))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(tfSensorID)
						.addComponent(tfSensorAddress)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnStart)
								.addComponent(btnQuit))
						)
		);
		layout.linkSize(SwingConstants.HORIZONTAL, btnStart, btnQuit);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbUserName)
						.addComponent(tfSensorID)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbPassword)
						.addComponent(tfSensorAddress)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnQuit)
				)
		);*/
		
		//Make panel for user enter data
		JPanel panel = new JPanel(new GridLayout(4, 2, 5, 2));
		JPanel panel2 = new JPanel();
		
		panel.add(lbSensorID);
		panel.add(tfSensorID);		
		panel.add(lbSensorAddress);
		panel.add(tfSensorAddress);
		panel.add(lbLatitude);
		panel.add(tfLatitude);
		panel.add(lbLongtitude);
		panel.add(tfLongtitude);
		
		panel2.add(btnStart);
		panel2.add(btnStop);
		panel2.add(btnQuit);
		
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(panel);
		cp.add(panel2);
		
		setTitle("Start");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartForm#setSignInButtonActionListener(java.awt.event.ActionListener)
	 */
	public void setStartButtonActionListener(ActionListener listener){
		this.btnStart.addActionListener(listener);
	}
	
	public void setStopButtonActionListener(ActionListener listener){
		this.btnStop.addActionListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartForm#getUserNameOnStartForm()
	 */
	public String getSensorIDOnStartForm() {
		// TODO Auto-generated method stub
		return this.tfSensorID.getText();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartForm#getPasswordOnStartForm()
	 */
	public String getSensorAddressOnStartForm() {
		// TODO Auto-generated method stub
		return (new String (this.tfSensorAddress.getText()));
	}
	
	public String getLatitudeOnStartForm() {
		// TODO Auto-generated method stub
		return this.tfLatitude.getText();
	}
	
	public String getLongtitudeOnStartForm() {
		// TODO Auto-generated method stub
		return this.tfLongtitude.getText();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartFormForm#closeForm()
	 */
	public void closeForm(){
		super.dispose();		
	}
}
