package metier;

public class User {
	
	private int id ;
	private String userName ;
	private String motDepasse ;
	private String adresse ;
	private String mail ;
	
	public User(int id, String userName, String motDepasse,String adresse,String mail) {
		this.id = id;
		this.userName = userName;
		this.motDepasse = motDepasse;
		this.adresse = adresse ;
		this.mail = mail ;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMotDepasse() {
		return motDepasse;
	}
	public void setMotDepasse(String motDepasse) {
		this.motDepasse = motDepasse;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", motDepasse=" + motDepasse + ", adresse=" + adresse
				+ ", mail=" + mail + "]";
	}
	}
	
	