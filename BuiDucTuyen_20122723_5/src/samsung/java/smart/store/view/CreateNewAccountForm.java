package samsung.java.smart.store.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CreateNewAccountForm extends JFrame implements ICreateNewAccountForm {
	private JButton creatBt;
	private JButton cancel;
	private JTextField nameTf;
	private JPasswordField passPf;
	private char admin = '1';
	private JRadioButton yes;
	private JRadioButton no;
	
	public CreateNewAccountForm(){
		
		// Name and pass word
		JPanel pane1 = new JPanel(new GridLayout(2, 0));
		pane1.add(new JLabel("User name:")); 
		nameTf = new JTextField(20);
		pane1.add(nameTf);
		pane1.add(new JLabel("Pass word:"));
		passPf = new JPasswordField(20);
		pane1.add(passPf);
		
		//panel yes no
		JPanel tfPanel = new JPanel();
		tfPanel.setBorder(BorderFactory.createTitledBorder("Administrator account:"));
		yes = new JRadioButton("yes",true);
		tfPanel.add(yes);
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				admin = '1';
				// TODO Auto-generated method stub
				
			}
		});
		no = new JRadioButton("no",false);
		tfPanel.add(no);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				admin = '0';
				// TODO Auto-generated method stub
				
			}
		});
		
		ButtonGroup btnGp = new ButtonGroup();
		btnGp.add(yes);
		btnGp.add(no);
	
		JPanel pane2 = new JPanel(new GridLayout(0, 2));
		creatBt = new JButton("Creat");
		pane2.add(creatBt);
		cancel = new JButton("Cancel");	
		pane2.add(cancel);
		
		JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(pane1);
		pane.add(tfPanel);
		pane.add(pane2);

		
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(pane);
		//setSize(300, 100);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#getNewUserName()
	 */
	@Override
	public String getNewUserName() {
		// TODO Auto-generated method stub
		
		return nameTf.getText();
	}

	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#getNewPassword()
	 */
	@Override
	public String getNewPassword() {
		// TODO Auto-generated method stub
		return passPf.getText();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#getAdmin()
	 */
	@Override
	public char getAdmin() {
		// TODO Auto-generated method stub
		return admin;
	}

	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setActionListenerOnCreateButton(java.awt.event.ActionListener)
	 */
	@Override
	public void setActionListenerOnCreateButton(ActionListener a) {
		// TODO Auto-generated method stub
		creatBt.addActionListener(a);

	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setActionListenerOnCancelButton(java.awt.event.ActionListener)
	 */
	@Override
	public void setActionListenerOnCancelButton(ActionListener a) {
		// TODO Auto-generated method stub
		cancel.addActionListener(a);

	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#getNewPassword()
	 */
	public void closeForm(){
		super.dispose();
	}
}
