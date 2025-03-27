package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Banquier;
import metier.Compte;

public class BanquierDAO {
	private static Connection conn;

   

    

    public BanquierDAO() {
    }

    public void ajouter(Banquier banquier) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "INSERT INTO banquiers(user_id, username, password, adresse, mail, login_idBanquier) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, banquier.getId());
        pstmt.setString(2, banquier.getUserName());
        pstmt.setString(3, banquier.getMotDepasse());
        pstmt.setString(4, banquier.getAdresse());
        pstmt.setString(5, banquier.getMail());
        pstmt.setInt(6, banquier.getId_banquier());
        pstmt.executeUpdate();
    }

    public List<Banquier> lister() throws SQLException {
    	conn = ConnexionBDD.getInstance();
        List<Banquier> banquiers = new ArrayList<>();
        String sql = "SELECT * FROM banquiers";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Banquier banquier = new Banquier(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
                    rs.getString("adresse"), rs.getString("mail"), rs.getInt("login_idBanquier"));
            banquiers.add(banquier);
        }
        return banquiers;
    }

    public Banquier rechercherParId(int id) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "SELECT * FROM banquiers WHERE user_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Banquier(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
                    rs.getString("adresse"), rs.getString("mail"), rs.getInt("login_idBanquier"));
        }
        return null;
    }

    public void modifier(Banquier banquier) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "UPDATE banquiers SET username=?, password=?, adresse=?, mail=?, login_idBanquier=? WHERE user_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, banquier.getUserName());
        pstmt.setString(2, banquier.getMotDepasse());
        pstmt.setString(3, banquier.getAdresse());
        pstmt.setString(4, banquier.getMail());
        pstmt.setInt(5, banquier.getId_banquier());
        pstmt.setInt(6, banquier.getId());
        pstmt.executeUpdate();
    }

    public void supprimer(int id) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        String sql = "DELETE FROM banquier WHERE user_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    public static Compte rechercheCompte(String numero) throws SQLException {
    	conn = ConnexionBDD.getInstance();
		Compte compte = null;
		String sql = "SELECT * FROM comptes WHERE numCompte = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, numero);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			compte = new Compte(resultSet.getString("numCompte"), resultSet.getDouble("solde"));
		}
		return compte;
	}
	
	public boolean ajouterCompte(Compte compte) throws SQLException {
		conn = ConnexionBDD.getInstance();
		String sql = "INSERT INTO comptes (solde) VALUES (?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, compte.getSolde());
		int resultat = preparedStatement.executeUpdate();
		return resultat > 0;
	}
	
	public static boolean crediter( double solde,String numero) throws SQLException {
		conn = ConnexionBDD.getInstance();
		String sql = "UPDATE comptes SET solde = solde + ? WHERE numCompte = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setDouble(1, solde);
                preparedStatement.setString(1, numero);
		int resultat = preparedStatement.executeUpdate();
		return resultat > 0;
	}
	
	public static boolean debiter(String numero,double solde) throws SQLException {
		conn = ConnexionBDD.getInstance();
		String sql = "UPDATE comptes SET solde = solde - ? WHERE numCompte = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, numero);	
		preparedStatement.setDouble(1, solde);	
		int resultat = preparedStatement.executeUpdate();
		return resultat > 0;
	}
	public boolean supprimerCompte(Compte compte) {
		conn = ConnexionBDD.getInstance();
        boolean deleted = false;
        try {
            String query = "DELETE FROM Comptes WHERE numCompte=?";
            PreparedStatement statement = this.conn.prepareStatement(query);
            statement.setString(1, compte.getNumero());
            int result = statement.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
	public boolean login(String username, String password) throws SQLException {
    	conn = ConnexionBDD.getInstance();
        try (
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM banquiers WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }
}