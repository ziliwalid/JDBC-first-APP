package Models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Message {
    private int id;
    private String Address_exp;
    private String sujet;
    private String Date_envoie;
    private String Contenue;
    private int etat;


    public Message(String address_exp, String sujet, String date_envoie, String contenue) {
        Address_exp = address_exp;
        this.sujet = sujet;
        Date_envoie = date_envoie;
        Contenue = contenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress_exp() {
        return Address_exp;
    }

    public void setAddress_exp(String address_exp) {
        Address_exp = address_exp;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDate_envoie() {
        return Date_envoie;
    }

    public void setDate_envoie(String date_envoie) {
        Date_envoie = date_envoie;
    }

    public String getContenue() {
        return Contenue;
    }

    public void setContenue(String contenue) {
        Contenue = contenue;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

}
