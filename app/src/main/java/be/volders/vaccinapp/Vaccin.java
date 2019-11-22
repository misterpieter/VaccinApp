package be.volders.vaccinapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vaccin {

    private String naam;
    private List<String> ziektes;
    private List<Date> toedienData;
    private List<Integer> weekInterval;
    private String info;

    public Vaccin() {
        this("naam", "info");
    }

    public Vaccin(String naam, String info) {
        this.naam = naam;
        this.ziektes = new ArrayList<>();
        this.toedienData = new ArrayList<>();
        this.weekInterval = new ArrayList<>();
        ;
        this.info = info;
    }
}