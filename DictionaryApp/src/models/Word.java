package models;

import java.util.ArrayList;

public class Word {

	private String word;
	private ArrayList<String> synonymList;

	public Word(String word, ArrayList<String> synonymList) {
		this.word = word;
		this.synonymList = synonymList;
	}

	public Word(String word) {
		this.word = word;
		this.synonymList = new ArrayList<>();
	}

	public void addSynonym(String synonym) {
		synonymList.add(synonym);
	}

	public String getWord() {
		return word;
	}

	public int getSize() {
		return synonymList.size();
	}

	public ArrayList<String> getList() {
		return synonymList;
	}

	public String getSynonym() {
		return synonymList.get(0);
	}

	@Override
	public String toString() {
		return word;
	}

	public String getToFile() {
		String lineString = "";
		for (String string : synonymList) {
			lineString += ("," + string);
		}
		return word + lineString;
	}
}
