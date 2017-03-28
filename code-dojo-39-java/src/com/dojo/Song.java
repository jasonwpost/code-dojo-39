package com.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Song {
	List<Verse> verses;

    public Song(List<String> animals) {
   
    	verses = createVerses(animals); 	
    	verses = addBridges(animals, verses);
    	
    }
    
    public void printSong(){
    	for (Verse verse: verses){
    		System.out.print(verse.getVerse());
    		if (verse.hasBridge()){
    			System.out.print(verse.getBridge());
    		}
    	}
    }
    
    private List<Verse> createVerses(List<String> animals){
    	List<Verse> verses = new ArrayList<>();
    	int lastAnimal = animals.size() - 1;
    	int firstAnimal = 0;
    	
    	for (int animal = firstAnimal; animal < animals.size(); animal++){
    		if (animal == firstAnimal){
    			verses.add(new Verse(animals.get(animal), true, false));
    		} else if (animal == lastAnimal){
    			verses.add(new Verse(animals.get(animal), false, true));
    		}else {
    			verses.add(new Verse(animals.get(animal), false, false));
    		}
    	}
    	return verses;
    }
    
    private List<Verse> addBridges(List<String> animalsToProcess, List<Verse> versesToProcess){
    
    	String bridge = "";
    	for(int verse = 0; verse < versesToProcess.size(); verse++){
    		if(versesToProcess.get(verse).isFirstLine()){
    			bridge += versesToProcess.get(verse).getRhyme();
    		} else if (versesToProcess.get(verse).isLastLine()){
    			continue;
    		} else {
    			bridge = "She swallowed the " + animalsToProcess.get(verse) + " to catch the " + animalsToProcess.get(verse - 1) + ".\n" + bridge;
    			versesToProcess.get(verse).setBridge(bridge);
    		}
    	}
    	return versesToProcess;
    }
}