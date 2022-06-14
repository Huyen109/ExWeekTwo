package samsung.java.smart.store.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import samsung.java.smart.store.view.CreateNewAccountForm;
import samsung.java.smart.store.view.ICreateNewAccountForm;

public class CreateAccountController {
	ICreateNewAccountForm creat;
	public CreateAccountController(){
		creat = new CreateNewAccountForm();
		creat.setActionListenerOnCancelButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creat.closeForm();
				// TODO Auto-generated method stub
				
			}
		});
		creat.setActionListenerOnCreateButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = creat.getNewUserName();
				String pass = creat.getNewPassword();
				
				// check name and pass word
				boolean checkpass = false;
				boolean checkName = false ;
				for (int i = 0; i < name.length(); i++) {
					if(name.charAt(i)==' ') {
						checkName = true;
						break;
					}
				}
				for (int j = 0; j< pass.length(); j++) {
						if(pass.charAt(j)==' ') {
					    checkpass = true;
							break;
						}		
				}
				
				// dialog error
				if(name.length()==0||pass.length() ==0||checkName||checkpass){
					JOptionPane.showMessageDialog(null, "error!");
				}
				
				// write on file text
				else{
					try(PrintWriter writer  = new PrintWriter(new FileWriter("D:\\Samsung\\SS\\acc.txt",true))){
						writer.println(name+" "+pass+" "+ creat.getAdmin());
						writer.close();
						}catch(FileNotFoundException e){
						System.out.println(e.getMessage());
						}catch(IOException e){
						System.out.println(e.getMessage());
						}
					}
				}
		});
	}
}
