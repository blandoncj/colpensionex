package services;

import java.time.LocalDate;

import models.Contributor;

public class MinSaludValidation implements IValidation {

    private Contributor contributor;

    public MinSaludValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        if (!contributor.hasDisciplinaryObservation()) {
            return true;
        }
        contributor.setBlacklistDate(LocalDate.now());
        return false;
    }

}
