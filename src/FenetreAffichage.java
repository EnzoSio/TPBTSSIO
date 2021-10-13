import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
public class FenetreAffichage extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;

	private Classe laClasse;
	private JTable tableau;
	JScrollPane scrollPane;

	public FenetreAffichage(Classe uneClasse) {

		laClasse = uneClasse;

		monPanel = new JPanel();
		panelHaut = new JPanel();
		panelMil = new JPanel();
		monPanel.setLayout(new BorderLayout());
		panelMil.setLayout(new FlowLayout());
		panelHaut.setLayout(new FlowLayout());
		panelHaut.setBackground(Color.white);
		monPanelGlobal.setLayout(new BorderLayout());
		this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

		// TABLEAU : composé d'une ligne de titres de colonnes (title) et de données (data) 
		Object data[][] = new Object[10][10];
		int i = 0;
		for (Personne unePersonne: uneClasse.getListePersonne()) {
			data[i][0] = unePersonne.getNom();
			data[i][1] = unePersonne.getPrenom();
			data[i][2] = unePersonne.getAge() + " ans";			
			data[i][3] = unePersonne.getEmploi();
			i++;
		}
		String[] title = {
			"Nom",
			"Prénom",
			"Age",
			"Emploi"
		};
		this.tableau = new JTable(data, title);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

		this.tableau.setRowHeight(30); //Cette ligne permet de mettre de l'espace entre les cellules

		this.scrollPane = new JScrollPane(this.tableau);
		this.panelMil.add(this.scrollPane);

		monPanel.add(panelHaut, BorderLayout.NORTH);
		monPanel.add(panelMil, BorderLayout.CENTER);

		this.setAlwaysOnTop(true);
		this.monPanelGlobal.add(this.scrollPane);
		this.getContentPane().add(monPanel);
	}

	//les getter et setter
	public JPanel getMonPanelGlobal() {
		return monPanelGlobal;
	}

	public void actionPerformed(ActionEvent e) {

	}
}