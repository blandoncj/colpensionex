package services;

import enums.Gender;
import enums.PensionFund;
import models.Contributor;

public class CivilValidation implements IValidation {

    private Contributor contributor;

    public CivilValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        if (validCity() && validAge()) {
            if (hasForeignFund() 
                || hasOldMutualFund() && hasLessThanOneHundredWeeks()
                    || hasColfondosFund() && hasLessThanThreeHundredWeeks()
                        || hasProteccionFund() && hasLessThanFiveHundredNinetyWeeks()
                            || hasPorvenirFund() && hasLessThanEightHundredWeeks()) {
                return true;
            }
        }
        return false;
    }

    private boolean validCity() { 
        String city = contributor.getCity().trim().toUpperCase();
        String[] invalidCities = {"BOGOTA", "MEDELLIN", "CALI"};

        for (String invalidCity : invalidCities) {
            if (city.equals(invalidCity)) {
                return false;
            }
        }
        return true;
    }

    private boolean validAge() {
        return contributor.getGender() == Gender.MASCULINO && contributor.getAge() < 62
            || contributor.getGender() == Gender.FEMENINO && contributor.getAge() < 57;
    }

    private boolean hasForeignFund() {
        return contributor.getPensionFund() == PensionFund.FOREIGN;
    }

    private boolean hasOldMutualFund() {
        return contributor.getPensionFund() == PensionFund.OLD_MUTUAL;
    }

    private boolean hasColfondosFund() {
        return contributor.getPensionFund() == PensionFund.COLFONDOS;
    }

    private boolean hasProteccionFund() {
        return contributor.getPensionFund() == PensionFund.PROTECCION;
    }

    private boolean hasPorvenirFund() {
        return contributor.getPensionFund() == PensionFund.PORVENIR;
    }

    private boolean hasLessThanOneHundredWeeks() {
        return contributor.getWeeksContributed() < 100;
    }

    private boolean hasLessThanThreeHundredWeeks() {
        return contributor.getWeeksContributed() < 300;
    }

    private boolean hasLessThanFiveHundredNinetyWeeks() {
        return contributor.getWeeksContributed() < 590;
    }

    private boolean hasLessThanEightHundredWeeks() {
        return contributor.getWeeksContributed() < 800;
    }

}
