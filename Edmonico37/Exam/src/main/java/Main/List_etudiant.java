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
import java.util.ArrayList;


public class List_etudiant {
	private ArrayList<String> nom = new ArrayList<>();
	private ArrayList<String> prenom  = new ArrayList<>();
	private ArrayList<String> dateNaissance =  new ArrayList<>();
	private ArrayList<String> mail =  new ArrayList<>();
	
	public void setEtudiant() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");
	        Statement st = con.createStatement();

	        ResultSet result = st.executeQuery("SELECT Nom, Prenom, DateNaissance, Email FROM Etudiants");
	        while (result.next()) {
	            this.nom.add(result.getString("Nom"));
	            this.prenom.add(result.getString("Prenom"));
	            this.dateNaissance.add(result.getString("DateNaissance"));
	            this.mail.add(result.getString("Email")); // Corrected column name
	        }

	        con.close();
	    } catch (Exception e) {
	        System.out.println("<p>Erreur lors de la récupération des données.</p>");
	        System.out.println(e.getMessage());
	    }
	}

	public ArrayList<String> getNomEtudiant() {
	    return this.nom;
	}

	public ArrayList<String> getPrenomEtudiant() {
	    return this.prenom;
	}

	public ArrayList<String> getDateNaissanceEtudiant() {
	    return this.dateNaissance;
	}

	public ArrayList<String> getMailEtudiant() {
	    return this.mail;
	}
}
