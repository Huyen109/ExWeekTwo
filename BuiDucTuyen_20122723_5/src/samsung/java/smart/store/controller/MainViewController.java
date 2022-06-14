package samsung.java.smart.store.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import samsung.java.smart.store.view.IMainView;
import samsung.java.smart.store.view.MainView;

/**
 * @author Bui Trong Tung
 *The class MainViewController controls the main windows of the Smart Store application
 */
public class MainViewController {
	private IMainView mainWindow;
	
	/**
	 * The constructor
	 */
	public MainViewController(){
		mainWindow = new MainView();
		mainWindow.setSignOutActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				mainWindow.closeForm();
				SignInController signIn = new SignInController();
			}			
		});
		mainWindow.setChooseBtActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JFrame frame = new JFrame();
				final JFileChooser choose = new JFileChooser();
				frame.add(choose);
				frame.pack();
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				choose.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						frame.dispose();
						mainWindow.displayProduct(choose.getSelectedFile().getPath());
					}
				});
				
				
			}
		});
	}
	
	/**
	 * Change the main window if the user has administrator permission
	 */
	public void setAdminView(){
		mainWindow.addCreateAccountMenu();
		mainWindow.setCreateAccountActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CreateAccountController cteat = new CreateAccountController();
				
			}			
		});
	}
}
