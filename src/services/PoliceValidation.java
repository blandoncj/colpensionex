package services;

import models.Contributor;

public class PoliceValidation implements IValidation {

    private Contributor contributor;

    public PoliceValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        return contributor.hasFamilyInPolice();
    }

}
