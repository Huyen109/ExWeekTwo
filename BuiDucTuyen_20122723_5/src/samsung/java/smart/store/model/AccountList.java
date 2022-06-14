package samsung.java.smart.store.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * @author Bui Trong Tung
 * The AccountList class implementing IAccountList contains the accounts of the Smart Store application
 */
public class AccountList implements IAccountList {
	private IAccount[] userList;
	private int numberOfAccount;
	
	/**
	 * Construct a AccountList containing account data by reading from text file
	 */
	public AccountList(){
		this.userList = new Account[10];
		Path filePath = Paths.get(IAccountList.ACCOUNT_FILE);
		numberOfAccount = 0;
		Charset cs = Charset.forName("US-ASCII");
		try(BufferedReader rd = Files.newBufferedReader(filePath,cs))
		{
			String line, userID, password;
			int permission;
			StringTokenizer tk;
			while((line = rd.readLine())!= null){
				tk = new StringTokenizer(line);
				userID = tk.nextToken();
				password = tk.nextToken();
				permission = Integer.parseInt(tk.nextToken());
				userList[numberOfAccount] = new Account(userID, password, permission);
				numberOfAccount ++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IAccountList#addAccount(samsung.java.smart.store.model.IAccount)
	 */
	@Override
	public void addAccount(IAccount acc){
		userList[numberOfAccount] = acc;
		numberOfAccount++;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IAccountList#find(samsung.java.smart.store.model.IAccount)
	 */
	@Override
	public int check(String name, String password){
		int found = -1;
		for(int i = 0; i < numberOfAccount; i++)
			if((name.compareToIgnoreCase(userList[i].getID()) == 0)&&
				password.compareTo(userList[i].getPassword()) == 0){				
				found = userList[i].getPermission();
				break;
			}		
		return found;
	}
}
