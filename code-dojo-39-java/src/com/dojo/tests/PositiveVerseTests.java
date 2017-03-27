package com.dojo.tests;
import static org.junit.Assert.*;
import com.dojo.Verse;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositiveVerseTests {
	private static Verse verse;
	private static String animal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		animal = "Tiger";
		
		verse = new Verse(animal, true, false);
	}

	@Test
	public void testGetVerse() {
		assertEquals(verse.getVerse(), "There was an old lady who swallowed a " + animal + ".\nI don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n");
	}

	@Test
	public void testGetRhyme() {
		assertEquals(verse.getRhyme(), "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n");
	}

}
