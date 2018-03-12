package model;
//Sheri Westhoff

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "Marching")
@Table(name = "marching_band")

public class MarchingBand extends Bands {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "types_of_props")
	private String typesOfProps;
	@Column(name = "number_of_buses")
	private int numberOfBuses;
	@Column(name = "has_color_guard")
	private boolean hasColorGuard;

	@Transient
	final int MINIMUM_NUMBER_BUSES = 1;
	@Transient
	private boolean hasProps;

	// private int additionalBuses;

	public MarchingBand() {
		super();
		// TODO Auto-generated constructor stub
	}

	// public MarchingBand(boolean hasProps, String typesOfProps, boolean
	// hasColorGuard) {
	// super();
	// // this.hasProps = hasProps;
	// // setHasProps(hasProps);
	// this.typesOfProps = typesOfProps;
	// // this.numberOfBuses = numberOfBuses;
	// // this.hasColorGuard = hasColorGuard;
	// setHasColorGuard(hasColorGuard);
	// }

	public MarchingBand(String typesOfProps, int numberOfBuses, boolean hasColorGuard) {
		super();
		this.typesOfProps = typesOfProps;
		this.numberOfBuses = calcNmbrOfBuses(typesOfProps, hasColorGuard);
		this.hasColorGuard = hasColorGuard;
	}

	


	public MarchingBand(int bandId) {
		super(bandId);
		// TODO Auto-generated constructor stub
	}

	public MarchingBand(int bandId, String typesOfProps, int numberOfBuses, boolean hasColorGuard) {
		super(bandId);
		this.typesOfProps = typesOfProps;
		this.numberOfBuses = numberOfBuses;
		this.hasColorGuard = hasColorGuard;
	}

	public MarchingBand(String typesOfProps, boolean hasColorGuard, boolean hasProps) {
		super();
		this.typesOfProps = typesOfProps;
		this.hasColorGuard = hasColorGuard;
		this.hasProps = hasProps;
	}

	public MarchingBand(int numberOfMembers, String nameOfBand, String locationOfBand, int levelOfBand,
			boolean hasProps ,String typesOfProps, boolean hasColorGuard) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelOfBand);
	    this.hasProps = hasProps;
		this.typesOfProps = typesOfProps;

		this.hasColorGuard = hasColorGuard;
		this.numberOfBuses = calcNmbrOfBuses(typesOfProps, hasColorGuard);
	}
	
	

	

	public String getTypesOfProps() {
		return typesOfProps;
	}

	public void setTypesOfProps(String typesOfProps) {
		this.typesOfProps = typesOfProps;
	}

	public int getNumberOfBuses() {
		return numberOfBuses;
	}

	public boolean isHasProps() {
		return hasProps;

	}

	public void setHasProps(boolean hasProps) {
		this.hasProps = hasProps;
	}

	public boolean isHasColorGuard() {
		return hasColorGuard;
	}

	public void setHasColorGuard(boolean hasColorGuard) {
		this.hasColorGuard = hasColorGuard;

	}
    
	
	
	public void setNumberOfBuses(String typeOfProps, boolean hasColorGuard) {
		 this.numberOfBuses = calcNmbrOfBuses(typesOfProps, hasColorGuard);
	}

	private int calcNmbrOfBuses(String typeOfProps, boolean hasColorGuard) {
		// TODO Auto-generated method stub
		boolean hasProps = false;
		if (typeOfProps == " ") {
			hasProps = false;
		} else {
			hasProps = true;
		}

		// hasProps = "false";

		int totalNumberOfBuses = 0;
		if (hasProps) {
			totalNumberOfBuses = MINIMUM_NUMBER_BUSES + 2;
		} else {
			totalNumberOfBuses = MINIMUM_NUMBER_BUSES;
		}

		if (hasColorGuard) {
			totalNumberOfBuses = totalNumberOfBuses + 1;
		}

		return totalNumberOfBuses;
	}

	@Override
	public String toString() {
		return "MarchingBand + " + "typesOfProps=" + typesOfProps + ", numberOfBuses=" + numberOfBuses
				+ ", hasColorGuard=" + hasColorGuard + ", toString()=" + super.toString() + "]";
	}

	@Override
	public String bandReport() {
		// TODO Auto-generated method stub
		if (hasProps) {
			if (numberOfBuses > 1) {
				return super.bandReport() + "Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " buses.";
			} else
				return super.bandReport() + "Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " bus.";

		} else {
			if (numberOfBuses > 1) {
				return super.bandReport() + "Your band will be taking " + numberOfBuses + " buses.";
			} else {
				return super.bandReport() + "Your band will be taking " + numberOfBuses + " bus.";

			}
		}
	}

	public String displayMarchingBands() {
		// TODO Auto-generated method stub

		String displayMarchingBands = "ID= " + bandId + " | Name of Band: " + getNameOfBand() + " | Location of Band: "
				+ getLocationOfBand() + " | Number of members: " + getNumberOfMembers() + " | Type of Props: "
				+ typesOfProps + "  | Number of Buses: " + numberOfBuses + " | has Color Guard: " + hasColorGuard;
		return displayMarchingBands;
	}
}
