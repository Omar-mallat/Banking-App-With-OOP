package metier;

public class Client  extends User {
		private int id_client ;
	 
	    public int getId_client() {
			return id_client;
		}

		public void setId_client(int id_client) {
			this.id_client = id_client;
		}

		public Client(int id, String userName, String motDepasse,String adresse,String mail, int id_client ) {
	    	super(id,userName,motDepasse,adresse,mail);
	    	this.id_client = id_client ;
	    }

		@Override
		public String toString() {
			return "Client [id_client=" + id_client + "]";
		}
	       
	
	}



