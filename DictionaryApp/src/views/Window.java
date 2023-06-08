package views;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {

	public static final String NAME_WINDOW = "Diccionario de sinónimos";
	public static final int WIDTH_WINDOW = 400;
	public static final int HEIGTH_WINDOW = 230;
	public static final String ERROR = "Error";
	private Panel dictionaryPanel;
	private DialogAddWord addWord;
	private DialogAddSynonym addSynonym;

	public Window(ActionListener listener) {
		super(NAME_WINDOW);
		setSize(WIDTH_WINDOW, HEIGTH_WINDOW);
		initComponents(listener);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		dictionaryPanel = new Panel(listener);
		addWord = new DialogAddWord(listener);
		addSynonym = new DialogAddSynonym(listener);
		this.setContentPane(dictionaryPanel);
	}

	public String getWord() {
		return addWord.getWord();
	}

	public String getSearch() {
		return dictionaryPanel.getSearch();
	}

	public void setSearch(int qunatiity, String synonym) {
		dictionaryPanel.setSearch(qunatiity, synonym);
	}

	public String getSynonym() {
		return dictionaryPanel.getSynonym();
	}

	public void setSynonym(String synonym) {
		dictionaryPanel.setSynonym(synonym);
	}

	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error, ERROR, JOptionPane.WARNING_MESSAGE);
	}

	public void updateWords(Object[] list) {
		addSynonym.updateWords(list);
	}

	public void setAddW() {
		addWord.setVisible(true);
	}

	public void setAddS() {
		addSynonym.setVisible(true);
	}

	public void setCancel() {
		addWord.setVisible(false);
	}

	public void setDefault() {
		addSynonym.setDefault();
		addSynonym.setVisible(false);
		addWord.setVisible(false);
	}

	public String getWordToAdd() {
		return addSynonym.getWord();
	}

	public String getSynonymToAdd() {
		return addSynonym.getSynonym();
	}
}
