
import javax.swing.JOptionPane;

public class User {


	String username;
	String password;
	accountType account;
	public User(){
		username="CSC200";
		password="12313";
		account=accountType.guest;
	}
	public User(String name, String password,accountType account){
		this.username=name;
		this.password=password;
		
		this.account=account;
	}


	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public accountType getAccountType(){
		return this.account;
	}
	public void setAccountType(accountType account){
		this.account=account;
	}
	public String toString(){
		return "The account type is "+account+"\nThe username is "+username+"\nThe password is "+password;
		}
	
	
}
