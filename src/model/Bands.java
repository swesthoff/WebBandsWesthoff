//Sheri Westhoff
package model;

import java.text.DecimalFormat;

import javax.persistence.Column;

//import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;



//import controller.BandLevelAttributeConverter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "band_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "RegBand")
@Table(name = "band")
// @SecondaryTable(name = "band_level")

public class Bands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "band_id")
	protected int bandId;
	@Column(name = "num_of_members")
	private int numberOfMembers;
	@Column(name = "name_of_band")
	private String nameOfBand;
	@Column(name = "location_of_band")
	private String locationOfBand;
	@Column(name = "cost_of_participation")
	private double costOfParticipation;
//	 @Convert(converter = BandLevelAttributeConverter.class)
	@Column(name = "level_of_band")
	private int levelOfBand;
	@Column(name = "band_type")
	private String bandType;

	@Transient
	final double JUNIOR_HIGH_COST = 50.00;
	@Transient
	final double HIGH_SCHOOL_COST = 100.00;
	@Transient
	double quantityDiscount;
	@Transient
	DecimalFormat df = new DecimalFormat("$##0.00");
	// @Convert(converter = BandLevelAttributeConverter.class)
	@Transient
	private String levelOfBandDesc;
	/////
	@Transient
	final int ELEMENTARY_LEVEL_ID = 1;
	@Transient
	final int JUNIOR_HIGH_LEVEL_ID = 2;
	@Transient
	final int HIGH_SCHOOL_LEVEL_ID = 3;
	
	public Bands() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bands(int bandId) {
		super();
		this.bandId = bandId;
	}

	
	public Bands(int numberOfMembers, String nameOfBand, String locationOfBand, int levelOfBand) {
		super();
		this.numberOfMembers = numberOfMembers;
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		this.levelOfBand = levelOfBand;
		this.costOfParticipation = calcCostOfParticipation(numberOfMembers,levelOfBand);
	//	this.bandType = bandType;
	}




	public int getBandId() {
		return bandId;
	}

//	public void setBandId(int bandId) {
//		this.bandId = bandId;
//	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}
	// providing a discount based on number of members

	public void setNumberOfMembers(int nmbrOfMembers) {
		this.numberOfMembers = nmbrOfMembers;

	}

	public String getNameOfBand() {
		return nameOfBand;
	}

	public void setNameOfBand(String nameOfBand) {
		this.nameOfBand = nameOfBand;
	}

	public String getLocationOfBand() {
		return locationOfBand;
	}

	public void setLocationOfBand(String locationOfBand) {
		this.locationOfBand = locationOfBand;
	}

	public double getCostOfParticipation() {
		return costOfParticipation;
	}

//	public void setCostOfParticipation(double costOfParticipation) {
//		this.costOfParticipation = costOfParticipation;
//	}

	public String getLevelOfBand() {
		String levelOfBandDesc;
		if (this.levelOfBand == ELEMENTARY_LEVEL_ID) {
			levelOfBandDesc = "Elementary";
		} else if (this.levelOfBand == JUNIOR_HIGH_LEVEL_ID) {
			levelOfBandDesc = "Junior School";
		} else 
			levelOfBandDesc = "High School";
//		} 
		return levelOfBandDesc;
		
	}

	public void setLevelOfBand(int levelOfBand) {
		this.levelOfBand = levelOfBand;
	
	}

	
	private double calcCostOfParticipation(int numberOfMembers2, int levelOfBand2) {
	// TODO Auto-generated method stub
	

		if (this.numberOfMembers < 25) {
			quantityDiscount = 0;
		} else if (this.numberOfMembers > 100) {
			quantityDiscount = 10.00;
		} else {
			quantityDiscount = 5.50;
		}
		
		Double totalCostOfParticipation;
		if (this.levelOfBand == ELEMENTARY_LEVEL_ID) {
			totalCostOfParticipation = 0.0;
		} else if (this.levelOfBand == JUNIOR_HIGH_LEVEL_ID) {
			totalCostOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		} else {
			totalCostOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		}
//1		totalCostOfParticipation = 599.99;
		return totalCostOfParticipation;
}


	public String bandReport() {
		return "The " + this.nameOfBand + " band is located at " + this.locationOfBand + ". It costs "
				+ df.format(costOfParticipation) + " to join. ";

	}

	public String displayBands() {
		DecimalFormat df = new DecimalFormat("##.00");
		// String levelBandDesc;
		if (levelOfBand == 1) {
			levelOfBandDesc = "Elementary";
		} else if (levelOfBand == 2) {
			levelOfBandDesc = "Junior High";
		} else {
			levelOfBandDesc = "High School";

		}
		String displayBands = "ID= " + bandId + " | Number of Members: " + numberOfMembers + "  | Name of Band: "
				+ nameOfBand + " | Location of Band: " + locationOfBand + "  | Cost of Participation: $"
				+ df.format(costOfParticipation) + "  | Level Of Band: " + levelOfBandDesc + " | band type: "
				+ this.bandType;
		return displayBands;

	}

}
