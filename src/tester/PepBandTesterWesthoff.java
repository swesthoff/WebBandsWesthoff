package tester;
//sheri westhoff
import java.util.List;
import java.util.Scanner;

import controller.PepBandHelper;

import model.PepBand;

public class PepBandTesterWesthoff {

	static PepBandHelper ph = new PepBandHelper();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		runMenu();
		// addNewBand();
	}

	private static void runMenu() {
		// TODO Auto-generated method stub
		boolean goAgain = true;
		System.out.println("--- This is the Pep Band Menu ---");
		while (goAgain) {
			System.out.println("\n*  Select an item:");
			System.out.println("*  1 -- Add a Pep Band");
			System.out.println("*  2 -- Edit a Pep Band");
			System.out.println("*  3 -- Delete a Pep Band");
			System.out.println("*  4 -- View the list of Pep Bands");
			System.out.println("*  5 -- Exit the  program");
		//	System.out.println("*  6 -- ADD Pep BAND");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewPepBand();
			} else if (selection == 2) {
				editAPepBand();
			} else if (selection == 3) {
				deleteAPepBand();
			} else if (selection == 4) {
				viewPepBandList();
			
			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewPepBandList() {
		// TODO Auto-generated method stub
		List<PepBand> allPepBands = ph.showAllPepBands();
		for (PepBand ph : allPepBands) {
			System.out.println(ph.displayPepBands());
		}

	}

	private static void deleteAPepBand() {
		// TODO Auto-generated method stub
		viewPepBandList();
		System.out.print("Enter the ID of the Pep Band you want to delete: ");
		int idToDelete = in.nextInt();
		in.nextLine();
		PepBand toDelete = new PepBand(idToDelete);
		ph.deletePepBand(toDelete);
	}

	private static void editAPepBand() {
		// TODO Auto-generated method stub
		viewPepBandList();

		System.out.print("Which ID to edit: ");
		int idToEdit = in.nextInt();
		in.nextLine();

		PepBand toEdit = ph.searchForPepBandById(idToEdit);
	System.out.println("Retrieved Pep Band - Event Type: " + toEdit.getEventId());
 			
 		System.out.print("New Event Id: ");
			int newEventId= in.nextInt();
					in.nextLine();
			toEdit.setEventId(newEventId);

		ph.updatePepBand(toEdit);
		System.out.println("Pep Band information was updated");
		PepBand toView = ph.searchForPepBandById(idToEdit);
		System.out.println("Updated Information | Event Type: " + toView.getEventId());
	
	}

	private static void addNewPepBand() {
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
        PepBand toAdd = new PepBand(49,"bobcats", "epworth",  1,2,"standing");
 //       PepBand(10,"Mobbers","Maxwell",15.6,2,1,"standing");
        
      
		ph.insertPepBand(toAdd);
	
		PepBand toAdd1 = new PepBand(55,"Hawkeye's", "Iowa City",  1,2,"Sitting");
		 
		ph.insertPepBand(toAdd1);
		   //  
		
		System.out.println("Insert New Pep Band worked");
		
	}
	
}
