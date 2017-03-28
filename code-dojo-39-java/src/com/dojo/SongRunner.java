package com.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongRunner {
	public static void main(String[] args){
		List<String> animals = new ArrayList<String>(Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow", "horse"));
		Song song = new Song(animals);
		song.printSong();
	}
}
