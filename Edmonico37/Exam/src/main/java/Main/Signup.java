package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.el.parser.AstString;

import java.util.ArrayList;

public class Signup {

	private String confpasswd;
	
	private ArrayList<String> list = new ArrayList<String>();
	
	public Signup(){
		
	}
	public void setInfo(String name, String firstname, String pseudo, String mail, String passwd, String birth,String confpasswd) {
		
		this.confpasswd = confpasswd;		
		this.list.add(name);
		this.list.add(firstname);
		this.list.add(pseudo);
		this.list.add(mail);
		this.list.add(passwd);
		this.list.add(birth);
	}
	public ArrayList<String> getInfo(){
		return this.list;
	}
	public String getConfpasswd() {
		return this.confpasswd;
	}
	
	public Boolean checked_existant() {
		try {
			ArrayList<String> checking = null;
			int count = 0;
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");
		    Statement st = con.createStatement();
		    
		    ResultSet result = st.executeQuery("SELECT name, firstname, pseudo_name, mail, passwd, birth FROM authentification;");

		    con.close();
		    if(count == 6) {
		    	System.out.print(true);
		    	return true;
		    } 
		    else{
		    	System.out.print(false);
		    	return false;
		    	
		    }
		    
		    
		} catch (Exception e) {
		    System.out.println("<p>Erreur lors de la récupération des données.</p>");
		    System.out.println(e.getMessage());
		}

		
		return false;
	}
	
	public void signup() {
		ArrayList<String> checked_list = new ArrayList<String>();
		checked_list = getInfo();
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");
	
		    System.out.println("Sign up is successful !"+checked_list.get(1));
		    String insertQuery = "INSERT INTO authentification (name, firstname, pseudo_name, mail, passwd, birth) VALUES (?, ?, ?, ?, ?, ?)";
		    PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		    preparedStatement.setString(1, checked_list.get(0));
		    preparedStatement.setString(2, checked_list.get(1));
		    preparedStatement.setString(3, checked_list.get(2));
		    preparedStatement.setString(4, checked_list.get(3));
		    preparedStatement.setString(5, checked_list.get(4));
		    preparedStatement.setString(6, checked_list.get(5));
		    preparedStatement.executeUpdate();
		    
		    con.close();
		} catch (Exception e) {
			System.out.println("<p>Erreur lors de l'inscription.</p>");
			System.out.println(e.getMessage());
		}
	}
	public void saveState() {
		ArrayList<String> checked_list = new ArrayList<String>();
		checked_list = getInfo();
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");
	
		    System.out.println("Sign up is successful !"+checked_list.get(1));
		    String insertQuery = "INSERT INTO authentification (name, firstname, pseudo_name, mail, passwd, birth) VALUES (?, ?, ?, ?, ?, ?)";
		    PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		    preparedStatement.setString(1, checked_list.get(0));
		    preparedStatement.setString(2, checked_list.get(1));
		    preparedStatement.setString(3, checked_list.get(2));
		    preparedStatement.setString(4, checked_list.get(3));
		    preparedStatement.setString(5, checked_list.get(4));
		    preparedStatement.setString(6, checked_list.get(5));
		    preparedStatement.executeUpdate();
		    
		    con.close();
		} catch (Exception e) {
			System.out.println("<p>Erreur lors de l'inscription.</p>");
			System.out.println(e.getMessage());
		}
	}
}
