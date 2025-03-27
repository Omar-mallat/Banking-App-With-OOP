package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Client;
import metier.Compte;

public class ClientDAO {
    private static Connection conn;


    public ClientDAO() {}

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        conn = ConnexionBDD.getInstance();
        PreparedStatement stmt = conn.prepareStatement("select * from clients");
        ResultSet result = stmt.executeQuery();
        {
            while (result.next()) {
            	
                int id = result.getInt("user_id");
                String username = result.getString("username");
                String motDepasse = result.getString("password");
                String adresse = result.getString("adresse");
                String mail = result.getString("mail");
                int id_client = result.getInt("login_idClient");
                Client client = new Client(id, username,motDepasse ,adresse, mail,id_client);
                clients.add(client);
            }
        }
        return clients;
    }

    public Client getClientById(int id_client) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String query = "SELECT * FROM clients WHERE login_idClient= ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_client);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                	 int id = result.getInt("user_id ");
                	String username = result.getString("username");
                    String motDepasse = result.getString("password");
                    String adresse = result.getString("adresse");
                    String mail = result.getString("mail");
         
					return new Client(id, username,motDepasse ,adresse, mail,id_client);
                }
                return null;
            }
        }
    }

    public void insertClient(Client client) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String query = "INSERT INTO clients (username,adresse,mail) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.setString(1, client.getUserName());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getMail());
            stmt.executeUpdate();
        }
    }

    public void updateClient(Client client) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String query = "UPDATE clients SET username =?, = ?, adresse =?, mail= ? WHERE login_idClient = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getUserName());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getMail());
         
            stmt.setInt(5, client.getId_client());
            stmt.executeUpdate();
        }
    }

    public void deleteClient(int id_client) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String query = "DELETE FROM clients WHERE login_idClient = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_client);
            stmt.executeUpdate();
        }
    }
 public static Compte consulterCompteBancaire(String numero) {
         conn = ConnexionBDD.getInstance();
        Compte compte = null;
        try {
             try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Comptes WHERE numCompte = ?")) {
                 ps.setString(1, numero);
                 
                 ResultSet rs = ps.executeQuery();
                 if (rs.next()) {
                     compte = new Compte(rs.getString("numCompte"), rs.getDouble("solde"));
                 }}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compte;
    }

   
}
       
       
   


