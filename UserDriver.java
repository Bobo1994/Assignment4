/**
 * 
 *@author Yibing Zhang
 *Date 11/1/2015
 */
public class UserDriver {

	public static void main(String[] args) {
		User user =new User();
        		
		System.out.println(user.toString());
		user.setUsername("csc");//set username
		user.setPassword("1231");//set password
		user.setAccountType(accountType.administrator);//set accounttype
		System.out.println(user.toString());
	}

}
