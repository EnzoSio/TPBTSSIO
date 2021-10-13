public class Eleve extends Personne {

	/*
	 * Constructeur de la classe Eleve.
	 */
	public Eleve(String unNom, String unPrenom, int unAge, String unEmploi) {
        super(unNom, unPrenom, unAge, unEmploi);
    }

    /*
     * Méthode toString Eleve
     */
    public String toString() {
        return "\nEnseignant : " + getNom() + " - " + getPrenom() + " - " + getAge() + getEmploi();
    }

}