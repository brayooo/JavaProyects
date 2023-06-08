package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManagementWord {

	private ArrayList<Word> dictionary;

	public ManagementWord() throws FileNotFoundException, IOException {
		dictionary = new ArrayList<>();
		initialize();
	}

	private void initialize() throws FileNotFoundException, IOException {
		try (FileReader reader = new FileReader("src/res/Dictionary.txt");
				BufferedReader core = new BufferedReader(reader);) {
			String line = "";
			while ((line = core.readLine()) != null) {
				String[] list = line.split(",");
				ArrayList<String> synonyms = new ArrayList<>();
				for (int i = 1; i < list.length; i++) {
					synonyms.add(list[i]);
				}
				dictionary.add(new Word(list[0], synonyms));
			}
		}
	}

	public void addWord(String word) {
		dictionary.add(new Word(word));
	}

	public void addSynonym(String word, String synonym) {
		for (int i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).getWord().equals(word)) {
				Word actualWord = dictionary.get(i);
				actualWord.addSynonym(synonym);
				dictionary.remove(i);
				dictionary.add(actualWord);
				return;
			}
		}
	}

	public Word searchWord(String letter) throws Exception {
		for (Word word : dictionary) {
			if (word.getWord().equals(letter)) {
				return word;
			}
		}
		throw new Exception("No se ha encontrado la palabra, si quiere puede crearla");
	}

	public String getLastSynonym(Word word, String actualSynonym) {
		Object[] synonymList = word.getList().toArray();
		for (int i = synonymList.length - 1; i > 0; i--) {
			if (synonymList[i] == actualSynonym) {
				return (String) synonymList[i - 1];
			}
		}
		return null;
	}

	public String getNextSynonym(Word word, String actualSynonym) {
		Object[] synonymList = word.getList().toArray();
		for (int i = 0; i < synonymList.length; i++) {
			if (synonymList[i] == actualSynonym && i != synonymList.length - 1) {
				return (String) synonymList[i + 1];
			}
		}
		return null;
	}

	public int getSizeSynonym(Word word) {
		return word.getSize();
	}

	public void writeNewFile() throws IOException {
		try (FileWriter reader = new FileWriter("src/res/Dictionary.txt");
				BufferedWriter core = new BufferedWriter(reader);) {
			for (Word word : dictionary) {
				String lineString = word.getToFile() + "\n";
				core.write(lineString);
			}
		}
	}

	public String getSynonym(Word word) {
		return word.getSynonym();
	}

	public boolean compareResult(String result) {
		return result != null;
	}

	public Object[] getWordList() {
		return dictionary.toArray();
	}
}
