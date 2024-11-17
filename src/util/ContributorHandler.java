package util;

import java.util.LinkedHashMap;
import java.util.Map;

import enums.Characterization;
import enums.Gender;
import enums.PensionFund;
import enums.PublicInstitution;
import models.Contributor;

public class ContributorHandler extends CSVHandler<Contributor> {

    public ContributorHandler(String filePath) {
        super(filePath);
    }

    @Override
    protected Contributor mapToEntity(Map<String, Object> row) {
        String idType = row.get("idType").toString();
        String id = row.get("id").toString();
        String fullname = row.get("fullname").toString();
        String city = row.get("city").toString();
        int age = Integer.parseInt(row.get("age").toString());
        int weeksContributed = Integer.parseInt(row.get("weeksContributed").toString());
        boolean isDecorated = Boolean.parseBoolean(row.get("isDecorated").toString());
        boolean hasChildrenInInpec = Boolean.parseBoolean(row.get("hasChildrenInInpec").toString());
        boolean hasFamilyInPolice = Boolean.parseBoolean(row.get("hasFamilyInPolice").toString());
        boolean hasDisciplinaryObservation = Boolean.parseBoolean(row.get("hasDisciplinaryObservation").toString());
        boolean isPreRetired = Boolean.parseBoolean(row.get("isPreRetired").toString());
        boolean isBlacklisted = Boolean.parseBoolean(row.get("isBlacklisted").toString());
        PublicInstitution publicInstitution = PublicInstitution.valueOf(row.get("publicInstitution").toString());
        PensionFund pensionFund = PensionFund.valueOf(row.get("pensionFund").toString());
        Characterization characterization = Characterization.valueOf(row.get("characterization").toString());
        Gender gender = Gender.valueOf(row.get("gender").toString());

        return new Contributor(idType, id, fullname, city, age, weeksContributed, isDecorated, hasChildrenInInpec,
                hasFamilyInPolice, hasDisciplinaryObservation, isPreRetired, isBlacklisted, publicInstitution,
                pensionFund, characterization, gender);
    }

    @Override
    protected Map<String, Object> entityToMap(Contributor contributor) {
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("idType", contributor.getIdType());
        row.put("id", contributor.getId());
        row.put("fullname", contributor.getFullname());
        row.put("city", contributor.getCity());
        row.put("age", contributor.getAge());
        row.put("weeksContributed", contributor.getWeeksContributed());
        row.put("isDecorated", contributor.isDecorated());
        row.put("hasChildrenInInpec", contributor.hasChildrenInInpec());
        row.put("hasFamilyInPolice", contributor.hasFamilyInPolice());
        row.put("hasDisciplinaryObservation", contributor.hasDisciplinaryObservation());
        row.put("isPreRetired", contributor.isPreRetired());
        row.put("isBlacklisted", contributor.isBlacklisted());
        row.put("publicInstitution", contributor.getPublicInstitution());
        row.put("pensionFund", contributor.getPensionFund());
        row.put("characterization", contributor.getCharacterization());
        row.put("Gender", contributor.getGender());

        return row;
    }

}