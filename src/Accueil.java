import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Page d'accueil de mon Interface
 * @author Enzo AIME
 *
 */
public class Accueil extends JFrame implements ActionListener {

	//Ici je d�clare mes attributs priv�s
	//D�claration de mes JPanels 
	 
	private JPanel monPanel = new JPanel();
	private JPanel monPanelGlobal = new JPanel();

	//D�claration d'un label
	 
	private JLabel lblMessage;

	//D�claration des �l�m�nts de mon menu
	 

	private JMenuBar menu;
	private JMenu menuPdt;
	private JMenuItem ajouterPdt;
	private JMenuItem supprimerPdt;
	private JMenuItem afficherPdt;
	private JMenuItem rechercherPdt;
	private JMenuItem quitterPdt;

	private Classe laClasse;

	/**
	 * Constructeur de la classe
	 */

	public Accueil(Classe uneClasse) {

		this.laClasse = uneClasse;
		//Ceci permet la configuration de la fen�tre
		 
		this.setTitle("La Classe de BTS SIO");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(true);

		//Disposition et instanciation du panel global
		 

		this.monPanel.setLayout(new FlowLayout(1, 1, 2));
		this.monPanel.setBackground(new java.awt.Color(44, 62, 80));

		monPanelGlobal = new JPanel();
		monPanelGlobal.setLayout(new BorderLayout());


		JMenuBar menu = new JMenuBar();
		JMenu menuPdt = new JMenu("Eleves/Professeurs");

		//Cr�ation des diff�rents boutons du menu 
		 
		this.ajouterPdt = new JMenuItem("Ajouter un �l�ve/professeur");
		this.afficherPdt = new JMenuItem("Afficher les �l�ves/professeurs");
		this.rechercherPdt = new JMenuItem("Rechercher un �l�ve/professeur");
		this.supprimerPdt = new JMenuItem("Supprimer un �l�ve/professeur");
		this.quitterPdt = new JMenuItem("Quitter la classe");

		//Ajout des boutons au menu
		 
		menuPdt.add(ajouterPdt);
		menuPdt.add(afficherPdt);
		menuPdt.add(rechercherPdt);
		menuPdt.add(supprimerPdt);
		menuPdt.add(quitterPdt);

		//On �coute les boutons du menu 
		 
		this.ajouterPdt.addActionListener(this);
		this.afficherPdt.addActionListener(this);
		this.rechercherPdt.addActionListener(this);
		this.supprimerPdt.addActionListener(this);
		this.quitterPdt.addActionListener(this);

		//On ajoute le menu dans la barre de menu en haut
		 
		menu.add(menuPdt);

		//D�finition du menu dans la JFrame
		 
		this.setJMenuBar(menu);

		
		 //Voici le label permettant d'afficher le texte � l'accueil
		 
		this.lblMessage = new JLabel();
		this.lblMessage.setText("BIENVENUE DANS LA CLASSE BTS SIO");
		this.lblMessage.setForeground(new java.awt.Color(255, 255, 255));

		this.monPanel.add(lblMessage);

		this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

		this.getContentPane().add(this.monPanelGlobal);
		this.setVisible(true);
	}

	public JPanel getMonPanelGlobal() {
		return monPanelGlobal;
	}

	//Les changements entre les diff�rents panels se font ici en fonction du bouton cliqu�
	public void actionPerformed(ActionEvent e) {

		//Panel d'Ajout d'�l�ve si bouton cliqu�.
		 
		if (e.getSource().equals(ajouterPdt)) {

			//Suppression du panel
			 

			this.getContentPane().removeAll();

			//Ajout d'un Panel permettant d'afficher l'ajout d'un �l�ve dans la classe � partir du bouton du menu 
			 

			this.getContentPane().add(new FenetreAjouter(laClasse).getMonPanelGlobal());
			this.getContentPane().revalidate(); //
			this.getContentPane().repaint();

			//Panel d'Affichage de la classe si bouton cliqu�.

		} else if (e.getSource().equals(afficherPdt)) {
			this.getContentPane().removeAll();

			//Ajout d'un Panel permettant l'affichage de la classe � partir du bouton du menu 
			 

			this.getContentPane().add(new FenetreAffichage(laClasse).getMonPanelGlobal());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();

			//Ajout d'un Panel permettant la recherche d'un �l�ve dans la classe � partir du bouton du menu 
			 

		} else if (e.getSource().equals(rechercherPdt)) {

			this.getContentPane().removeAll();
			this.getContentPane().add(new FenetreRecherche(laClasse).getMonPanelGlobal());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();

			// Ajout d'un Panel permettant la suppression d'un �l�ve dans la classe � partir du bouton du menu 
			
		} else if (e.getSource().equals(supprimerPdt)) {

			this.getContentPane().removeAll(); //on va supprimer le panel
			this.getContentPane().add(new FenetreSuppression(laClasse).getMonPanelGlobal());
			this.getContentPane().revalidate();
			this.getContentPane().repaint();

			//Ajout d'un Panel permettant de quitter la classe/le programme � partir du bouton du menu 


		} else if (e.getSource().equals(quitterPdt)) {
			dispose();
		}
	}

	public static void main(String[] args) {
		Classe laClasse = new Classe();
		Accueil Fenetre = new Accueil(laClasse);
	}
}