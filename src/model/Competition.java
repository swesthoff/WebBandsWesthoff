package model;
//Sheri Westhoff

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "partBands")
@Table(name = "participating_bands")

public class Competition extends Bands {

	@Column(name = "competition_id")
	protected int competitionId;

	@Column(name = "band_id")
	private int band_id;
	// @Transient
	// private list<Bands> bandlist;

	public Competition(int competitionId, int band_id) {
		super();
		this.competitionId = competitionId;
		this.band_id = band_id;
	}

	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}

	// public Competition(int numberOfMembers, String nameOfBand, String
	// locationOfBand,
	// int levelOfBand, String bandType) {
	// super(numberOfMembers, nameOfBand, locationOfBand, levelOfBand, bandType);
	// // TODO Auto-generated constructor stub
	// }

	public Competition(int numberOfMembers, String nameOfBand, String locationOfBand, int levelOfBand,
			int competitionId, int band_id) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelOfBand);
		this.competitionId = competitionId;
		this.band_id = band_id;
	}

	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public int getBand_id() {
		return band_id;
	}

	public void setBand_id(int band_id) {
		this.band_id = band_id;
	}

	// Hardcoding competitions until we figure out how do get the information from t
	// the table

	public String displayCompetitions() {
		// TODO Auto-generated method stub
		String competitionDesc;
		switch (competitionId) {
		case 1:
			competitionDesc = "Johnston Marching Competition";
			break;
		case 2:
			competitionDesc = "Waukee Marching Competition";
			break;
		case 3:
			competitionDesc = "SEP Marching Competition";
			break;
		default:
			competitionDesc = "None";
		}

		String displayCompetitions = "Competition:  Band_id " + bandId + "  | Name of Band: " + getNameOfBand()
				+ " | Location of Band: " + getLocationOfBand()

				+ " | Competition:= " + competitionDesc;
		return displayCompetitions;

	}

}
