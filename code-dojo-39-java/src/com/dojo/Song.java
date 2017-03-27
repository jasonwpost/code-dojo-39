package com.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Song {

    public static void main(String[] args) {
    	
    	List<String> animals = new ArrayList<String>(Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow", "horse"));
    	List<Verse> verses = new ArrayList<>();
    	int lastAnimal = animals.size() - 1;
    	
    	for (int animal = 0; animal < animals.size(); animal++){
    		if (animal == 0){
    			verses.add(new Verse(animals.get(animal), true, false));
    		} else if (animal == lastAnimal){
    			verses.add(new Verse(animals.get(animal), false, true));
    		}else {
    			verses.add(new Verse(animals.get(animal), false, false));
    		}
    	}
    	
    	
    	String bridge = "";
    	for(int verse = 0; verse < verses.size(); verse++){
    		if(verses.get(verse).isFirstLine()){
    			bridge += verses.get(verse).getRhyme();
    		} else if (verses.get(verse).isLastLine()){
    			continue;
    		} else {
    			bridge = "She swallowed the " + animals.get(verse) + " to catch the " + animals.get(verse - 1) + ".\n" + bridge;
    			verses.get(verse).setBridge(bridge);
    		}
    	}
    	
    	for (Verse verse: verses){
    		System.out.print(verse.getVerse());
    		if (verse.hasBridge()){
    			System.out.print(verse.getBridge());
    		}
    	}
    }
}