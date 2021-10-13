public abstract class Personne {

	/**
	 * Attributs privés de la classe Personne
	 */
	private String nom;
	private String prenom;
	private int age;
	private String emploi;

	/**
	 * Constructeur de la classe Personne.
	 * @param unNom
	 * @param unPrenom
	 * @param unAge
	 * @param unEmploi
	 */
	public Personne(String unNom, String unPrenom, int unAge, String unEmploi) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.age = unAge;
		this.emploi = unEmploi;
	}

	
	/**
	 * Permet de récupérer le nom d'une personne
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet d'instancier le nom d'un personne
	 * @param unNom
	 */
	
	public void setNom(String unNom) {
		this.nom = unNom;
	}
	
	/**
	 * Permet de récupérer le prénom d'un personne
	 * @return
	 */
	
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Permet d'instancier le prénom d'une personne
	 * @param unPrenom
	 */

	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}

	/**
	 * Permet de récupérer l'age d'une personne
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Permet d'instancier l'âge d'une personne
	 * @param unAge
	 */
	public void setAge(int unAge) {
		this.age = unAge;
	}
	
	/**
	 * Permet de récupérer l'emploi d'une personne
	 * @return
	 */

	public String getEmploi() {
		return emploi;
	}

	/**
	 * Permet d'instancier l'emploi d'une personne 
	 * @param unEmploi
	 */
	public void setEmploi(String unEmploi) {
		this.emploi = unEmploi;
	}
}

	