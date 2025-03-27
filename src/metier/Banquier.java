package metier;

public class Banquier extends User {
	private int id_banquier ;
	public Banquier(int id, String userName, String motDepasse,String adresse,String mail, int id_banquier) {
		super(id, userName, motDepasse,adresse,mail);
		this.id_banquier = id_banquier ;
		
	}
	public int getId_banquier() {
		return id_banquier;
	}
	public void setId_banquier(int id_banquier) {
		this.id_banquier = id_banquier;
	}
	@Override
	public String toString() {
		return "Banquier [id_banquier=" + id_banquier + "]";
	}
	 
}
