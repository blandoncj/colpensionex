package services;

import models.Contributor;

public class ArmadaValidation implements IValidation {

    private Contributor contributor;

    public ArmadaValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        if (contributor.isDecorated()) {
            return true;
        }

        CivilValidation civilValidation = new CivilValidation(contributor);
        return civilValidation.isValid();
    }
   
}
