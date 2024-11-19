package services;

import models.Contributor;
import util.Blacklist;

public class ContributorValidator {

    private Blacklist blacklist;

    public ContributorValidator(Blacklist blacklist) {
        this.blacklist = blacklist;
    }

    public boolean validar(Contributor cotizante) {
        // Aquí implementas las reglas de validación
        if (blacklist.contains(cotizante.getId())) {
            return false;
        }
        // Validaciones adicionales pueden ir aquí
        return true;
    }
}
