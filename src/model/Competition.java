package model;
//Sheri Westhoff

import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.persistence.Transient;

@Entity
@IdClass(CompetitionId.class)
// @PrimaryKeyJoinColumn(name = "bandId", referencedColumnName = "bandId")
// @DiscriminatorValue(value = "partBands")
@Table(name = "participating_bands")

// public class Competition extends Bands {
public class Competition {
	@Id
	@Column(name = "competition_id")
	protected int competitionId;
	@Id
	@Column(name = "band_id")
	private int bandId;

	@Transient
	String competitionName;
	
	
	public Competition(int competitionId, int bandId) {
		super();
		this.competitionId = competitionId;
		this.bandId = bandId;
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

	// public Competition(int numberOfMembers, String nameOfBand, String
	// locationOfBand, int levelOfBand,
	// int competitionId, int bandId) {
	// super(numberOfMembers, nameOfBand, locationOfBand, levelOfBand);
	// this.competitionId = competitionId;
	// this.bandId = bandId;
	// }

	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public int getbandId() {
		return bandId;
	}

	public void setbandId(int bandId) {
		this.bandId = bandId;
	}


	// Hardcoding competitions until we figure out how do get the information from t
	// the table

	public String getCompetitionName() {
		// TODO Auto-generated method stub
	
		if (this.competitionId == 1) {
		
			this.competitionName  = "Johnston Marching Competition";
		}else if (this.competitionId == 2) {
			this.competitionName = "Waukee Marching Competition";
		
		}else if (this.competitionId == 3) {
			this.competitionName = "SEP Marching Competition";
			 
		}
	return competitionName;
	}
}
//
//		String displayCompetitions = "Competition:  bandId " + bandId + "  | Name of Band: " + getNameOfBand()
//		//		+ " | Location of Band: " + getLocationOfBand()
////
//	//			+ " | Competition:= " + competitionDesc;
//		return displayCompetitions;
//
//	}


