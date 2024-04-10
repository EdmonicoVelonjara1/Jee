package Exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Servlet implementation class RecChecking
 */
public class RecChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
    public RecChecking() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        HttpSession session= request.getSession();
        
        // Récupération des attributs de session
        ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");
        ArrayList<Integer> module = (ArrayList<Integer>) session.getAttribute("module");
        Integer taille = (Integer) session.getAttribute("taille");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8", "edmonico", "nico");

            // Parcourir les données du formulaire et les insérer dans la base de données
            for (int i = 0; i < taille; i++) {
                String state = request.getParameter(String.valueOf(ids.get(i))); // Récupérer l'état
                String moduleId = request.getParameter("module" + i); // Récupérer l'ID du module

                // Vérifier si l'état et l'ID du module ne sont pas nuls
                if (state != null && moduleId != null) {
                    // Insérer les données dans la base de données
                    String insertQuery = "INSERT INTO Absences(IdEtudiant, IdModule, State) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                    preparedStatement.setInt(1, ids.get(i));
                    preparedStatement.setInt(2, Integer.parseInt(moduleId));
                    preparedStatement.setString(3, state);
                    preparedStatement.executeUpdate();
                } else {
                    // Afficher un message d'erreur si des paramètres sont manquants
                    out.println("<p>Erreur: Les données de l'étudiant " + ids.get(i) + " sont incomplètes.</p>");
                }
            }

            // Fermer la connexion à la base de données
            con.close();
        } catch (Exception e) {
            // Afficher un message d'erreur en cas d'échec de la connexion ou de l'insertion
            out.println("<p>Erreur lors de l'enregistrement.</p>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
