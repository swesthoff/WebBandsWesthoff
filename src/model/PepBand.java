package model;
//Sheri Westhoff

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "PepBand")
@Table(name = "pep_band")
// Sheri Westhoff
public class PepBand extends Bands {
	@Column(name = "event_id")
	private int eventId;
	@Column(name = "playing_position")
	private String playingPosition;
	@Transient
	private String event;
	@Transient
	private String eventName;

	public PepBand() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public PepBand(String event, String eventName) {
//		super();
//		// this.event = event;
//		setEvent(event);
//		this.eventName = eventName;
//		// this.playingPosition = playingPosition;
//	}

	public PepBand(int eventId, String playingPosition, String event, String eventName) {
		super();
		this.eventId = eventId;
		this.playingPosition = playingPosition;
		this.event = event;
		this.eventName = eventName;
	}

//	public PepBand(int numberOfMembers, String nameOfBand, String locationOfBand, double costOfParticipation,
//			int levelOfBand, String bandType, int eventId, String playingPosition) {
//		super(numberOfMembers, nameOfBand, locationOfBand, costOfParticipation, levelOfBand, bandType);
//		this.eventId = eventId;
//		this.playingPosition = playingPosition;
//	}

	
	

	public PepBand(int numberOfMembers, String nameOfBand, String locationOfBand, 
			int levelOfBand, int eventId, String playingPosition) {
		super(numberOfMembers, nameOfBand, locationOfBand,  levelOfBand);
		this.eventId = eventId;
		this.playingPosition = playingPosition;
	}





//	public PepBand(int bandId, int eventId) {
//		super(bandId);
//		this.eventId = eventId;
//	}


	public PepBand(int bandId) {
		super(bandId);
		// TODO Auto-generated constructor stub
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
		if (this.event == "assembly") {
			this.playingPosition = "Standing";
		} else {
			this.playingPosition = "Sitting";
		}
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlayingPosition() {
		return playingPosition;
	}
	// public void setPlayingPosition(String playingPosition) {
	// this.playingPosition = playingPosition;
	// }

	public int getEventId() {
		return eventId;
	}

 	public void setEventId(int eventId) {
 		this.eventId = eventId;
 	}

	public void setPlayingPosition(String playingPosition) {
		this.playingPosition = playingPosition;
	}

	@Override
	public String toString() {
		return "PepBand [event=" + event + ", eventName=" + eventName + ", playingPosition=" + playingPosition
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public String bandReport() {
		// TODO Auto-generated method stub
		return super.bandReport() + " You will be " + playingPosition + " while playing at the " + eventName + " "
				+ event + " event";

	}

	public String displayPepBands() {
		// TODO Auto-generated method stub
//		String displayPepBand = "Pep Band:  Band_id " + bandId + " | Event ID= " + eventId  + "  | playing position: "
//				+ playingPosition;
	//	String eventName;
		if (eventId == 1) {
			eventName = "Sporting";
		}else {
			eventName = "Assembly";
		}
		String displayPepBand = "ID= " + bandId +  "| Name of Band: "
				+ getNameOfBand() + " | Location of Band: "  + getLocationOfBand() + " | Event Name " + eventName  + "  | playing position: "
						+ playingPosition;
		return displayPepBand;

	}

}
