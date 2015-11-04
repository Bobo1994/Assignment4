import java.awt.Color;
import java.util.Collections;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *The class is based on the user class and main method, extended to application to use javafx to ask user to sign up for an account 
 * @author Yibing
 * The program is for assignment 4
 * Date 11/1/2015
 */
public class UserDriver2 extends Application{

/**
 * 	
 * This is a main method
 * @param args arguments to luanch the javagx
 * The class uses main method to run the program
 */
	
	public static void main(String[] args) {
		launch(args);//must have(gitbash doesnt need to)

	}
	
	@Override
	/**
	 * The program uses start method to set primary Stage
	 *Creates the frame and take input from users
	 *@param username
	 *@param passowrd
	 *@param first name
	 *@param last name
	 *@return user.toString
	 */
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Sign Up Page");
		Button btn=new Button("Submit");
		Label label0= new Label();
		//error label(set visible)
		Label label1= new Label("First name");
		Label label2= new Label("Last name");
		Label label3 =new Label("User name");
		Label label4 =new Label("Password");
		Label label5 =new Label("Confirm password");
		Label label6= new Label("Email address");
		Label label7 =new Label("Select your account type");
		TextField nameTextfield= new TextField();
		TextField lastNameTextfield =new TextField();
		TextField userNameTextfield= new TextField();
		TextField emailTextfield= new TextField();
		PasswordField pwfield= new PasswordField();
		PasswordField pwfield2= new PasswordField();
		ComboBox accountypebox= new ComboBox();
		accountypebox.getItems().addAll(accountType.values());//add textfields,passwordfields and ComboBox
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
		String name,lastName,username,email,password,password2;
		String patternemail="\\w+@\\w+\\.\\w+";
		String patternpassword="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\!`<>?\"'#$%^&*()-+=,./:;@\\[\\]_?{|}~])(?=\\S+$).{8,64}";
		boolean status=false,status2=false,status3=false,status4=false,status5=false,status6=false;
		
		@Override
		/*
		 * Ask users to input password,username,password things
		 * @see javafx.event.EventHandler#handle(javafx.event.Event)
		 */
		public void handle(ActionEvent event) {
		name= nameTextfield.getText();
		lastName= lastNameTextfield.getText();
		username=userNameTextfield.getText();
		password= pwfield.getText();
		password2= pwfield2.getText();
		email= emailTextfield.getText();
		
		accountType selected = (accountType)accountypebox.getValue();
		status=validate(nameTextfield);
		status2=validate(lastNameTextfield);
		status3=validate(userNameTextfield);
		status4=validate(emailTextfield);
		status5=validate(pwfield);
		status6=validate(pwfield2);//check for blanks
		/*
		 *The folloing logic is using if else if else if  else java statement
		 *If the statement is false, the label with red words"cannot be blank" will show up
		 *Else if password and confirm password are not equal, the label with red words "Passwords should be the same"
		 *Else if passwords and email match the format, the program will print congratulations and detailed information(JOptionPane and System.out.print)
		 *Otherwise, the program will print wrong format(JOptionPane)
		 */
		
		if(status==false||status2==false||status3==false||status4==false||status5==false||status6==false)//check blanks, if there are blanks, label0 shows up with text "cannot be blank"
				{label0.setText("The specific fields cannot be balnk");
				label0.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
				nameTextfield.setEditable(false);
				lastNameTextfield.setEditable(false);
				userNameTextfield.setEditable(false);
				emailTextfield.setEditable(false);
				pwfield.setEditable(false);
				pwfield2.setEditable(false);//set fields not editable
				}
		else if(!password.equals(password2))//(no blanks)if passwords are not the  same, label0 shows up with text"passowrds should be the same" in red
		{	label0.setText("Password and confirm password should be the same");
			label0.setTextFill(javafx.scene.paint.Color.web("#FF0000"));
			nameTextfield.setEditable(false);
			lastNameTextfield.setEditable(false);
			userNameTextfield.setEditable(false);
			emailTextfield.setEditable(false);
			pwfield.setEditable(false);
			pwfield2.setEditable(false);}
		else if(password.matches(patternpassword)&&email.matches(patternemail))//(no blanks and passwords are the same),if password and email matches format, print congratulations 
		{	JOptionPane.showMessageDialog(null,"Congratulations, your account has been created!");
			User user=new User();
			username=username.toLowerCase();
			user.setUsername(username);
			user.setPassword(password);
			user.setAccountType(selected);
			System.out.println("Hello "+name+lastName+"\nYour email address is "+email+"\n"+user.toString());
			//System.out.println("Hello, "+name+" "+lastName+"\nYour email address is"+email +"Your user name is "+username+"\nYour password is "+password+"\nYour account type is "+selected.toString());
		}else//(no blanks and passwords are the same) password or email do not match formats, print invalid format
		{	JOptionPane.showMessageDialog(null, "Invalid password format or email format");
		}
		}	
		
		});
		
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(20);
		grid.setHgap(20);
		grid.add(label0, 0, 0);
		grid.add(label1, 0, 1);
		grid.add(label2, 0, 2);
		grid.add(label3, 0, 3);
		grid.add(label4, 0, 4);
		grid.add(label5, 0, 5);
		grid.add(label6, 0, 6);
		grid.add(label7, 0, 7);
		grid.add(nameTextfield,1,1);
		grid.add(lastNameTextfield,1,2);
		grid.add(userNameTextfield,1,3);
		grid.add(pwfield,1, 4);
		grid.add(pwfield2,1, 5);
		grid.add(emailTextfield,1,6);
		grid.add(accountypebox,1,7);
		grid.add(btn, 1,8);
		Scene scene =new Scene(grid,900,900);
		scene.getStylesheets().add(getClass().getResource("JavaFx.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private boolean validate(TextField tf){
		boolean pass=false;
		ObservableList<String> styleClass=tf.getStyleClass();
		if(tf.getText().trim().length()==0)
		{if(!styleClass.contains("error")){
			styleClass.add("error");
			
		}
		}else{
			styleClass.removeAll(Collections.singleton("error"));
			pass=true;
		}return pass;
		
		
	}
}
