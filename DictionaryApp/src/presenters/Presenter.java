package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import models.ManagementWord;
import models.Word;
import views.Window;

public class Presenter implements ActionListener {

	private ManagementWord mWord;
	private Window window;
	private Word actualWord;

	public Presenter() {
		window = new Window(this);
		try {
			mWord = new ManagementWord();
		} catch (IOException e) {
			window.showError(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Buscar")) {
			searchWord();
		} else if (command.equals("Atras")) {
			getLastSynonym();
		} else if (command.equals("Siguiente")) {
			getNextSynonym();
		} else if (command.equals("AnadirP")) {
			showAddWord();
		} else if (command.equals("AnadirS")) {
			showAddSynonym();
		} else if (command.equals("AP")) {
			addWord();
		} else if (command.equals("AS")) {
			addSynonym();
		} else {
			cancel();
		}
	}

	private void addSynonym() {
		mWord.addSynonym(window.getWordToAdd(), window.getSynonymToAdd());
		try {
			mWord.writeNewFile();
		} catch (IOException e) {
			window.showError(e.getMessage());
		}
		window.setDefault();
	}

	private void addWord() {
		mWord.addWord(window.getWord());
		try {
			mWord.writeNewFile();
		} catch (IOException e) {
			window.showError(e.getMessage());
		}
		window.setDefault();
	}

	private void cancel() {
		window.setDefault();
		window.setCancel();
	}

	private void showAddSynonym() {
		window.setAddS();
		window.updateWords(mWord.getWordList());
	}

	private void showAddWord() {
		window.setAddW();
	}

	private void getNextSynonym() {
		String result = mWord.getNextSynonym(actualWord, window.getSynonym());
		if (mWord.compareResult(result)) {
			window.setSynonym(result);
		}

	}

	private void getLastSynonym() {
		String result = mWord.getLastSynonym(actualWord, window.getSynonym());
		if (mWord.compareResult(result)) {
			window.setSynonym(result);
		}

	}

	private void searchWord() {
		try {
			actualWord = mWord.searchWord(window.getSearch());
			window.setSearch(mWord.getSizeSynonym(actualWord), mWord.getSynonym(actualWord));
		} catch (Exception e) {
			window.showError(e.getMessage());
		}
	}

}
