package samsung.java.smart.store.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bui Trong Tung
 * The SignInForm class inheriting the JFrame displays the signing form 
 */
@SuppressWarnings("serial")
public class SignInForm extends JFrame implements ISignInForm {

	private JTextField tfUserName;
	private JPasswordField pwField;
	private JButton btnSignIn;
	private JButton btnCancel;
	
	/**
	 * Constructs the form for the user signs in
	 */
	public SignInForm(){
		
		this.tfUserName = new JTextField(15);
		this.pwField = new JPasswordField(15);
		this.btnSignIn = new JButton("Sign in");
		this.btnCancel = new JButton("Cancel");
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Close the Sign in window when the user cancels  
				Container frame = btnCancel.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
			
		});
		JLabel lbUserName = new JLabel("Username:");
		JLabel lbPassword = new JLabel("Password:");
		
/*		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lbUserName)
						.addComponent(lbPassword))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(tfUserName)
						.addComponent(pwField)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnSignIn)
								.addComponent(btnCancel))
						)
		);
		layout.linkSize(SwingConstants.HORIZONTAL, btnSignIn, btnCancel);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbUserName)
						.addComponent(tfUserName)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lbPassword)
						.addComponent(pwField)
				)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnSignIn)
						.addComponent(btnCancel)
				)
		);*/
		
		//Make panel for user enter data
		JPanel panel = new JPanel(new GridLayout(3, 2, 5, 2));
		
		panel.add(lbUserName);
		panel.add(tfUserName);		
		panel.add(lbPassword);
		panel.add(pwField);
		panel.add(btnSignIn);
		panel.add(btnCancel);
		
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
	 * @see samsung.java.smart.store.view.ISignInForm#setSignInButtonActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setSignInButtonActionListener(ActionListener listener){
		this.btnSignIn.addActionListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.ISignInForm#getUserNameOnSignInForm()
	 */
	@Override
	public String getUserNameOnSignInForm() {
		// TODO Auto-generated method stub
		return this.tfUserName.getText();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.ISignInForm#getPasswordOnSignInForm()
	 */
	@Override
	public String getPasswordOnSignInForm() {
		// TODO Auto-generated method stub
		return (new String (this.pwField.getPassword()));
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.ISignInForm#closeForm()
	 */
	@Override
	public void closeForm(){
		super.dispose();		
	}
}
