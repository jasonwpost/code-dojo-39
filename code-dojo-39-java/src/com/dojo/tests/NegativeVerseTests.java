package com.dojo.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.dojo.Verse;

public class NegativeVerseTests {
	private static Verse verse;
	private static String animal;
	
	@Test
	public void setUpBeforeClass() throws Exception {
		try {
			animal = "Sheep";
			verse = new Verse(animal, false, false);
			fail("Should throw exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	
}
