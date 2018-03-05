//Sheri Westhoff
package controller;
import java.util.ArrayList;

import model.Bands;

public class BandsParticipating {

	private String eventName;
	private ArrayList<Bands> bandlist;
	
	
	
	public BandsParticipating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BandsParticipating(String eventName) {
		super();
		this.eventName = eventName;
		bandlist = new ArrayList<Bands>();
	}



	public ArrayList<Bands> getBandlist() {
		return bandlist;
	}
	public void setBandlist(ArrayList<Bands> bandlist) {
		this.bandlist = bandlist;
	}
	@Override
	public String toString() {
		return "BandsParticipating [eventName=" + eventName + ", bandlist=" + bandlist + "]";
	}
	
	// assigning band names to Bands
	public void addToEvent(Bands newBand) {
		bandlist.add(newBand);
	}

	public String displayParticipants() {
		String participants = "Bands : " + eventName + ", Event List= " + bandlist;
		return participants;
	}

	

}
