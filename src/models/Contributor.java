package models;

import java.time.LocalDate;

import enums.Characterization;
import enums.Gender;
import enums.PensionFund;
import enums.PublicInstitution;

public class Contributor {

    private String idType;
    private String id;
    private String fullname;
    private String city;
    private int age;
    private int weeksContributed;
    private boolean isDecorated;
    private boolean hasChildrenInInpec;
    private boolean hasFamilyInPolice;
    private boolean hasDisciplinaryObservation;
    private boolean isPreRetired;
    private LocalDate blacklistDate;
    private PublicInstitution publicInstitution;
    private PensionFund pensionFund;
    private Characterization characterization;
    private Gender gender;

    public Contributor() {
    }

    public Contributor(String idType, String id, String fullname, String city, int age, int weeksContributed,
            boolean isDecorated, boolean hasChildrenInInpec, boolean hasFamilyInPolice,
            boolean hasDisciplinaryObservation, boolean isPreRetired, boolean isBlacklisted,
            PublicInstitution publicInstitution, PensionFund pensionFund, Characterization characterization, Gender gender) {

        this.idType = idType;
        this.id = id;
        this.fullname = fullname;
        this.city = city;
        this.age = age;
        this.weeksContributed = weeksContributed;
        this.isDecorated = isDecorated;
        this.hasChildrenInInpec = hasChildrenInInpec;
        this.hasFamilyInPolice = hasFamilyInPolice;
        this.hasDisciplinaryObservation = hasDisciplinaryObservation;
        this.isPreRetired = isPreRetired;
        this.publicInstitution = publicInstitution;
        this.pensionFund = pensionFund;
        this.characterization = characterization;
        this.gender = gender;

    }
   
    @Override
    public String toString() {
        return "Contributor [age=" + age + ", characterization=" + characterization + ", city=" + city + ", fullname="
                + fullname + ", hasChildrenInInpec=" + hasChildrenInInpec + ", hasDisciplinaryObservation="
                + hasDisciplinaryObservation + ", hasFamilyInPolice=" + hasFamilyInPolice + ", id=" + id + ", idType="
                + idType + ", isDecorated=" + isDecorated + ", isPreRetired="
                + isPreRetired + ", pensionFund=" + pensionFund + ", publicInstitution=" + publicInstitution
                + ", weeksContributed=" + weeksContributed + ", gender= " + gender + "]";
    }

    public String getIdType() {
        return idType;
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public int getWeeksContributed() {
        return weeksContributed;
    }

    public boolean isDecorated() {
        return isDecorated;
    }

    public boolean hasChildrenInInpec() {
        return hasChildrenInInpec;
    }

    public boolean hasFamilyInPolice() {
        return hasFamilyInPolice;
    }

    public boolean hasDisciplinaryObservation() {
        return hasDisciplinaryObservation;
    }

    public boolean isPreRetired() {
        return isPreRetired;
    }

    public boolean isBlacklisted() {
        if (blacklistDate == null) {
            return false;
        }

        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return blacklistDate.isAfter(sixMonthsAgo);
    }

    public PublicInstitution getPublicInstitution() {
        return publicInstitution;
    }

    public PensionFund getPensionFund() {
        return pensionFund;
    }

    public Characterization getCharacterization() {
        return characterization;
    }

    public Gender getGender() {
        return gender;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeeksContributed(int weeksContributed) {
        this.weeksContributed = weeksContributed;
    }

    public void setDecorated(boolean isDecorated) {
        this.isDecorated = isDecorated;
    }

    public void setHasChildrenInInpec(boolean hasChildrenInInpec) {
        this.hasChildrenInInpec = hasChildrenInInpec;
    }

    public void setHasFamilyInPolice(boolean hasFamilyInPolice) {
        this.hasFamilyInPolice = hasFamilyInPolice;
    }

    public void setHasDisciplinaryObservation(boolean hasDisciplinaryObservation) {
        this.hasDisciplinaryObservation = hasDisciplinaryObservation;
    }

    public void setPreRetired(boolean isPreRetired) {
        this.isPreRetired = isPreRetired;
    }

    public void setBlacklistDate(LocalDate blacklistDate) {
        this.blacklistDate = blacklistDate;
    }

    public void setPublicInstitution(PublicInstitution publicInstitution) {
        this.publicInstitution = publicInstitution;
    }

    public void setPensionFund(PensionFund pensionFund) {
        this.pensionFund = pensionFund;
    }

    public void setCharacterization(Characterization characterization) {
        this.characterization = characterization;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
