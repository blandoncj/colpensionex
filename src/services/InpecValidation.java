package services;

import models.Contributor;

public class InpecValidation implements IValidation{

    private Contributor contributor;

    public InpecValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        if (contributor.hasChildrenInInpec() || contributor.isDecorated()) {
            return true;
        }

        CivilValidation civilValidation = new CivilValidation(contributor);
        return civilValidation.isValid();
    }

}
