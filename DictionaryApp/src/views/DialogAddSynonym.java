package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogAddSynonym extends JDialog {

	private JLabel word;
	private JComboBox<String> listOfWords;
	private JLabel newSynonym;
	private JTextField synonymTxt;
	private JButton agreeButton;
	private JButton cancelButton;

	public DialogAddSynonym(ActionListener listener) {
		this.setTitle("Adicionar nueva palabra");
		this.setSize(400, 120);
		initComponents(listener);
		this.setVisible(false);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(3, 2));
		word = new JLabel("Palabra: ");
		listOfWords = new JComboBox();
		newSynonym = new JLabel("Nuevo sinónimo");
		synonymTxt = new JTextField();
		agreeButton = new JButton("Aceptar");
		agreeButton.addActionListener(listener);
		agreeButton.setActionCommand("AS");
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(listener);
		cancelButton.setActionCommand("Cancelar");
		add(word);
		add(listOfWords);
		add(newSynonym);
		add(synonymTxt);
		add(agreeButton);
		add(cancelButton);
	}

	public void updateWords(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			listOfWords.addItem(list[i].toString());
		}
	}

	public void setDefault() {
		listOfWords.removeAllItems();
	}

	public String getWord() {
		return (String) listOfWords.getSelectedItem();
	}

	public String getSynonym() {
		return synonymTxt.getText();
	}
}
