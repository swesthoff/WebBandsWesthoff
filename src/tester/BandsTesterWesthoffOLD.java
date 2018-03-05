package tester;
//Sheri Westhoff
import java.util.Scanner;

import controller.BandsParticipating;
import model.Bands;
import model.MarchingBand;
import model.PepBand;


public class BandsTesterWesthoffOLD {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Instrument clarinet = new Instrument("clarinet", "woodwind");
		 * System.out.println(clarinet.displayInstrument());
		 * 
		 * Instrument tuba = new Instrument("tuba", "brass");
		 * System.out.println(tuba.displayInstrument());
		 * 
		 * Instrument snare = new Instrument("snare", "percussion");
		 * System.out.println(snare.displayInstrument());
		 * 
		 * // InstrumentList bandOneList = new InstrumentList(snare,2); InstrumentList
		 * bandOneList = new InstrumentList(); System.out.println(bandOneList); // add
		 * names // bandOneList.add(snare,2);
		 */
		// Bands bandOne = new Bands(9, "Hawks", "Woodward", 25.24, "highschool");
//		Bands bandOne = new Bands(20, "Hawks", "Woodward", "JH");
		// System.out.println("\nTEST:" + bandOne);
//		System.out.println(bandOne.bandReport());

	//	MarchingBand bandTwo = new MarchingBand(false, "pompom", false);
		// System.out.println("\nTEST:" + bandTwo);
//		System.out.println(bandTwo.bandReport());

//		MarchingBand marchingBandTwo = new MarchingBand(9, "Rams", "Altoona", "HS", true, "pompom", true);
		// System.out.println("\nTEST:" + marchingBandTwo);
	//	System.out.println(marchingBandTwo.bandReport());

//		PepBand bandThree = new PepBand("sporting", "basketball");
		// System.out.println("\nTEST:" + bandThree);
	//	System.out.println(bandThree.bandReport());

//		PepBand bandFour = new PepBand(9, "Rams", "Altoona", "JH", "assembly", "homecoming");
		// System.out.println("\nTEST:" + bandFour);
//		System.out.println(bandFour.bandReport());

		BandsParticipating state = new BandsParticipating("State");
	//	state.addToEvent(marchingBandTwo);
//		state.addToEvent(bandTwo);

		System.out.println(state.displayParticipants());

		System.out.println("\nWhat is the name of your band?");
		String bandName = in.nextLine();

		System.out.println("What is the level of your band? JH or HS");
		String bandLevel = in.nextLine();

		// use the band level to determine cost and the location of the band
		if (bandLevel.equalsIgnoreCase("HS")) {
			System.out.println("You have a High School Level Band " + bandLevel);
		} else if (bandLevel.equalsIgnoreCase("JH")) {
			System.out.println("You have a Junior High Level Band " + bandLevel);
		} else {
			System.out.println("Invalid value entered for Band Level - ");
		}

		System.out.println("How many members are in your band?");
		int numberMembers = in.nextInt();
		in.nextLine();

		System.out.println("Where is your band located?");
		String bandLocation = in.nextLine();

		System.out.println("Is this a marching band? Y or N");
		String marchingBand = in.nextLine();

		if (marchingBand.equalsIgnoreCase("y")) {
			// marching band stuff
			// calculate instrument list based on number of members??

			// System.out.println("TEST - Marching band");
			System.out.println("Are you bringing props? Y or N");
			String props = in.nextLine();
			String propType = null;
			boolean hasProps = false;
			if (props.equalsIgnoreCase("y")) {
				System.out.println("What props are you bringing?");
				propType = in.nextLine();
				hasProps = true;
				// System.out.println("TEST - Prop:" + propType);

			}
			System.out.println("Will your color guard be attending? Y or N");
			String colorGuard = in.nextLine();
			// System.out.println("TEST - Color Guard? " + colorGuard);
			boolean hasColorGuard = false;
			if (colorGuard.equalsIgnoreCase("Y")) {
				hasColorGuard = true;
			}
//			Bands enteredBand = new MarchingBand(numberMembers, bandName, bandLocation, bandLevel, hasProps, propType,
//					hasColorGuard);
//			System.out.println(enteredBand.bandReport());

		} else {
			System.out.println("Is this a pep band? Y or N");
			String pepBand = in.nextLine();
			if (pepBand.equalsIgnoreCase("y")) {
				// pep band stuff
				// calculate instrument list based on number of members??

				// System.out.println("TEST - Pep band");
				System.out.println("What type of event are you playing at - sporting or assembly?");
				String eventType = in.nextLine();

				String eventDetail = null;

				if (eventType.equalsIgnoreCase("sporting")) {
					System.out.println("What sporting event are you playing at?");
					eventDetail = in.nextLine();
					// System.out.println("TEST - Sporting event type " + eventDetail);
					// this would be girls basketball, football, etc. - just will be printed
				} else if (eventType.equalsIgnoreCase("assembly")) {
					System.out.println("What assembly are you playing at?");
					eventDetail = in.nextLine();
					// System.out.println("TEST - Assembly type " + eventDetail);
					// this would be homecoming, district, etc. - just will be printed
				} else {
					System.out.println("ERROR - invalid type of event for a PepBand:");
				}
//				Bands enteredBand = new PepBand(numberMembers, bandName, bandLocation, bandLevel, eventType,
//						eventDetail);
//				System.out.println(enteredBand.bandReport());

			} else {
				// concert band
				// domain table?
				// System.out.println("TEST - Concert Band");
//				Bands enteredBand = new Bands(numberMembers, bandName, bandLocation, bandLevel);
//				System.out.println(enteredBand.bandReport());
			}
		}
		in.close();

	}

}
