package be.volders.vaccinapp.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * The class responsible for handling all actions and properties of a Patient.
 *
 * @author  Gaetan Dumortier, Pieter Volders
 * @since   27 november 2019
 */
public class Patient implements Serializable {

    private Date dob;
    private boolean riskGroup;

    /**
     * Constructor.
     * @param dob the date of birth of the patient
     * @param riskGroup Whether the patient is considered to be in a risk group or not
     */
    public Patient(Date dob, boolean riskGroup) {
        this.dob = dob;
        this.riskGroup = riskGroup;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFormattedDob() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH).format(this.dob);
    }

    public boolean isRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(boolean riskGroup) {
        this.riskGroup = riskGroup;
    }

}
