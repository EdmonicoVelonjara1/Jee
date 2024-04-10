package Main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

import org.apache.el.parser.AstString;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object nom_etd;
//	private static final Statement ConnectBdd = null;
      
    
    public Main() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("SALAMA ").append(request.getContextPath());
        response.setContentType("text/html");
        List_etudiant etud = new List_etudiant();
        PrintWriter out = response.getWriter();
        ArrayList<String> nom_etud = new ArrayList<>();
        ArrayList<String> prenom_etud = new ArrayList<>();
        ArrayList<String> naissance_etud = new ArrayList<String>();
        ArrayList<String> mail_etud = new ArrayList<>();

        etud.setEtudiant();
        nom_etud = etud.getNomEtudiant();
        prenom_etud = etud.getPrenomEtudiant();
        naissance_etud = etud.getDateNaissanceEtudiant();
        mail_etud = etud.getMailEtudiant();
       
        request.setAttribute("nom_etud", nom_etud);
        request.setAttribute("prenom_etud", prenom_etud);
        request.setAttribute("naissance_etud", naissance_etud);
        request.setAttribute("mail_etud", mail_etud);
        request.getRequestDispatcher("/checkingTable.jsp").forward(request,response);
      
    }
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			
	}

}


