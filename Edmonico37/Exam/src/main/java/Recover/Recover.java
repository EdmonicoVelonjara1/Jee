package Recover;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;


public class Recover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Recover() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session= request.getSession();
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		Integer taille = (Integer)session.getAttribute("taille");
		Integer state;
		ArrayList<Integer> id = new ArrayList<>();
		
		for(int i=0;i<taille;i++) {
			 state = request.getParameter(" "+ids.get(i)+""));
		}	
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
