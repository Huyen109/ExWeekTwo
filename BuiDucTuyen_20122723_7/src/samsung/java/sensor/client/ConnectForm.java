package samsung.java.sensor.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class ConnectForm extends JFrame{

	private JTextField tfServerAddress;
	private JTextField tfServerPort;
	private JButton btnConnect;
	private JButton btnQuit;
	
	/**
	 * Constructs the form for the user signs in
	 */
	public ConnectForm(){
		
		this.tfServerAddress = new JTextField(15);
		this.tfServerPort = new JTextField(15);
		this.btnConnect = new JButton("Connect");
		this.btnQuit = new JButton("Quit");
		
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
		JLabel lbServerAddress = new JLabel("Server Address:");
		JLabel lbServerPort = new JLabel("Server Port:");
		

		
		//Make panel for user enter data
		JPanel panel = new JPanel(new GridLayout(3, 2, 5, 2));
		
		panel.add(lbServerAddress);
		panel.add(tfServerAddress);		
		panel.add(lbServerPort);
		panel.add(tfServerPort);
		panel.add(btnConnect);
		panel.add(btnQuit);
		
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(panel);
		
		setTitle("Sign in");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IConnectForm#setSignInButtonActionListener(java.awt.event.ActionListener)
	 */
	public void setConnectButtonActionListener(ActionListener listener){
		this.btnConnect.addActionListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IConnectForm#getUserNameOnConnectForm()
	 */
	public String getServerAddressOnConnectForm() {
		// TODO Auto-generated method stub
		return this.tfServerAddress.getText();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IConnectForm#getPasswordOnConnectForm()
	 */
	public String getServerPortOnConnectForm() {
		// TODO Auto-generated method stub
		return (new String (this.tfServerPort.getText()));
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IConnectFormForm#closeForm()
	 */
	public void closeForm(){
		super.dispose();		
	}
}
