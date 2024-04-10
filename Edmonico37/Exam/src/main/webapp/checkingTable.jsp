<%-- 
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checking Table</title>
    <link rel="stylesheet" type="text/css" href="stylelist.css">
</head>
<body>
    <h1>Liste des étudiants</h1>
    <% 
    // Récupération des attributs de la requête
    ArrayList<String> nom_etud = (ArrayList<String>) request.getAttribute("nom_etud");
    ArrayList<String> prenom_etud = (ArrayList<String>) request.getAttribute("prenom_etud");
    ArrayList<String> naissance_etud = (ArrayList<String>) request.getAttribute("naissance_etud");
    ArrayList<String> mail_etud = (ArrayList<String>) request.getAttribute("mail_etud");
	int taille =0;
    // Affichage des données récupérées
    if(nom_etud != null && !nom_etud.isEmpty()) {
    %>
    <%! HttpSessionT session= new HttpSessionT(); %>
    <form action="/Exam/receive" method="post">
    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Naissance</th>
                <th>Mail</th>
                <th>Etat</th>
                <th>Modules</th>
            </tr>
        </thead>
        <tbody>
        	<%
        		ArrayList<Integer> ids = new ArrayList<Integer>();
        		ArrayList<Integer> module = new ArrayList<Integer>();
        	%>
            <% for(int i = 0; i < nom_etud.size(); i++,taille++) { %>
            <tr>
                <td><%= nom_etud.get(i) %></td>
                <td><%= prenom_etud.get(i) %></td>
                <td><%= naissance_etud.get(i) %></td>
                <td><%= mail_etud.get(i) %></td>
                <% ids.add(i+1); module.add(i);%>
                
                <td>
                	<input name=<%= ids.get(i) %> type="radio" value="P">P
                	<input name=<%= ids.get(i) %> type="radio" value="A">A
                </td>
                <td>
                	Modules:
                	<select name="module"+<%= i%> >
                		<option value="1">Programmation</option>
                		<option value="2">Réseau/Système</option>
                		<option value="3">Probabilité</option>
                	</select>
                </td>
            </tr>
           <% 
            }
            session.setAttribute("ids",ids);
            session.setAttribute("module",module);
            session.setAttribute("taille",taille);
           %>
        </tbody>
    </table>
        <input type="submit" name="submit" value="Enregistrer">
    </form>
    <% } else { %>
    <p>Aucune donnée disponible</p>
    <% } %>
</body>
</html>

 --%>
 
 <%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checking Table</title>
    <link rel="stylesheet" type="text/css" href="stylelist.css">
</head>
<body>
    <h1>Liste des étudiants</h1>
    <% 
    // Récupération des attributs de la requête
    ArrayList<String> nom_etud = (ArrayList<String>) request.getAttribute("nom_etud");
    ArrayList<String> prenom_etud = (ArrayList<String>) request.getAttribute("prenom_etud");
    ArrayList<String> naissance_etud = (ArrayList<String>) request.getAttribute("naissance_etud");
    ArrayList<String> mail_etud = (ArrayList<String>) request.getAttribute("mail_etud");
    int taille = 0;
    // Affichage des données récupérées
    if (nom_etud != null && !nom_etud.isEmpty()) {
    %>
    <%-- <%! HttpSessionT session= new HttpSessionT(); %> --%>
    <form action="/Exam/receive" method="post">
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Naissance</th>
                    <th>Mail</th>
                    <th>Etat</th>
                    <th>Modules</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Integer> ids = new ArrayList<Integer>();
                    ArrayList<Integer> module = new ArrayList<Integer>();
                %>
                <% for (int i = 0; i < nom_etud.size(); i++, taille++) { %>
                <tr>
                    <td><%= nom_etud.get(i) %></td>
                    <td><%= prenom_etud.get(i) %></td>
                    <td><%= naissance_etud.get(i) %></td>
                    <td><%= mail_etud.get(i) %></td>
                    <% ids.add(i + 1); module.add(i); %>

                    <td>
                        <input name="<%= ids.get(i) %>" type="radio" value="P">P
                        <input name="<%= ids.get(i) %>" type="radio" value="A">A
                    </td>
                    <td>
                        Modules:
                        <select name="module<%= i %>">
                            <option value="1">Programmation</option>
                            <option value="2">Réseau/Système</option>
                            <option value="3">Probabilité</option>
                        </select>
                    </td>
                </tr>
                <% 
                }
                session.setAttribute("ids", ids);
                session.setAttribute("module", module);
                session.setAttribute("taille", taille);
                %>
            </tbody>
        </table>
        <input type="submit" name="submit" value="Enregistrer">
    </form>
    <% } else { %>
    <p>Aucune donnée disponible</p>
    <% } %>
</body>
</html>
 