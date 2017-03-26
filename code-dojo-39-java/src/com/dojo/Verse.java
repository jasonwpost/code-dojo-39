package com.dojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verse {
	private String animal;
	private boolean isFirstLine;
	private String line;
	private String rhyme;
	
	private static Map<String, String> rhymes;
	
	public Verse(String animal, boolean isFirstLine){
		
		this.animal = animal;
		this.isFirstLine = isFirstLine;
		if (!hasRhyme(animal)){
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
	
	public String getVerse(){
		return line;
	}
	
	public String getRhyme(){
		return rhyme;
	}
	
	private static String getRhyme(String animal){
		rhymes = new HashMap<>();
		rhymes.put("er", "That wriggled and wiggled and tickled inside her.");
		rhymes.put("rd", "How absurd to swallow a ");
		rhymes.put("at", "Fancy that to swallow a ");
		rhymes.put("og", "What a hog, to swallow a ");
		rhymes.put("ow", "I don't know how she swallowed a ");
		rhymes.put("se", "...She's dead, of course!");

		String lastTwoCharsOfAnimal = animal.substring(Math.max(animal.length() - 2, 0));
		
		String rhyme = rhymes.get(lastTwoCharsOfAnimal);

		if (rhyme.substring(rhyme.length() - 1).equals(" ")){
			rhyme += animal + ".";
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
	
	private static void addToRhymes(String key, String rhyme){
		rhymes.put(key, rhyme);
	}
	
}
