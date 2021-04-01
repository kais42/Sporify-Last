/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportify;

import java.sql.Date;
import javafx.scene.control.Button;

/**
 *
 * @author Kais
 */
public class Abonnement {
    private int id ;
    private String type ;
    private Date dateDebut ;
    private int duree ;
    private float prix ;
    private Button action;
    private Button actionModif;

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public Button getActionModif() {
        return actionModif;
    }

    public void setActionModif(Button actionModif) {
        this.actionModif = actionModif;
    }
    
    public Abonnement() {
        this.action = new Button("Voir");
        this.actionModif = new Button("Modifier");
    }

    public Abonnement(String type, String description, Date dateDebut, int duree, int prix) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.prix = prix;
        
        this.action = new Button("Voir");
        this.actionModif = new Button("Modifier");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", type=" + type +  ", dateDebut=" + dateDebut
                + ", duree=" + duree+ ", prix=" + prix + '}';
    }
    
    
    
    
    
}
