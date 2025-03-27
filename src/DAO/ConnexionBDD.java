package DAO;
import java.sql.*;
import java.sql.Connection;

public class ConnexionBDD { 
	
	
	//Informations de connexion à la base de données
    private final String url = "jdbc:mysql://localhost:3306/banking_app";
    private final String utilisateur = "root";
    private final String motDePasse = "";

    // Objet de connexion à la base de données
    private static Connection connexion;
  

    // Constructeur de la classe
    private ConnexionBDD() {
        try {           
            // Connexion à la base de données
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
           
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }
    public static Connection getInstance() {
        if (connexion == null) {
             new ConnexionBDD();
        }
        return connexion;
    }
    public void fermerConnexion() {
        try {
            connexion.close();
        } catch (SQLException e) {
            System.err.println("Erreur de fermeture de la connexion : " + e.getMessage());
        }
    }

	
	
}
