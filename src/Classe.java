import java.util.ArrayList;
public class Classe {
	private ArrayList < Personne > listePersonne;

	public Classe() {
		this.listePersonne = new ArrayList < Personne > ();
	}
	/**
	 * Permet de r�cup�rer le nombre de personne pr�sente dans la classe.
	 * @return
	 */
	public int getNombrePersonne() {
		return this.listePersonne.size();
	}
	
	/**
	 * M�thode permettant d'ajouter des personnes dans la classe.
	 * @param unePersonne
	 */
	public void ajoutPersonne(Personne unePersonne) {
		this.listePersonne.add(unePersonne);
	}

	/**
	 * Collection permettant de r�cup�rer la liste des personnes pr�sente dans la classe.
	 * @return
	 */
	public ArrayList < Personne > getListePersonne() {
		return this.listePersonne;
	}

	/**
	 * Fonction permettant la recherche d'une personne par son nom.
	 * @param unNom
	 * @return
	 */
	public String recherche(String unNom) {
		int index = 0;
		String result = "Cet �l�ve n'est pas pr�sent dans cette classe";
		while (index < this.listePersonne.size() && !this.listePersonne.get(index).getNom().equals(unNom)) {
			index = index + 1;
		}
		if (index < this.listePersonne.size()) {
			result = "\nVoici l'�l�ve que vous cherchez " + unNom + this.listePersonne.get(index).toString();
		}
		return result;
	}
	
	/**
	 * Fonction permettant la recherche d'une personne � partir de son index
	 * @param unNom
	 * @return
	 */
	public int rechercheInt(String unNom) {
		int index = 0;
		int result = -1;
		while (index < this.listePersonne.size() && !this.listePersonne.get(index).getNom().equals(unNom)) {
			index = index + 1;
		}
		if (index < this.listePersonne.size()) {
			result = index;
		}
		return result;
	}

	/*
	 * M�thode permettant la suppression d'une personne � partir de son index.
	 */
	public void supprimer(int indice) {
		this.listePersonne.remove(indice);
	}

	/*
	 * M�thode permettant la suppression d'une personne � partir de son nom.
	 */
	public void supprimer(Personne unePersonne) {
		this.listePersonne.remove(unePersonne);
	}

	public boolean supprimer(String unePersonne) {
		boolean rep = false;
		int index = this.rechercheInt(unePersonne);
		if (index != -1) {
			this.listePersonne.remove(index);
			rep = true;
		}
		return rep;
	}

	/**
	 * M�thode toString qui renvoie une repr�sentation sous forme de cha�ne l'objet.
	 */
	public String toString() {
		String entete = "**** CLASSE DE BTS SIO ****";
		String resultat = "";
		if (this.listePersonne.size() == 0) {
			resultat = "\nLa classe ne contient aucun �l�ve";
		} else {
			for (int i = 0; this.listePersonne.size() > i; i++) {
				resultat = resultat + i + this.listePersonne.get(i).toString();
			}

		}
		return entete + resultat;
	}
}