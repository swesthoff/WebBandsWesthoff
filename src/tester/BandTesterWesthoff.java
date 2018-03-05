package tester;
//sheri westhoff
import java.util.List;
import java.util.Scanner;

import controller.BandHelper;
import controller.MarchingBandHelper;
import model.Bands;


public class BandTesterWesthoff {

	static Scanner in = new Scanner(System.in);

	static BandHelper bh = new BandHelper();
	static MarchingBandHelper mbh = new MarchingBandHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		runMenu();
		
	}

	private static void runMenu() {
		// TODO Auto-generated method stub
		boolean goAgain = true;
		System.out.println("--- This is the Band Menu ---");
		while (goAgain) {
			System.out.println("\n*  Select an item:");
			System.out.println("*  1 -- Add a Band");
			System.out.println("*  2 -- Edit a Band");
			System.out.println("*  3 -- Delete a Band");
			System.out.println("*  4 -- View the list of Bands");
			System.out.println("*  5 -- Exit the  program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewBand();
			} else if (selection == 2) {
				editABand();
			} else if (selection == 3) {
				deleteABand();
			} else if (selection == 4) {
				viewBandList();

			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewBandList() {
		// TODO Auto-generated method stub
		List<Bands> allBands = bh.showAllBands();
		for (Bands bh : allBands) {
			System.out.println(bh.displayBands());
		}

	}

	private static void deleteABand() {
		// TODO Auto-generated method stub
		viewBandList();
		System.out.print("Enter the ID of the Band you want to delete: ");
		int idToDelete = in.nextInt();
		in.nextLine();
		Bands toDelete = new Bands(idToDelete);
		bh.deleteBand(toDelete);
	}

	private static void editABand() {
		// TODO Auto-generated method stub
		viewBandList();

		System.out.print("Which ID to edit: ");
		int idToEdit = in.nextInt();
		in.nextLine();

		Bands toEdit = bh.searchForBandById(idToEdit);
		System.out.println("Retrieved Name of Band: " + toEdit.getNameOfBand() + " | Number of Members "
				+ toEdit.getNumberOfMembers() + " | Location " + toEdit.getLocationOfBand() + " | Cost to Participate "
				+ toEdit.getCostOfParticipation() + " | Level of Band " + toEdit.getLevelOfBand());
		System.out.println("1 : Update Name of Band");
		System.out.println("2 : Update Number of Members");
		System.out.println("3 : Update City of Band");

		int update = in.nextInt();
		in.nextLine();

		if (update == 1) {
			System.out.print("New Name of Band: ");
			String newNameOfBand = in.nextLine();
			toEdit.setNameOfBand(newNameOfBand);
		} else if (update == 2) {
			System.out.print("New number of members: ");
			int newNmbrOfMembers = in.nextInt();
			in.nextLine();
			toEdit.setNumberOfMembers(newNmbrOfMembers);

		} else if (update == 3) {
			System.out.print("New City: ");
			String newLocation = in.nextLine();
			toEdit.setLocationOfBand(newLocation);

		} else {
			System.out.println("invalid value entered");

		}
		bh.updateBand(toEdit);
		System.out.println("Band information was updated");
		Bands toView = bh.searchForBandById(idToEdit);
		System.out.println("Updated Information | Name of Band: " + toView.getNameOfBand() + " | Number of Members "
				+ toView.getNumberOfMembers() + " | Location " + toView.getLocationOfBand() + " | Cost to Participate "
				+ toView.getCostOfParticipation() + " | Level of Band " + toView.getLevelOfBand());

	}

	private static void addNewBand() {
		// TODO Auto-generated method stub

		System.out.print("Enter the number of members in the band: ");
		int nmbrOfMembers = in.nextInt();
		in.nextLine();
		System.out.print("Enter the name of band: ");
		String bandName = in.nextLine();
		System.out.print("Enter the School Location: ");
		String locationOfBand = in.nextLine();
		System.out.print("Enter the Cost to participate: ");
//		Double costOfParticipation = in.nextDouble();
//	in.nextLine();
		System.out.print("Enter the Level of Band (HS, JH, EM):  ");
		String enteredLevelOfBand = in.nextLine();
		// in.nextLine();
		System.out.println("TEST: BAND LEVE: " + enteredLevelOfBand);
		int levelOfBand = 0;
//		String bandType = "0";
		if (enteredLevelOfBand.equalsIgnoreCase("EM")) {
			levelOfBand = 1;
	//		bandType = "1";
		} else if (enteredLevelOfBand.equalsIgnoreCase("JH")) {
			levelOfBand = 2;
//			bandType = "2";
		} else if (enteredLevelOfBand.equalsIgnoreCase("HS")) {
			levelOfBand = 3;
//			bandType = "3";
		}
	Bands toAdd = new Bands(nmbrOfMembers, bandName, locationOfBand, levelOfBand);

//		Bands toAdd = new Bands(nmbrOfMembers, bandName, locationOfBand, costOfParticipation, levelOfBand, bandType);
		// Bands toAdd = new Bands(nmbrOfMembers, bandName, locationOfBand,
		// costOfParticipation, enteredLevelOfBand);

		bh.insertBands(toAdd);
		System.out.println("Insert New Band worked");
	}
}
