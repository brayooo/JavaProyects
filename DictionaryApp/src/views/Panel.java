package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Panel extends JPanel {

	private JPanel panelSearch;
	private JPanel panelResults;
	private JPanel panelButtons;
	private JLabel word;
	private JLabel synonymActual;
	private JLabel quantitySynonym;
	private JLabel quantitySynonymResponse;
	private JTextField wordActual;
	private JButton searchButton;
	private JButton lastButton;
	private JButton nextButton;
	private JButton addWordButton;
	private JButton addSynonymButton;

	public Panel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(3, 1));
		panelSearch = new JPanel();
		word = new JLabel("Word: ");
		wordActual = new JTextField(22);
		searchButton = new JButton("Find Synonyms");
		searchButton.addActionListener(listener);
		searchButton.setActionCommand("Buscar");
		panelSearch.add(word);
		panelSearch.add(wordActual);
		panelSearch.add(searchButton);
		panelResults = new JPanel();
		panelResults.setLayout(new GridLayout(2, 1));
		panelResults.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Synonym",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				new Font(this.getFont().getName(), Font.BOLD, this.getFont().getSize()), Color.BLUE));
		JPanel synonymsJPanel = new JPanel();
		synonymsJPanel.setLayout(new BorderLayout());
		lastButton = new JButton("<<");
		lastButton.addActionListener(listener);
		lastButton.setActionCommand("Atras");
		synonymActual = new JLabel();
		nextButton = new JButton(">>");
		nextButton.addActionListener(listener);
		nextButton.setActionCommand("Siguiente");
		synonymsJPanel.add(BorderLayout.WEST, lastButton);
		synonymsJPanel.add(BorderLayout.CENTER, synonymActual);
		synonymsJPanel.add(BorderLayout.EAST, nextButton);
		JPanel synonymsFoundJPanel = new JPanel();
		quantitySynonym = new JLabel("Sinónimos encontrados: ");
		quantitySynonymResponse = new JLabel();
		synonymsFoundJPanel.add(quantitySynonym);
		synonymsFoundJPanel.add(quantitySynonymResponse);
		panelResults.add(synonymsJPanel);
		panelResults.add(synonymsFoundJPanel);
		panelButtons = new JPanel();
		addWordButton = new JButton("Add Word");
		addWordButton.addActionListener(listener);
		addWordButton.setActionCommand("AnadirP");
		addSynonymButton = new JButton("Add Synonym");
		addSynonymButton.addActionListener(listener);
		addSynonymButton.setActionCommand("AnadirS");
		panelButtons.add(addWordButton);
		panelButtons.add(addSynonymButton);
		add(panelSearch);
		add(panelResults);
		add(panelButtons);
	}

	public String getSearch() {
		return wordActual.getText();
	}

	public void setSearch(int quantity, String synonym) {
		synonymActual.setText(synonym);
		quantitySynonymResponse.setText(String.valueOf(quantity));
	}

	public String getSynonym() {
		return synonymActual.getText();
	}

	public void setSynonym(String synonym) {
		synonymActual.setText(synonym);
	}

}
