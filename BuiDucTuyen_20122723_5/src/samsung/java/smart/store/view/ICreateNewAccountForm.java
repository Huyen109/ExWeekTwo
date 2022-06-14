package samsung.java.smart.store.view;

import java.awt.event.ActionListener;

public interface ICreateNewAccountForm {
	public String getNewUserName ();
	public String getNewPassword ();
	
	/**
	 * Set listener to creat button on form
	 * @param listener The ActionListener listens and handles the event when the user click on creat button   
	 */
	public void setActionListenerOnCreateButton(ActionListener a);
	
	/**
	 * Set listener to cancel button on form
	 * @param listener The ActionListener listens and handles the event when the user click on cancel button   
	 */
	public void setActionListenerOnCancelButton(ActionListener a);
	
	/** close form  */
	public void closeForm();
	/** get choose admin of user 
	 * 
	 * @return admin re turn '1' else return '0'
	 */
	public char getAdmin();
}
