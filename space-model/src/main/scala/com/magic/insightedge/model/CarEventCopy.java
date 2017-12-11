package com.magic.insightedge.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * @author Vitalii Zinchenko
 */
@SpaceClass
public class CarEventCopy {

    private Integer ID;
    private String RECHNERBEZ;
    private String DCELINK_ID;
    private String SCHWEISSGERAETE_NAME;
    private String ORTSNUMMER;
    private Integer WIP;
    private String BOLZEN_ID;
    private String KAROSSERIE_ID;
    private String AUSGANGS_ID;
    private String SCHWEISSPROGRAMM_ID;
    private String SCHWEISSSTROM_IST;
    private Double SCHWEISSZEIT_IST;
    private Double UL_HAUPTSTROM_IST;
    private Double UL_VORSTROM_IST;
    private Double HUBHOEHE_IST;
    private String HUBHOEHE_SOLL;
    private Double ABFALLZEIT_IST;
    private String ABFALLZEIT_SOLL;
    private Double DURCHDRINGUNG_IST;
    private Double SCHWEISSENERGIE_IST;
    private Boolean replicated;

    @SpaceId
    public Integer getID() {
        return ID;
    }

    public CarEventCopy setID(Integer ID) {
        this.ID = ID;
        return this;
    }

    public String getRECHNERBEZ() {
        return RECHNERBEZ;
    }

    public CarEventCopy setRECHNERBEZ(String RECHNERBEZ) {
        this.RECHNERBEZ = RECHNERBEZ;
        return this;
    }

    public String getDCELINK_ID() {
        return DCELINK_ID;
    }

    public CarEventCopy setDCELINK_ID(String DCELINK_ID) {
        this.DCELINK_ID = DCELINK_ID;
        return this;
    }

    public String getSCHWEISSGERAETE_NAME() {
        return SCHWEISSGERAETE_NAME;
    }

    public CarEventCopy setSCHWEISSGERAETE_NAME(String SCHWEISSGERAETE_NAME) {
        this.SCHWEISSGERAETE_NAME = SCHWEISSGERAETE_NAME;
        return this;
    }

    public String getORTSNUMMER() {
        return ORTSNUMMER;
    }

    public CarEventCopy setORTSNUMMER(String ORTSNUMMER) {
        this.ORTSNUMMER = ORTSNUMMER;
        return this;
    }

    public Integer getWIP() {
        return WIP;
    }

    public CarEventCopy setWIP(Integer WIP) {
        this.WIP = WIP;
        return this;
    }

    public String getBOLZEN_ID() {
        return BOLZEN_ID;
    }

    public CarEventCopy setBOLZEN_ID(String BOLZEN_ID) {
        this.BOLZEN_ID = BOLZEN_ID;
        return this;
    }

    public String getKAROSSERIE_ID() {
        return KAROSSERIE_ID;
    }

    public CarEventCopy setKAROSSERIE_ID(String KAROSSERIE_ID) {
        this.KAROSSERIE_ID = KAROSSERIE_ID;
        return this;
    }

    public String getAUSGANGS_ID() {
        return AUSGANGS_ID;
    }

    public CarEventCopy setAUSGANGS_ID(String AUSGANGS_ID) {
        this.AUSGANGS_ID = AUSGANGS_ID;
        return this;
    }

    public String getSCHWEISSPROGRAMM_ID() {
        return SCHWEISSPROGRAMM_ID;
    }

    public CarEventCopy setSCHWEISSPROGRAMM_ID(String SCHWEISSPROGRAMM_ID) {
        this.SCHWEISSPROGRAMM_ID = SCHWEISSPROGRAMM_ID;
        return this;
    }

    public String getSCHWEISSSTROM_IST() {
        return SCHWEISSSTROM_IST;
    }

    public CarEventCopy setSCHWEISSSTROM_IST(String SCHWEISSSTROM_IST) {
        this.SCHWEISSSTROM_IST = SCHWEISSSTROM_IST;
        return this;
    }

    public Double getSCHWEISSZEIT_IST() {
        return SCHWEISSZEIT_IST;
    }

    public CarEventCopy setSCHWEISSZEIT_IST(Double SCHWEISSZEIT_IST) {
        this.SCHWEISSZEIT_IST = SCHWEISSZEIT_IST;
        return this;
    }

