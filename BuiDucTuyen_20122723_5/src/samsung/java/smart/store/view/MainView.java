package samsung.java.smart.store.view;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import samsung.java.smart.store.model.IProduct;
import samsung.java.smart.store.model.IProductList;


import samsung.java.smart.store.model.ProductList;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Bui Trong Tung
 * The MainView extending JFrame displays the main view of the Smart Store System. This class imple
 */
@SuppressWarnings("serial")
public class MainView extends JFrame implements IMainView {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu exist;
	private JMenuItem createAccountItem;
	private JMenuItem signOutMenu;
	
	private JButton chooseBt;
	private JPanel pane;
	String[] nameController = { "Product ID", "Product Name", "Amount"};
	Object[][] data = new Object[20][3];
	JTable table;
	
	/**
	 * Constructs the main windows of the Smart Store System
	 */
	public MainView(){

		menuBar = new JMenuBar();
		
		//Product menu
		menu = new JMenu("Products");
		menu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(menu);
		
		//Account menu
		menu = new JMenu("Account");
		menu.setMnemonic(KeyEvent.VK_A);
		
		signOutMenu = new JMenuItem("Sign out", KeyEvent.VK_S);
		menu.add(signOutMenu);
		menuBar.add(menu);
		
		//Exit menu
		exist = new JMenu("Exit");
		exist.setMnemonic(KeyEvent.VK_E);
		exist.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar.add(exist);
		
		setJMenuBar(menuBar);
		
		pane = new JPanel(new BorderLayout());
		table = new JTable(data,nameController);
		table.setPreferredScrollableViewportSize(new Dimension( 500,200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollpane = new JScrollPane(table);
		pane.add(scrollpane, BorderLayout.NORTH);
		
		chooseBt = new JButton("Choose data file");
		pane.add(chooseBt, BorderLayout.SOUTH);
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(pane);
		//add(pane);
		
		setTitle("Smart Store");
		setSize(550, 330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#addAdminMenuItem()
	 */
	@Override
	public void addCreateAccountMenu(){
		createAccountItem = new JMenuItem("Create new account", KeyEvent.VK_C);
		menu = menuBar.getMenu(1);
		menu.add(createAccountItem);
		this.validate();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setAdminItemActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setCreateAccountActionListener(ActionListener listener){
		this.createAccountItem.addActionListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setSignOutActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setSignOutActionListener(ActionListener listener) {
		this.signOutMenu.addActionListener(listener);
	}
	@Override
	public void setChooseBtActionListener(ActionListener listener){
		this.chooseBt.addActionListener(listener);
	}
	@Override
	public void displayProduct(String filePath){
		ProductList pd = new ProductList(filePath);
		IProduct[] product = pd.getList();


		for(int i =0; i<pd.getnumberOfProduct();i++){
			data[i][0] = product[i].getID();
			data[i][1] = product[i].getName();
			data[i][2] = product[i].getAmount();
		}
		table = new JTable(data,nameController);
		table.setPreferredScrollableViewportSize(new Dimension( 500,200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollpane = new JScrollPane(table);
		pane.add(scrollpane, BorderLayout.NORTH);
		revalidate();
		repaint();

	}
	@Override
	public void closeForm() {
		super.dispose();
	}
}
