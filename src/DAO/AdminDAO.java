package DAO;

	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Admin;

public class AdminDAO{

private static Connection conn;

    public static void crediter(double solde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void debiter(double solde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public AdminDAO() {
       
    }

    public boolean ajouterAdmin(Admin admin) {
        try {
        	conn = ConnexionBDD.getInstance();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO admins (login_idAdmin, username, password, adresse, mail) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, admin.getId_admin());
            ps.setString(2, admin.getUserName());
            ps.setString(3, admin.getMotDepasse());
            ps.setString(4, admin.getAdresse());
            ps.setString(5, admin.getMail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modifierAdmin(Admin admin) {
        try {
        	conn = ConnexionBDD.getInstance();
            PreparedStatement ps = conn.prepareStatement("UPDATE admins SET username = ?, password= ?, adresse = ?, mail = ? WHERE login_idAdmin= ?");
            ps.setString(1, admin.getUserName());
            ps.setString(2, admin.getMotDepasse());
            ps.setString(3, admin.getAdresse());
            ps.setString(4, admin.getMail());
            ps.setInt(5, admin.getId_admin());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean supprimerAdmin(int id_admin) {
        try {
        	conn = ConnexionBDD.getInstance();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM admins WHERE login_idAdmin= ?");
            ps.setInt(1, id_admin);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Admin> listerAdmin() {
        try {
            conn = ConnexionBDD.getInstance();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admins");
            ResultSet rs = ps.executeQuery();
            List<Admin> liste = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String motdepasse = rs.getString("password");
                String adresse = rs.getString("adresse");
                String mail = rs.getString("mail");
                int id_admin = rs.getInt("login_idAdmin");
                Admin admin = new Admin(id, username, motdepasse, adresse, mail,id_admin);
                liste.add(admin);
            }
            return liste;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
        public  static boolean ajouterCompte(String numero, double solde) {
            try {
                conn = ConnexionBDD.getInstance();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO comptes (id_client, solde) VALUES (?, ?)");
                ps.setString(1, numero);
                ps.setDouble(2, solde);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    

        public static boolean supprimerCompte(String numero) {
            try {
                conn = ConnexionBDD.getInstance();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM comptes WHERE id_compte = ?");
                ps.setString(1, numero);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        public static boolean ajouterClient(String username,String password , String adresse, String mail) {
            try {
                conn = ConnexionBDD.getInstance();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO clients (username,password, adresse, mail, telephone) VALUES (?, ?, ?, ?, ?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, adresse);
                ps.setString(4, mail);              
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        public static boolean supprimerClient(int idClient) {
            try {
                conn = ConnexionBDD.getInstance();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM clients WHERE id_client = ?");
                ps.setInt(1, idClient);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
    }
        public boolean enregistrerCompte(int idClient, double solde) {
            try {
                conn = ConnexionBDD.getInstance();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO comptes (id_client, solde) VALUES (?, ?)");
                ps.setInt(1, idClient);
                ps.setDouble(2, solde);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }


    

	
}