    public Double getUL_HAUPTSTROM_IST() {
        return UL_HAUPTSTROM_IST;
    }

    public CarEventCopy setUL_HAUPTSTROM_IST(Double UL_HAUPTSTROM_IST) {
        this.UL_HAUPTSTROM_IST = UL_HAUPTSTROM_IST;
        return this;
    }

    public Double getUL_VORSTROM_IST() {
        return UL_VORSTROM_IST;
    }

    public CarEventCopy setUL_VORSTROM_IST(Double UL_VORSTROM_IST) {
        this.UL_VORSTROM_IST = UL_VORSTROM_IST;
        return this;
    }

    public Double getHUBHOEHE_IST() {
        return HUBHOEHE_IST;
    }

    public CarEventCopy setHUBHOEHE_IST(Double HUBHOEHE_IST) {
        this.HUBHOEHE_IST = HUBHOEHE_IST;
        return this;
    }

    public String getHUBHOEHE_SOLL() {
        return HUBHOEHE_SOLL;
    }

    public CarEventCopy setHUBHOEHE_SOLL(String HUBHOEHE_SOLL) {
        this.HUBHOEHE_SOLL = HUBHOEHE_SOLL;
        return this;
    }

    public Double getABFALLZEIT_IST() {
        return ABFALLZEIT_IST;
    }

    public CarEventCopy setABFALLZEIT_IST(Double ABFALLZEIT_IST) {
        this.ABFALLZEIT_IST = ABFALLZEIT_IST;
        return this;
    }

    public String getABFALLZEIT_SOLL() {
        return ABFALLZEIT_SOLL;
    }

    public CarEventCopy setABFALLZEIT_SOLL(String ABFALLZEIT_SOLL) {
        this.ABFALLZEIT_SOLL = ABFALLZEIT_SOLL;
        return this;
    }

    public Double getDURCHDRINGUNG_IST() {
        return DURCHDRINGUNG_IST;
    }

    public CarEventCopy setDURCHDRINGUNG_IST(Double DURCHDRINGUNG_IST) {
        this.DURCHDRINGUNG_IST = DURCHDRINGUNG_IST;
        return this;
    }

    public Double getSCHWEISSENERGIE_IST() {
        return SCHWEISSENERGIE_IST;
    }

