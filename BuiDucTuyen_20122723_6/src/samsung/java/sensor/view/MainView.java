package samsung.java.sensor.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Bui Duc Tuyen
 * The MainView extending JFrame displays the main view of the Sensor system
 */
public class MainView extends JFrame {
	private JButton btCreat;
	private JComboBox<String> cbSensorList;
	private JTable tbSensor;
	//private ArrayList<ArrayList<String>> list = new ArrayList<>();
	private Object[][] tableList = new Object[500][4];
	private JPanel pane = new JPanel(new BorderLayout());
	private JPanel panel1 = new JPanel();
	

	
	/**
	 * Constructs the main windows of the mainView
	 */
	public MainView(){
		// combobox
		panel1.add(new JLabel("Choose Sensor"));
		cbSensorList = new JComboBox<String>();
		btCreat = new JButton("Add new Sensor");
		panel1.add(cbSensorList);

		// table value
		JPanel panel2 = new JPanel();
		String[] columnNames = {"Time", "Date", "Temperature", "Humidity"};
		tbSensor = new JTable(tableList,columnNames);
		tbSensor.setPreferredScrollableViewportSize(new Dimension( 500,200));
		tbSensor.setFillsViewportHeight(true);
		JScrollPane cr = new JScrollPane(tbSensor);
		panel2.add(cr);
		
		
		pane.add(panel1,BorderLayout.NORTH);
		pane.add(panel2,BorderLayout.CENTER);
		pane.add(btCreat,BorderLayout.SOUTH);
		
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(pane);
		//setSize(300, 100);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	/** add item on combobox
	 * 
	 * @param ID new ID user enter
	 */
	public void addSensor(String ID){
		cbSensorList.addItem(ID);
		this.validate();
	}
	
	/** Display table
	 * 
	 * @param ID ID of sensor display
	 */
	public void displayValue(String ID){
		
		// read file 
		Path filePath = Paths.get(ID+".txt");
		Charset cs = Charset.forName("US-ASCII");
		try(BufferedReader rd = Files.newBufferedReader(filePath,cs))
		{
			String line;
			StringTokenizer tk;
			int i=0;
			while((line = rd.readLine())!= null){
				tk = new StringTokenizer(line,"|");
			//	list.add(new ArrayList<String>());
			    for(int j=0; j<4;j++) {
			    	String a = tk.nextToken();
			    	tableList[i][j] = a;
			//    	list.get(i).add(a);
			    }
			    i++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		this.validate();
		this.repaint();
	}
	/** update table
	 * 
	 * @param ID sensorID display
	 */
	public void updateView(final String ID){
		Thread updateThread = new Thread() {
			@Override
			public void run(){
			while(true){
			displayValue(ID);
			//repaint();
			try{
			sleep(10000);
			}catch(InterruptedException ignore) {}
			}
			}
		};
	}
	/** set ActionListenerBtCreat
	 * 
	 * @param e Action enter add button
	 */
	public void setActionListenerBtCreat(ActionListener e){
		this.btCreat.addActionListener(e);
	}
	/** set ActionListener cbsensor
	 * 
	 * @param e Action chosse combobox
	 */
	public void setActionListenerCbSensorList(ItemListener e){
		this.cbSensorList.addItemListener(e);
	}

	/**
	 * @return the cbSensorList
	 */
	public JComboBox<String> getCbSensorList() {
		return cbSensorList;
	}
	/**
	 * @param cbSensorList the cbSensorList to set
	 */
	public void setCbSensorList(JComboBox<String> cbSensorList) {
		this.cbSensorList = cbSensorList;
	}
	
}
