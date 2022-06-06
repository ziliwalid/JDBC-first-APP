package Controlers;

import Models.Connexion;
import Models.Message;

import java.sql.*;
import java.util.Scanner;

public class GestionMessage {
    static Scanner in = new Scanner(System.in);

    public static void Envoyer_msg(Message msg)  {
        try{
            Connection link = Connexion.connect();
            PreparedStatement ps = link.prepareStatement(""
                    +"INSERT INTO message( adress_exp, sujet, date_envoie, contenue)"
                    +"values(?,?,?,?)");
            ps.setString(1, msg.getAddress_exp());
            ps.setString(2, msg.getSujet());
            ps.setString(3, msg.getDate_envoie());
            ps.setString(4, msg.getContenue());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void Afficher(){
        try{
            Connection link = Connexion.connect();
            String QUERY ="select * from message";
            Statement stm= link.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            int count = 0;
            while (rs.next()){
                count++;
                System.out.println(count+"-"+" address d'envoie: "+rs.getString("adress_exp"));
                System.out.println("sujet: "+rs.getString("sujet"));
                System.out.println("contenue: "+rs.getString("contenue"));
                System.out.println("date d'envoie: "+rs.getString("date_envoie"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void AffichermsgNonlus(){
        try{
            Connection link = Connexion.connect();
            String QUERY ="select * from message where etat=0";
            Statement stm= link.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            int count = 0;
            while (rs.next()){
                count++;
                System.out.println(count+"-"+" address d'envoie: "+rs.getString("adress_exp"));
                System.out.println("sujet: "+rs.getString("sujet"));
                System.out.println("contenue: "+rs.getString("contenue"));
                System.out.println("date d'envoie: "+rs.getString("date_envoie"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void AfficherParMoi(){
        try{
            Connection link = Connexion.connect();
            System.out.print("veuillez saisir le mois du mail que vous voulez affichez: ");
            String month = in.next();
            String QUERY ="select * from message where date_envoie LIKE '___"+month+"%'";
            Statement stm= link.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            int count = 0;
            while (rs.next()){
                count++;
                System.out.println(count+"-"+" address d'envoie: "+rs.getString("adress_exp"));
                System.out.println("sujet: "+rs.getString("sujet"));
                System.out.println("contenue: "+rs.getString("contenue"));
                System.out.println("date d'envoie: "+rs.getString("date_envoie"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void modifier_etat()  {
        try{
            Connection link = Connexion.connect();
            System.out.print("veuillez saisir l'id' du mail que vous voulez modifier: ");
            String id = in.next();
            PreparedStatement ps = link.prepareStatement("UPDATE `message` SET `etat`='1' where id='"+id+"'");
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void Afficher_msg_lus(){
        try{
            Connection link = Connexion.connect();
            String QUERY ="select * from message where etat='1'";
            Statement stm= link.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            int count = 0;
            while (rs.next()){
                count++;
                System.out.println(count+"-"+" address d'envoie: "+rs.getString("adress_exp"));
                System.out.println("sujet: "+rs.getString("sujet"));
                System.out.println("contenue: "+rs.getString("contenue"));
                System.out.println("date d'envoie: "+rs.getString("date_envoie"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void Supprimer_MSG(){
        try{
            Connection link = Connexion.connect();
            System.out.print("veuillez saisir l'id' du mail que vous voulez supprimez: ");
            String id = in.next();
            PreparedStatement ps = link.prepareStatement("DELETE FROM `message` WHERE id='"+id+"'");
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void modifier_msg() {
        try {
            Connection link = Connexion.connect();
            System.out.print("veuillez saisir l'id' du mail que vous voulez modifier: ");
            String id = in.next();
            System.out.print("address d'envoie: ");
            String addr = in.next();
            System.out.print("sujet: ");
            String sujet = in.next();
            System.out.print("contenue: ");
            String contenue = in.next();
            PreparedStatement ps = link.prepareStatement("UPDATE `message` SET `etat`='1',`adress_exp`='" + addr + "',`sujet`='" + sujet + "',`contenue`='" + contenue + "' where id='" + id + "'");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void Annee_Envoi(){
        try{
            Connection link = Connexion.connect();
            System.out.print("veuillez saisir l'id' du mail dont vous voulez l'année de l'envoie: ");
            String id = in.next();
            String QUERY ="SELECT SUBSTRING(date_envoie,7,3) Annee from message where id='" + id + "'";
            Statement stm= link.createStatement();
            ResultSet rs = stm.executeQuery(QUERY);
            int count = 0;
            while (rs.next()){
                count++;
                System.out.println(count+"-"+" Année d'envoie: "+rs.getString("Annee"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
