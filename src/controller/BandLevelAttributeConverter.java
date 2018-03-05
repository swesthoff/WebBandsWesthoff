package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BandLevelAttributeConverter implements AttributeConverter<Integer, String> {

	@Override
	public String convertToDatabaseColumn(Integer attribute) {
		// TODO Auto-generated method stub
		 switch (attribute) {
         case 1:
             return "Elementary";
         case 2:
             return "Junior High";
         case 3:
             return "High School";
         default:
             throw new IllegalArgumentException("Unknown" + attribute);
     }
	}

	@Override
	public Integer convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		 switch (dbData) {
         case "Elementary":
             return 1;
         case "Junior High":
             return 2;
         case "High School":
             return 3;
         default:
             throw new IllegalArgumentException("Unknown" + dbData);
	} 
	// convert int to description

	}

}