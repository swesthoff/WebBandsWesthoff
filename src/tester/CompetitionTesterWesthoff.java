package tester;
//sheri westhoff
import java.util.List;
import java.util.Scanner;

import controller.CompetitionHelper;

import model.Competition;

public class CompetitionTesterWesthoff {

	static CompetitionHelper ch = new CompetitionHelper();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		runMenu();
	
	}
//
//	private static void runMenu() {
//		// TODO Auto-generated method stub
//		boolean goAgain = true;
//		System.out.println("--- This is the Competition Menu ---");
//		while (goAgain) {
//			System.out.println("\n*  Select an item:");
//			System.out.println("*  1 -- Add a comp Band");
//			// System.out.println("* 2 -- Edit a comp Band");
//			// System.out.println("* 3 -- Delete a comp Band");
//			System.out.println("*  4 -- View the list of Competition");
//			System.out.println("*  5 -- Exit the  program");
//			// System.out.println("* 6 -- ADD Pep BAND");
//			System.out.print("*  Your selection: ");
//			int selection = in.nextInt();
//			in.nextLine();
//
//			if (selection == 1) {
//				addNewCompetition();
//				// } else if (selection == 2) {
//				// editACompetition();
//				// } else if (selection == 3) {
//				// deleteACompetition();
//			} else if (selection == 4) {
//				viewCompetitionList();
//
//			} else {
//				// lih.cleanUp();
//				System.out.println("   Goodbye!   ");
//				goAgain = false;
//			}
//		}
//	}
////
//	private static void viewCompetitionList() {
//		// TODO Auto-generated method stub
//		List<Competition> allCompetitions = ch.showAllCompetitions();
//		for (Competition ph : allCompetitions) {
//			System.out.println(ph.displayCompetitions());
//		}
//
//	}

	// private static void deleteACompetition() {
	// // TODO Auto-generated method stub
	// viewCompetitionList();
	// System.out.print("Enter the ID of the Pep Band you want to delete: ");
	// int idToDelete = in.nextInt();
	// in.nextLine();
	// Competition toDelete = new Competition(idToDelete);
	// ph.deleteCompetition(toDelete);
	// }
	//
	// private static void editACompetition() {
	// // TODO Auto-generated method stub
	// viewCompetitionList();
	//
	// System.out.print("Which ID to edit: ");
	// int idToEdit = in.nextInt();
	// in.nextLine();
	//
	// Competition toEdit = ph.searchForCompetitionById(idToEdit);
	// System.out.println("Retrieved Pep Band - Event Type: " +
	// toEdit.getEventId());
	//
	// System.out.print("New Event Id: ");
	// int newEventId= in.nextInt();
	// in.nextLine();
	// toEdit.setEventId(newEventId);
	//
	// ph.updateCompetition(toEdit);
	// System.out.println("Pep Band information was updated");
	// Competition toView = ph.searchForCompetitionById(idToEdit);
	// System.out.println("Updated Information | Event Type: " +
	// toView.getEventId());
	//
	// }

	private static void addNewCompetition() {
		// TODO Auto-generated method stub
		//
		// System.out.print("Enter the number of members in the band: ");
		// int nmbrOfMembers = in.nextInt();
		// in.nextLine();
		// System.out.print("Enter the name of band: ");
		// String bandName = in.nextLine();
		// System.out.print("Enter the School Location: ");
		// String locationOfBand = in.nextLine();
		// System.out.print("Enter the Cost to participate: ");
		// Double costOfParticipation = in.nextDouble();
		// in.nextLine();
		// System.out.print("Enter the Level of Band (HS, JH, EM): ");
		// String enteredLevelOfBand = in.nextLine();
		// // in.nextLine();
		// System.out.println("TEST: BAND LEVE: " + enteredLevelOfBand);
		// int levelOfBand = 0;
		// if (enteredLevelOfBand.equalsIgnoreCase("EM")) {
		// levelOfBand = 1;
		// } else if (enteredLevelOfBand.equalsIgnoreCase("JH")) {
		// levelOfBand = 2;
		// } else if (enteredLevelOfBand.equalsIgnoreCase("HS")) {
		// levelOfBand = 3;
		//
		// }
		//
		// Bands toAdd = new Bands(nmbrOfMembers, bandName, locationOfBand,
		// costOfParticipation, levelOfBand);
//		Competition toAdd = new Competition(49, "bobcats", "epworth", 1, 2, 1);
//		ch.insertCompetition(toAdd);
//
//		Competition toAdd1 = new Competition(300, "Hawks", "Iowa City", 2, 3, 1);
//		ch.insertCompetition(toAdd1);
//
//		Competition toAdd2 = new Competition(200, "BearCats", "Maryville", 1, 1, 2);
//		ch.insertCompetition(toAdd2);
//
//		Competition toAdd3 = new Competition(250, "BearCats", "Maryville", 3, 1, 2);
//		ch.insertCompetition(toAdd3);
//
//		System.out.println("Insert New Competition worked");

	}

}
