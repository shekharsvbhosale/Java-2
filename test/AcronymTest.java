package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Acronym;

class AcronymTest {
	
	private Acronym name;

	@Test
	void nameIsConvertedToAcronym() {
		String nameToConvert = "Heidi Müller";
		name = new Acronym();
		String actualAcronymResult = name.isConvertedToAcronym(nameToConvert);
		
		String expectedAcronymResult = "HM";
		assertNotNull(actualAcronymResult);
		assertEquals(expectedAcronymResult, actualAcronymResult);
		System.out.println(expectedAcronymResult + " " + actualAcronymResult);
	}

}
