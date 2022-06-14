package samsung.java.sensor.server;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bui Trong Tung
 * The StartFormForm class inheriting the JFrame displays the signing form 
 */
@SuppressWarnings("serial")
public class StartServerForm extends JFrame{

	private JTextField tfServerPort;
	private JButton btnStart;
	private JButton btnStop;
	
	/**
	 * Constructs the form for the user signs in
	 */
	public StartServerForm(){
		

		this.tfServerPort = new JTextField(15);
		this.btnStart = new JButton("Start");
		this.btnStop = new JButton("Stop");
		
		btnStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Close the Sign in window when the user cancels  
				Container frame = btnStop.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
			
		});
		JLabel lbServerAddress = new JLabel("Server Address:");
		JLabel lbServerPort = new JLabel("Server Port:");
		
/*		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lbUserName)
						.addComponent(lbPassword))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(tfServerAddress)
						.addComponent(tfServerPort)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnStart)
								.addComponent(btnStop))
						)
		);
		layout.linkSize(SwingConstants.HORIZONTAL, btnStart, btnStop);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbUserName)
						.addComponent(tfServerAddress)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbPassword)
						.addComponent(tfServerPort)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnStop)
				)
		);*/
		
		//Make panel for user enter data
		JPanel panel = new JPanel(new GridLayout(2, 2, 5, 2));
	
		panel.add(lbServerPort);
		panel.add(tfServerPort);
		panel.add(btnStart);
		panel.add(btnStop);
		
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
	 * @see samsung.java.smart.store.view.IStartForm#setSignInButtonActionListener(java.awt.event.ActionListener)
	 */
	public void setStartButtonActionListener(ActionListener listener){
		this.btnStart.addActionListener(listener);
	}
	
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartForm#getPasswordOnStartForm()
	 */
	public String getServerPortOnStartForm() {
		// TODO Auto-generated method stub
		return (new String (this.tfServerPort.getText()));
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IStartFormForm#closeForm()
	 */
	public void closeForm(){
		super.dispose();		
	}
}
