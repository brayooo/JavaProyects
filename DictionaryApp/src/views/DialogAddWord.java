package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogAddWord extends JDialog {

	private JLabel newWord;
	private JTextField wordTxtField;
	private JButton agreeButton;
	private JButton cancelButton;

	public DialogAddWord(ActionListener listener) {
		this.setTitle("Adicionar nueva palabra");
		this.setSize(400, 80);
		initComponents(listener);
		this.setVisible(false);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(2, 2));
		newWord = new JLabel("Nueva palabra: ");
		wordTxtField = new JTextField();
		agreeButton = new JButton("Aceptar");
		agreeButton.addActionListener(listener);
		agreeButton.setActionCommand("AP");
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(listener);
		cancelButton.setActionCommand("Cancelar");
		add(newWord);
		add(wordTxtField);
		add(agreeButton);
		add(cancelButton);
	}

	public String getWord() {
		return wordTxtField.getText();
	}
}
