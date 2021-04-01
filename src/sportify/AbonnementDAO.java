/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kais
 */
public class AbonnementDAO {
      Connection connection = DBConnection.getInstance().getConnexion();
      
       public ArrayList<Abonnement> findAll(){
        ArrayList<Abonnement> events = new ArrayList(); 
        String query = "SELECT * FROM abonnement ORDER BY date_debut";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                Abonnement event = new Abonnement();
                event.setId(rs.getInt("id"));
                event.setType(rs.getString("type"));
                event.setDateDebut(rs.getDate("date_debut"));
                event.setDuree(rs.getInt("duree"));
                event.setPrix(rs.getInt("prix"));
                        
                
                events.add(event);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return events;
    }
       
       
     public ArrayList<Abonnement> findByType(int id){
        ArrayList<Abonnement> events = new ArrayList(); 
        String query = "";
        if(id != -1) {
            query = "SELECT * FROM abonnement WHERE id=" + id + " ORDER BY date_debut";
        }else {
            query = "SELECT * FROM abonnement ORDER BY date_debut";
        }
        
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                Abonnement event = new Abonnement();
                event.setId(rs.getInt("id"));
                event.setType(rs.getString("type"));
                event.setDateDebut(rs.getDate("date_debut"));
                event.setDuree(rs.getInt("duree"));
                event.setPrix(rs.getInt("prix"));
                        
                
                events.add(event);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return events;
    }
       
       
    public void save(Abonnement e){
        String  query  = "INSERT INTO abonnement (type, date_debut, duree, prix) VALUES (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, e.getType());
            ps.setDate (2, e.getDateDebut());
            ps.setInt (3, e.getDuree());
            ps.setFloat (4, e.getPrix());
            ps.execute();
                            try {
                    JavaMail.sendMail("kais.fellah@esprit.tn", "Notification", "Un nouveau evenement vient d'etre lancer");
                } catch (Exception ex) {
                    Logger.getLogger(AbonnementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println("Abonnement & été ajouté avec succée");
        } catch (SQLException ex) {
            System.out.println("Erreur lors l'ajout");
            System.err.println(ex.getMessage());
        }
    }
    public void delete(int id){
        String query = "DELETE FROM abonnement WHERE id=?";
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void update(Abonnement e){
        String  query  = "UPDATE abonnement SET type = ?, date_debut = ?, duree = ?, prix = ?  Where id = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, e.getType());
            ps.setDate   (2, e.getDateDebut());
            ps.setInt   (3, e.getDuree());
            ps.setFloat   (4, e.getPrix());
            ps.setInt    (5, e.getId());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
     
     
    public Abonnement findOne(String id){
        String query = "SELECT * FROM abonnement WHERE id = ?";
        PreparedStatement preparedStmt;
        Abonnement e = new Abonnement();
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                e.setId(rs.getInt("id"));
                e.setType(rs.getString("type"));
                e.setDateDebut(rs.getDate("date_debut"));
                e.setDuree(rs.getInt("duree"));
                e.setPrix(rs.getInt("prix"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return e;
    }
    
    public ArrayList getStat(){
        String q1 = "SELECT count(*) as d FROM abonnement WHERE date_debut>='2021-01-01' and date_debut<= '2021-03-31'";
        String q2 = "SELECT count(*) as d FROM abonnement WHERE date_debut>='2021-04-01' and date_debut<= '2021-06-30'";
        String q3 = "SELECT count(*) as d FROM abonnement WHERE date_debut>='2021-07-01' and date_debut<= '2021-09-31'";
        String q4 = "SELECT count(*) as d FROM abonnement WHERE date_debut>='2021-10-01' and date_debut<= '2021-12-31'";
        PreparedStatement preparedStmt1;
        PreparedStatement preparedStmt2;
        PreparedStatement preparedStmt3;
        PreparedStatement preparedStmt4;
        ArrayList data = new ArrayList();
        try{
            preparedStmt1 = connection.prepareStatement(q1);
            ResultSet rs = preparedStmt1.executeQuery();
            while ( rs.next() ){
            data.add(rs.getInt("d"));
            }
            
            preparedStmt2 = connection.prepareStatement(q2);
            ResultSet rs2 = preparedStmt2.executeQuery();
            while ( rs2.next() ){
            data.add(rs2.getInt("d"));
            }
            
            preparedStmt3 = connection.prepareStatement(q3);
            ResultSet rs3 = preparedStmt3.executeQuery();
            while ( rs3.next() ){
            data.add(rs3.getInt("d"));
            }
            
            preparedStmt4 = connection.prepareStatement(q4);
            ResultSet rs4 = preparedStmt4.executeQuery();
            while ( rs4.next() ){
            data.add(rs4.getInt("d"));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.print(data);
        return data;
        
    }
}
