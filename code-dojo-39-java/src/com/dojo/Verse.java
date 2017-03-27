package com.dojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verse {
	private String animal;
	private boolean isFirstLine;
	private boolean isLastLine;
	private String line;
	private String rhyme;
	private String bridge;
	private static Map<String, String> rhymes;
	
	public Verse(String animal, boolean isFirstLine, boolean isLastLine){
		
		this.animal = animal;
		this.isFirstLine = isFirstLine;
		this.isLastLine = isLastLine;
		if (!isFirstLine && !hasRhyme(animal)){
			throw new RuntimeException();
		}
		createRhyme();
		createVerse();
	}
	
	private void createRhyme(){
		if (isFirstLine){
			rhyme = "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n";
		} else {
			rhyme = getRhyme(animal);
		}
	}
	
	private void createVerse(){
		line = "There was an old lady who swallowed a " + animal + ".\n";
		line += rhyme;
	}
	
	public String getAnimal(){
		return animal;
	}
	
	public boolean isFirstLine(){
		return isFirstLine;
	}
	
	public boolean isLastLine(){
		return isLastLine;
	}
	
	public String getVerse(){
		return line;
	}
	
	public String getRhyme(){
		return rhyme;
	}
	
	public void setBridge(String bridge){
		this.bridge = bridge;
	}
	
	public String getBridge(){
		return bridge;
	}
	
	static {
		rhymes = new HashMap<>();
		rhymes.put("er", "That wriggled and wiggled and tickled inside her.\n");
		rhymes.put("rd", "How absurd to swallow a ");
		rhymes.put("at", "Fancy that to swallow a ");
		rhymes.put("og", "What a hog, to swallow a ");
		rhymes.put("ow", "I don't know how she swallowed a ");
		rhymes.put("se", "...She's dead, of course!\n");
	}
	
	private static String getRhyme(String animal){
		
		String lastTwoCharsOfAnimal = animal.substring(Math.max(animal.length() - 2, 0));
		
		String rhyme = rhymes.get(lastTwoCharsOfAnimal);

		if (rhyme.substring(rhyme.length() - 1).equals(" ")){
			rhyme += animal + ".\n";
		}
		return rhyme;
	}
	
	private static boolean hasRhyme(String animal){
		String lastTwoCharsOfAnimal = animal.substring(Math.max(animal.length() - 2, 0));
		if (rhymes.containsKey(lastTwoCharsOfAnimal)){
			return true;
		} else {
			return false;
		}
	}
	
	public static void addToRhymes(String key, String rhyme){
		rhymes.put(key, rhyme);
	}

	public boolean hasBridge() {
		if (bridge == null){
			return false;
		} else {
			return true;
		}
	}
	
}
