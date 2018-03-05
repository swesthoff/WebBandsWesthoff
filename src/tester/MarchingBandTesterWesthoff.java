package tester;

import java.util.List;
import java.util.Scanner;

import controller.MarchingBandHelper;

import model.MarchingBand;

public class MarchingBandTesterWesthoff {

	static MarchingBandHelper mbh = new MarchingBandHelper();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		runMenu();
		// addNewBand();
	}

	private static void runMenu() {
		// TODO Auto-generated method stub
		boolean goAgain = true;
		System.out.println("--- This is the Marching Band Menu ---");
		while (goAgain) {
			System.out.println("\n*  Select an item:");
			System.out.println("*  1 -- Add a Marching Band");
			System.out.println("*  2 -- Edit a Marching Band");
			System.out.println("*  3 -- Delete a Marching Band");
			System.out.println("*  4 -- View the list of Narching Bands");
			System.out.println("*  5 -- Exit the  program");
		//	System.out.println("*  6 -- ADD MARCHING BAND");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewMarchingBand();
			} else if (selection == 2) {
				editAMarchingBand();
			} else if (selection == 3) {
				deleteAMarchingBand();
			} else if (selection == 4) {
				viewMarchingBandList();
			
			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewMarchingBandList() {
		// TODO Auto-generated method stub
		List<MarchingBand> allMarchingBands = mbh.showAllMarchingBands();
		for (MarchingBand mbh : allMarchingBands) {
			System.out.println(mbh.displayMarchingBands());
		}

	}

	private static void deleteAMarchingBand() {
		// TODO Auto-generated method stub
		viewMarchingBandList();
		System.out.print("Enter the ID of the Marching Band you want to delete: ");
		int idToDelete = in.nextInt();
		in.nextLine();
		MarchingBand toDelete = new MarchingBand(idToDelete);
		mbh.deleteMarchingBand(toDelete);
	}

	private static void editAMarchingBand() {
		// TODO Auto-generated method stub
		viewMarchingBandList();

		System.out.print("Which ID to edit: ");
		int idToEdit = in.nextInt();
		in.nextLine();

		MarchingBand toEdit = mbh.searchForMarchingBandById(idToEdit);
		System.out.println("Retrieved Marching Band - type of props: " + toEdit.getTypesOfProps());
			
			System.out.print("New type of props: ");
			String newTypeOfProps= in.nextLine();
			toEdit.setTypesOfProps(newTypeOfProps);

		mbh.updateMarchingBand(toEdit);
		System.out.println("Marching Band information was updated");
		MarchingBand toView = mbh.searchForMarchingBandById(idToEdit);
		System.out.println("Updated Information | Type of Props: " + toView.getTypesOfProps());
	
	}

	private static void addNewMarchingBand() {
		// TODO Auto-generated method stub
//		
//		System.out.print("Enter the number of members in the band: ");
//		int nmbrOfMembers = in.nextInt();
//		in.nextLine();
//		System.out.print("Enter the name of band: ");
//		String bandName = in.nextLine();
//		System.out.print("Enter the School Location: ");
//		String locationOfBand = in.nextLine();
//		System.out.print("Enter the Cost to participate: ");
//		Double costOfParticipation = in.nextDouble();
//		in.nextLine();
//		System.out.print("Enter the Level of Band (HS, JH, EM):  ");
//		String enteredLevelOfBand = in.nextLine();
//		// in.nextLine();
//		System.out.println("TEST: BAND LEVE: " + enteredLevelOfBand);
//		int levelOfBand = 0;
//		if (enteredLevelOfBand.equalsIgnoreCase("EM")) {
//			levelOfBand = 1;
//		} else if (enteredLevelOfBand.equalsIgnoreCase("JH")) {
//			levelOfBand = 2;
//		} else if (enteredLevelOfBand.equalsIgnoreCase("HS")) {
//			levelOfBand = 3;
//
//		}
//
//		Bands toAdd = new Bands(nmbrOfMembers, bandName, locationOfBand, costOfParticipation, levelOfBand);
//        MarchingBand toAdd = new MarchingBand(5,"bobcats", "epworth", 34.34, 1, "flags", 2,true);
//        MarchingBand toAdd = new MarchingBand(5,"bobcats", "epworth", 1,  "flags", true);
//		mbh.insertMarchingBand(toAdd);
//		System.out.println("Insert New EM MARCHING Band worked");
//
//        MarchingBand toAdd1 = new MarchingBand(44,"bobcats", "epworth",2 , " ", false);
////
//		mbh.insertMarchingBand(toAdd1);
//		System.out.println("Insert New JH MARCHING Band worked");
//
//		MarchingBand toAdd2 = new MarchingBand(300,"Cats", "Dubuque",3 , "poms", false);
//
//		mbh.insertMarchingBand(toAdd2);
//		System.out.println("Insert New HS MARCHING Band worked");
		
	}
	
}
