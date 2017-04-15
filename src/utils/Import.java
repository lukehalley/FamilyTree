package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Import {

	static HashMap<String, Person> FamilyMap = new HashMap<String, Person>();
	static Queue<Person> queue = new PriorityQueue<>();

	// Imports People
	public static void InitialImport() {

		// Scanner
		File familyFile = new File("family.dat");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(familyFile);

			String delims = " ";
			// each field in the file is separated (delimited) by a space.

			while (fileScanner.hasNextLine()) {

				String familyLine = fileScanner.nextLine().trim();
				String[] familyTokens = familyLine.split(delims);

				String firstName = familyTokens[0];
				String sex = familyTokens[1];
				long dateOfBirth = Long.parseLong(familyTokens[2]);
				String motherName = familyTokens[3];
				String fatherName = familyTokens[4];

				// output rating data to console.
				if (familyTokens.length > 0 || familyTokens.length <= 5) {
					Person withParents = new Person(firstName, sex, dateOfBirth, motherName, fatherName);
					FamilyMap.put(firstName, withParents);

				} else {
					fileScanner.close();
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

	// Imports People
	public static void LinkParents() {

		// Scanner
		File familyFile = new File("family.dat");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(familyFile);

			String delims = " ";
			// each field in the file is separated (delimited) by a space.

			while (fileScanner.hasNextLine()) {

				String familyLine = fileScanner.nextLine().trim();
				String[] familyTokens = familyLine.split(delims);

				String motherName = familyTokens[3];
				String fatherName = familyTokens[4];

				Person withParents = FamilyMap.get(familyTokens[0]);

				if (!motherName.equals("?")) {

					if (FamilyMap.containsKey(motherName)) {
						Person motherFound = FamilyMap.get(motherName);
						withParents.setLeftPerson(motherFound);
					} else {
						System.out.println("No mother key found");
					}

				}

				if (!fatherName.equals("?")) {

					if (FamilyMap.containsKey(fatherName)) {
						Person fatherFound = FamilyMap.get(fatherName);

						withParents.setRightPerson(fatherFound);
					} else {
						System.out.println("No father key found");
					}

				}

//				System.out.println("Mother found: " + motherName + "Father found: " + fatherName);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}
		
		for (Map.Entry<String, Person> entry : FamilyMap.entrySet()) {
		    System.out.println("Person:" + entry.getKey() + " : "+entry.getValue());
		}

	}

}
