package DAO;

import java.sql.*;
import java.util.*;

import metier.Compte;

public class CompteDAO {

    public static void ajouterCompte(String numero, double solde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection conn;

    public CompteDAO() {
    }

    public void addCompte(Compte compte) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "INSERT INTO comptes (numCompte, solde) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, compte.getNumero());
            stmt.setDouble(2, compte.getSolde());
            stmt.executeUpdate();
        }
    }

    public void updateCompte(Compte compte) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "UPDATE comptes SET solde = ? WHERE numCompte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, compte.getSolde());     
            stmt.setString(2, compte.getNumero());
            stmt.executeUpdate();
        }
    }

    public void deleteCompte(Compte compte) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "DELETE FROM comptes WHERE numCompte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, compte.getSolde());     
            stmt.setString(2, compte.getNumero());
            stmt.executeUpdate();
        }
    }

    public Compte getCompteByNumero(int numero) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "SELECT * FROM comptes WHERE numCompte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Compte(rs.getString("numCompte"), rs.getDouble("solde"));
                } else {
                    return null;
                }
            }
        }
    }

    public List<Compte> getAllComptes() throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "SELECT * FROM comptes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Compte> comptes = new ArrayList<>();
            while (rs.next()) {
                comptes.add(new Compte(rs.getString("numCompte"), rs.getDouble("solde")));
            }
            return comptes;
        }
    }
}

