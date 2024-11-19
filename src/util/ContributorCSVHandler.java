package util;

import models.Contributor;
import enums.Characterization;
import enums.Gender;
import enums.PensionFund;
import enums.PublicInstitution;

import java.time.LocalDate;
import java.util.*;

public class ContributorCSVHandler extends CSVHandler<Contributor> {

    public ContributorCSVHandler(String filePath) {
        super(filePath);
    }

    @Override
    protected Map<String, Object> entityToMap(Contributor entity) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("idType", entity.getIdType());
        map.put("id", entity.getId());
        map.put("fullname", entity.getFullname());
        map.put("city", entity.getCity());
        map.put("age", String.valueOf(entity.getAge()));
        map.put("weeksContributed", String.valueOf(entity.getWeeksContributed()));
        map.put("savings", String.valueOf(entity.getSavings()));
        map.put("isDecorated", String.valueOf(entity.isDecorated()));
        map.put("hasChildrenInInpec", String.valueOf(entity.hasChildrenInInpec()));
        map.put("hasFamilyInPolice", String.valueOf(entity.hasFamilyInPolice()));
        map.put("hasDisciplinaryObservation", String.valueOf(entity.hasDisciplinaryObservation()));
        map.put("isPreRetired", String.valueOf(entity.isPreRetired()));
        map.put("blacklistDate", entity.isBlacklisted() ? entity.getBlacklistDate().toString() : "");
        map.put("publicInstitution", entity.getPublicInstitution().name());
        map.put("pensionFund", entity.getPensionFund().name());
        map.put("characterization", entity.getCharacterization().name());
        map.put("gender", entity.getGender().name());
        return map;
    }

    @Override
    protected Contributor mapToEntity(Map<String, Object> row) {
        Contributor contributor = new Contributor();
        contributor.setIdType(cleanString((String) row.get("idType")));
        contributor.setId(cleanString((String) row.get("id")));
        contributor.setFullname(cleanString((String) row.get("fullname")));
        contributor.setCity(cleanString((String) row.get("city")));
        contributor.setAge(Integer.parseInt(cleanString((String) row.get("age"))));
        contributor.setWeeksContributed(Integer.parseInt(cleanString((String) row.get("weeksContributed"))));
        contributor.setSavings(Double.parseDouble(cleanString((String) row.get("savings"))));
        contributor.setDecorated(Boolean.parseBoolean(cleanString((String) row.get("isDecorated"))));
        contributor.setHasChildrenInInpec(Boolean.parseBoolean(cleanString((String) row.get("hasChildrenInInpec"))));
        contributor.setHasFamilyInPolice(Boolean.parseBoolean(cleanString((String) row.get("hasFamilyInPolice"))));
        contributor.setHasDisciplinaryObservation(Boolean.parseBoolean(cleanString((String) row.get("hasDisciplinaryObservation"))));
        contributor.setPreRetired(Boolean.parseBoolean(cleanString((String) row.get("isPreRetired"))));
        String blacklistDateStr = cleanString((String) row.get("blacklistDate"));
        if (!blacklistDateStr.isEmpty()) {
            contributor.setBlacklistDate(LocalDate.parse(blacklistDateStr));
        }
        contributor.setPublicInstitution(PublicInstitution.valueOf(cleanString((String) row.get("publicInstitution"))));
        contributor.setPensionFund(PensionFund.valueOf(cleanString((String) row.get("pensionFund"))));
        contributor.setCharacterization(Characterization.valueOf(cleanString((String) row.get("characterization"))));
        contributor.setGender(Gender.valueOf(cleanString((String) row.get("gender"))));
        return contributor;
    }

    private String cleanString(String value) {
        return value.trim().replaceAll("^\\[|\\]$", "");
    }

    public List<Map<String, Object>> getCache() {
        return super.cache;
    }
}