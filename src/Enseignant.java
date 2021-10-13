public class Enseignant extends Personne {

	/*
	 * Constructeur de la classe Enseignant.
	 */
	public Enseignant(String unNom, String unPrenom, int unAge, String unEmploi) {
		super(unNom, unPrenom, unAge, unEmploi);
	}

	  /*
     * Méthode toString Enseignant
     */
	public String toString() {
		return "\nEnseignant : " + getNom() + " - " + getPrenom() + " - " + getAge() + getEmploi();
	}
}