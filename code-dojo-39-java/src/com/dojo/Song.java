package com.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Song {

    public static void main(String[] args) {
    	
    	List<String> animals = new ArrayList<String>(Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow", "horse"));
    	List<Verse> verses = new ArrayList<>();
    	List<String> bridges = new ArrayList<>();
    	
    	for (int animal = 0; animal < animals.size(); animal++){
    		if (animal == 0){
    			verses.add(new Verse(animals.get(animal), true));
    		} else {
    			verses.add(new Verse(animals.get(animal), false));
    		}
    	}
    	
    	for(int caughtAnimal = 0, catchingAnimal = 1; catchingAnimal < animals.size()-1; caughtAnimal++, catchingAnimal++){
    		String bridge = "She swallowed the " + animals.get(catchingAnimal) + " to catch the " + animals.get(caughtAnimal) + ".\n";
    		if (caughtAnimal > 0){
    			for (int prevCaughtAnimal = caughtAnimal - 1, prevCatchingAnimal = catchingAnimal -1; prevCaughtAnimal >= 0; prevCaughtAnimal--, prevCatchingAnimal--){
    				bridge += "She swallowed the " + animals.get(prevCatchingAnimal) + " to catch the " + animals.get(prevCaughtAnimal) + ".\n";
    			}
    		}
    		bridges.add(bridge);
    	}
    	    	
    	for (int verse = 0; verse < verses.size(); verse++){
    		Verse thisVerse = verses.get(verse);
    		System.out.println(thisVerse.getVerse());
    		if(verse > 0 && verse < verses.size() - 1){
    			int bridge = verse - 1;
    			System.out.print(bridges.get(bridge));
    			System.out.print(verses.get(0).getRhyme());
    		}
    	}
    }
}