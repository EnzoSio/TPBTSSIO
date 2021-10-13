import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
public class FenetreSuppression extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;
	private JLabel lblSupp1;
	private JTextField jtfSupp1;
	private JButton btnValider1;

	private Classe laClasse;

	public FenetreSuppression(Classe uneClasse) {

		this.laClasse = uneClasse;

		monPanel = new JPanel();
		panelHaut = new JPanel();
		panelMil = new JPanel();
		monPanel.setLayout(new BorderLayout());
		panelMil.setLayout(new FlowLayout());
		panelHaut.setLayout(new FlowLayout());
		monPanelGlobal.setLayout(new BorderLayout());

		lblSupp1 = new JLabel("Entrez l'�l�ve � supprimer : ");
		jtfSupp1 = new JTextField("");
		jtfSupp1.setPreferredSize(new Dimension(150, 30));

		btnValider1 = new JButton("Valider");
		btnValider1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = jtfSupp1.getText();
				if (laClasse.supprimer(nom)) {
					JLabel Bravo = new JLabel("Suppression r�ussie ! ");
					panelMil.add(Bravo);
				} else {
					JLabel Raté = new JLabel("Suppression �chou�e ! ");
					panelMil.add(Raté);
				}
			}

		});

		panelMil.add(lblSupp1);
		panelMil.add(jtfSupp1);
		panelMil.add(btnValider1);

		monPanel.add(panelHaut, BorderLayout.NORTH);
		monPanel.add(panelMil, BorderLayout.CENTER);
		

		this.setAlwaysOnTop(true);
		this.getContentPane().add(monPanel); // UN SEUL panel DANS LE GET CONTENT
		this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

		this.getContentPane().add(this.monPanelGlobal);
	}

	//les getter et setter
	public JPanel getMonPanelGlobal() {
		return monPanelGlobal;
	}

	public void actionPerformed(ActionEvent e) {

	}

}