package be.volders.vaccinapp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The class responsible for handling all actions and properties of a Vaccin.
 *
 * @author  Gaetan Dumortier, Pieter Volders
 * @since   27 november 2019
 */
public class Vaccin implements Serializable {

    private String name;
    private List<String> disease;
    private List<Date> administerDate;
    private List<Integer> weekInterval;
    private String info;

    // Testing constructor
    public Vaccin(String name, String info) {
        this.name = name;
        this.info = info;
    }

    /**
     * Constructor.
     * @param name the name of the vaccin
     * @param disease the disease(s) the vaccin is used for
     * @param administerDate the dates of administering the vaccin
     * @param weekInterval the weekly intervals the vaccin requires
     * @param info additional vaccin information
     */
    public Vaccin(String name, List<String> disease, List<Date> administerDate, List<Integer> weekInterval, String info) {
        this.name = name;
        this.disease = disease;
        this.administerDate = administerDate;
        this.weekInterval = weekInterval;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDisease() {
        return disease;
    }

    public void setDisease(List<String> disease) {
        this.disease = disease;
    }

    public List<Date> getAdministerDate() {
        return administerDate;
    }

    public void setAdministerDate(List<Date> administerDate) {
        this.administerDate = administerDate;
    }

    public List<Integer> getWeekInterval() {
        return weekInterval;
    }

    public void setWeekInterval(List<Integer> weekInterval) {
        this.weekInterval = weekInterval;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}