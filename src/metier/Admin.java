package metier;

public class Admin extends User  {
	private int id_admin ;

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public Admin(int id, String userName, String motDepasse,String adresse,String mail, int id_admin) {
		super(id, userName, motDepasse,adresse,mail);
		this.id_admin = id_admin ;
		
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + "]";
	}
	 
	

}
