package services;

import models.Contributor;

public class GeneralValidation implements IValidation {

    private Contributor contributor;

    public GeneralValidation(Contributor contributor) {
        this.contributor = contributor;
    }

    @Override
    public boolean isValid() {
        if (!contributor.isBlacklisted() && !contributor.isPreRetired()) {
            switch (contributor.getPublicInstitution()) {
                case ARMADA :
                    ArmadaValidation armadaValidation = new ArmadaValidation(contributor);
                    return armadaValidation.isValid();                    
                
                case NINGUNA:
                    CivilValidation civilValidation = new CivilValidation(contributor);
                    return civilValidation.isValid();
                
                case INPEC:
                    InpecValidation inpecValidation = new InpecValidation(contributor);
                    return inpecValidation.isValid();
                
                case MIN_INTERIOR:
                    MinInteriorValidation minInteriorValidation = new MinInteriorValidation(contributor);
                    return minInteriorValidation.isValid();
                
                case MIN_SALUD:
                    MinSaludValidation minSaludValidation = new MinSaludValidation(contributor);
                    return minSaludValidation.isValid();

                case POLICIA:
                    PoliceValidation policeValidation = new PoliceValidation(contributor);
                    return policeValidation.isValid();

                default:
                    break;
            } 
        }
        return false;
    }

}
