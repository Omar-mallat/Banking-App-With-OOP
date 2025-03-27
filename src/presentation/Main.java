
package presentation;
import DAO.ClientDAO;
import DAO.CompteDAO;
import DAO.AdminDAO;
import DAO.BanquierDAO;
import metier.Client;
import metier.Compte;
import metier.Banquier;
import metier.Admin;
import java.sql.SQLException;
import java.util.List;
public class Main {
   

	public static void main(String[] args) {
       
        try {
            

            // Create DAO objects
            ClientDAO clientDAO = new ClientDAO();
            CompteDAO compteDAO = new CompteDAO();
            BanquierDAO banquierDAO = new BanquierDAO();
            AdminDAO adminDAO = new AdminDAO();

            // Test ClientDAO
            System.out.println("Testing ClientDAO:");
            System.out.println("All clients:");
            List<Client> clients = clientDAO.getAllClients();
            for (Client client : clients) {
                System.out.println(client);
            }
            System.out.println("Client with id 1: " + clientDAO.getClientById(1));

            // Test CompteDAO
            System.out.println("Testing CompteDAO:");
            System.out.println("All comptes:");
            List<Compte> comptes = compteDAO.getAllComptes();
            for (Compte compte : comptes) {
                System.out.println(compte);
            }
            System.out.println("Compte with id 1: " + compteDAO.getCompteByNumero(1));

            // Test BanquierDAO
            System.out.println("Testing BanquierDAO:");
            System.out.println("All banquiers:");
            List<Banquier> banquiers = banquierDAO.lister();
            for (Banquier banquier : banquiers) {
                System.out.println(banquier);
            }
            System.out.println("Banquier with id 1: " + banquierDAO.rechercherParId(1));
            //test AdminDAO
            System.out.println("Testing AdminDAO:");
            System.out.println("All Admins:");
            List<Admin> admins = adminDAO.listerAdmin();
            for (Admin admin : admins) {
                System.out.println(admin);
            }
          Choix c1 = new Choix();
          c1.setVisible(true);
            
            
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        } 
            }
        }