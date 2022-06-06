package com.ensi.project;

import Controlers.GestionMessage;
import Models.Connexion;
import Models.Message;

import java.sql.SQLException;

import static Controlers.GestionMessage.*;

public class Main {

    public static void main(String[] args)  {
        Message msg = new Message("linkazzz@gmail.com","cc","15-03-22","hahaha");
        Connexion.connect();
        //GestionMessage.Envoyer_msg(msg);
        /*Afficher_msg_lus();
        AffichermsgNonlus();
        Supprimer_MSG();
        modifier_etat();
        modifier_msg();
        Afficher();*/
        Annee_Envoi();
    }
}
