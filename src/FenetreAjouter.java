import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
public class FenetreAjouter extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JPanel monPanelGlobal = new JPanel();

	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAge;
	private JLabel lblChoix;

	private JTextField jtfNom;
	private JTextField jtfPrenom;
	private JTextField jtfAge;

	private JButton btnValider;
	private JButton btnAnnuler;
	private JComboBox < String > liste;

	private Classe laClasse;

	public FenetreAjouter(Classe uneClasse) {
		this.laClasse = uneClasse;

		//Titre
		this.setTitle("Ajouter un élève/enseignant");

		//Localisation de la fenêtre (null = milieu)
		this.setLocationRelativeTo(null);

		//Taille
		this.setSize(420, 300);
		this.setResizable(false);

		//PANEL
		monPanel = new JPanel();
		pannelHaut = new JPanel();
		pannelBas = new JPanel();
		monPanel.setLayout(new BorderLayout());
		monPanelGlobal.setLayout(new BorderLayout());
		GroupLayout layout = new GroupLayout(pannelHaut);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		pannelHaut.setLayout(layout);

		//LABELS
		lblNom = new JLabel("Nom : ");
		lblPrenom = new JLabel("Prénom : ");
		lblAge = new JLabel("Age : ");
		lblChoix = new JLabel("Choix : ");

		//SAISIES DE TEXTES
		jtfNom = new JTextField("");
		jtfNom.setMaximumSize(new Dimension(250, 30));
		jtfPrenom = new JTextField("");
		jtfPrenom.setMaximumSize(new Dimension(250, 30));
		jtfAge = new JTextField("");
		jtfAge.setMaximumSize(new Dimension(250, 30));

		//BOUTONS
		btnValider = new JButton("Valider");
		btnAnnuler = new JButton("Annuler");
		btnValider.addActionListener(this);
		btnAnnuler.addActionListener(this);
		pannelBas.add(btnValider);
		pannelBas.add(btnAnnuler);

		//LISTE DEROULANTE
		liste = new JComboBox < String > ();
		liste.addItem("Eleve");
		liste.addItem("Enseignant");
		liste.setMaximumSize(new Dimension(200, 30));

		monPanel.add(pannelHaut, BorderLayout.NORTH);
		monPanel.add(pannelBas, BorderLayout.PAGE_END);

		//Création de 2 groupes horizontaux 
		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) //1er groupe
		.addComponent(lblNom).addComponent(jtfNom).addComponent(lblPrenom).addComponent(jtfPrenom).addComponent(lblAge).addComponent(jtfAge)

		).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) //2eme groupe
		.addComponent(lblChoix).addComponent(liste)));

		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Les deux premiers �l�ments sont sur le m�me alignement
		.addComponent(lblNom).addComponent(lblChoix)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jtfNom) //Contenu de la premi�re colonne
		.addComponent(lblPrenom).addComponent(jtfPrenom).addComponent(lblAge).addComponent(jtfAge)

		).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(liste) //Contenu de la deuxi�me Colonne
		))));

		this.setAlwaysOnTop(true);
		this.getContentPane().add(monPanel);
		this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

		this.getContentPane().add(this.monPanelGlobal);
		//this.setVisible(true);
	}

	//les getter et setter
	public JPanel getMonPanelGlobal() {
		return monPanelGlobal;
	}

	public void actionPerformed(ActionEvent evenement) {
		if (evenement.getSource() == btnValider) { //Si la source de l'�v�nement est le JButton appel� 
			String nom = jtfNom.getText();
			String prenom = jtfPrenom.getText();
			int age = Integer.parseInt(jtfAge.getText());
			String type = liste.getSelectedItem().toString(); 
			String emploiEnseignant = "Enseignant";
			String emploiEleve = "Eleve";

			if (type == "Enseignant") {
				Enseignant unEnseignant = new Enseignant(nom, prenom, age, emploiEnseignant);
				laClasse.ajoutPersonne(unEnseignant);
			}
			else if (type == "Eleve") {
				Eleve unEleve = new Eleve(nom, prenom, age, emploiEleve);
				laClasse.ajoutPersonne(unEleve);
			}
		}
	}
}