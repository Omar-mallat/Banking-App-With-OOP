package metier;

public class Compte {
    private String numero;
    private double solde;
	
    public String getNumero() {
        return numero;
    }
    public double getSolde() {
    	return solde ;
    }

    public void setNumero(String string) {
        this.numero = string;
    }

    public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}
	
	public void setSolde(double solde) {
        this.solde = solde;
    }
    @Override
    public String toString() {
        return "Compte [numero=" + numero + ", solde=" + solde + " ]";
    }


}