    public CarEventCopy setSCHWEISSENERGIE_IST(Double SCHWEISSENERGIE_IST) {
        this.SCHWEISSENERGIE_IST = SCHWEISSENERGIE_IST;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEventCopy that = (CarEventCopy) o;

        if (ID != null ? !ID.equals(that.ID) : that.ID != null) return false;
        if (RECHNERBEZ != null ? !RECHNERBEZ.equals(that.RECHNERBEZ) : that.RECHNERBEZ != null) return false;
        if (DCELINK_ID != null ? !DCELINK_ID.equals(that.DCELINK_ID) : that.DCELINK_ID != null) return false;
        if (SCHWEISSGERAETE_NAME != null ? !SCHWEISSGERAETE_NAME.equals(that.SCHWEISSGERAETE_NAME) : that.SCHWEISSGERAETE_NAME != null)
            return false;
        if (ORTSNUMMER != null ? !ORTSNUMMER.equals(that.ORTSNUMMER) : that.ORTSNUMMER != null) return false;
        if (WIP != null ? !WIP.equals(that.WIP) : that.WIP != null) return false;
        if (BOLZEN_ID != null ? !BOLZEN_ID.equals(that.BOLZEN_ID) : that.BOLZEN_ID != null) return false;
        if (KAROSSERIE_ID != null ? !KAROSSERIE_ID.equals(that.KAROSSERIE_ID) : that.KAROSSERIE_ID != null)
            return false;
        if (AUSGANGS_ID != null ? !AUSGANGS_ID.equals(that.AUSGANGS_ID) : that.AUSGANGS_ID != null) return false;
        if (SCHWEISSPROGRAMM_ID != null ? !SCHWEISSPROGRAMM_ID.equals(that.SCHWEISSPROGRAMM_ID) : that.SCHWEISSPROGRAMM_ID != null)
            return false;
        if (SCHWEISSSTROM_IST != null ? !SCHWEISSSTROM_IST.equals(that.SCHWEISSSTROM_IST) : that.SCHWEISSSTROM_IST != null)
            return false;
        if (SCHWEISSZEIT_IST != null ? !SCHWEISSZEIT_IST.equals(that.SCHWEISSZEIT_IST) : that.SCHWEISSZEIT_IST != null)
            return false;
        if (UL_HAUPTSTROM_IST != null ? !UL_HAUPTSTROM_IST.equals(that.UL_HAUPTSTROM_IST) : that.UL_HAUPTSTROM_IST != null)
            return false;
        if (UL_VORSTROM_IST != null ? !UL_VORSTROM_IST.equals(that.UL_VORSTROM_IST) : that.UL_VORSTROM_IST != null)
            return false;
        if (HUBHOEHE_IST != null ? !HUBHOEHE_IST.equals(that.HUBHOEHE_IST) : that.HUBHOEHE_IST != null) return false;
        if (HUBHOEHE_SOLL != null ? !HUBHOEHE_SOLL.equals(that.HUBHOEHE_SOLL) : that.HUBHOEHE_SOLL != null)
            return false;
        if (ABFALLZEIT_IST != null ? !ABFALLZEIT_IST.equals(that.ABFALLZEIT_IST) : that.ABFALLZEIT_IST != null)
            return false;
        if (ABFALLZEIT_SOLL != null ? !ABFALLZEIT_SOLL.equals(that.ABFALLZEIT_SOLL) : that.ABFALLZEIT_SOLL != null)
            return false;
        if (DURCHDRINGUNG_IST != null ? !DURCHDRINGUNG_IST.equals(that.DURCHDRINGUNG_IST) : that.DURCHDRINGUNG_IST != null)
            return false;
        return SCHWEISSENERGIE_IST != null ? SCHWEISSENERGIE_IST.equals(that.SCHWEISSENERGIE_IST) : that.SCHWEISSENERGIE_IST == null;
    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (RECHNERBEZ != null ? RECHNERBEZ.hashCode() : 0);
        result = 31 * result + (DCELINK_ID != null ? DCELINK_ID.hashCode() : 0);
        result = 31 * result + (SCHWEISSGERAETE_NAME != null ? SCHWEISSGERAETE_NAME.hashCode() : 0);
        result = 31 * result + (ORTSNUMMER != null ? ORTSNUMMER.hashCode() : 0);
        result = 31 * result + (WIP != null ? WIP.hashCode() : 0);
        result = 31 * result + (BOLZEN_ID != null ? BOLZEN_ID.hashCode() : 0);
        result = 31 * result + (KAROSSERIE_ID != null ? KAROSSERIE_ID.hashCode() : 0);
        result = 31 * result + (AUSGANGS_ID != null ? AUSGANGS_ID.hashCode() : 0);
        result = 31 * result + (SCHWEISSPROGRAMM_ID != null ? SCHWEISSPROGRAMM_ID.hashCode() : 0);
        result = 31 * result + (SCHWEISSSTROM_IST != null ? SCHWEISSSTROM_IST.hashCode() : 0);
        result = 31 * result + (SCHWEISSZEIT_IST != null ? SCHWEISSZEIT_IST.hashCode() : 0);
        result = 31 * result + (UL_HAUPTSTROM_IST != null ? UL_HAUPTSTROM_IST.hashCode() : 0);
        result = 31 * result + (UL_VORSTROM_IST != null ? UL_VORSTROM_IST.hashCode() : 0);
        result = 31 * result + (HUBHOEHE_IST != null ? HUBHOEHE_IST.hashCode() : 0);
        result = 31 * result + (HUBHOEHE_SOLL != null ? HUBHOEHE_SOLL.hashCode() : 0);
        result = 31 * result + (ABFALLZEIT_IST != null ? ABFALLZEIT_IST.hashCode() : 0);
        result = 31 * result + (ABFALLZEIT_SOLL != null ? ABFALLZEIT_SOLL.hashCode() : 0);
        result = 31 * result + (DURCHDRINGUNG_IST != null ? DURCHDRINGUNG_IST.hashCode() : 0);
        result = 31 * result + (SCHWEISSENERGIE_IST != null ? SCHWEISSENERGIE_IST.hashCode() : 0);
        return result;
    }

    public Boolean getReplicated() {
        return replicated;
    }

    public CarEventCopy setReplicated(Boolean replicated) {
        this.replicated = replicated;
        return this;
    }
}
