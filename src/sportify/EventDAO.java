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
public class EventDAO {
      Connection connection = DBConnection.getInstance().getConnexion();
      
       public ArrayList<Event> findAll(){
        ArrayList<Event> events = new ArrayList(); 
        String query = "SELECT * FROM evenement ORDER BY date_debut";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setDescription(rs.getString("description"));
                event.setTitre(rs.getString("titre"));
                event.setDateDebut(rs.getDate("date_debut"));
                event.setDateFin(rs.getDate("date_fin"));
                        
                
                events.add(event);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return events;
    }
       
       
     public ArrayList<Event> findByTitre(String titre){
        ArrayList<Event> events = new ArrayList(); 
        String query = "SELECT * FROM evenement WHERE titre LIKE '%"+titre+"%' ORDER BY date_debut";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setDescription(rs.getString("description"));
                event.setTitre(rs.getString("titre"));
                event.setDateDebut(rs.getDate("date_debut"));
                event.setDateFin(rs.getDate("date_fin"));
                        
                
                events.add(event);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return events;
    }
       
       
    public void save(Event e){
        String  query  = "INSERT INTO evenement (titre, description, date_debut, date_fin) VALUES (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, e.getTitre());
            ps.setString(2, e.getDescription());
            ps.setDate (3, e.getDateDebut());
            ps.setDate (4, e.getDateFin());
            ps.execute();
                            try {
                    JavaMail.sendMail("kais.fellah@esprit.tn", "Notification", "Un nouveau evenement vient d'etre lancer");
                } catch (Exception ex) {
                    Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println("event & été ajouté avec succée");
        } catch (SQLException ex) {
            System.out.println("Erreur lors l'ajout");
            System.err.println(ex.getMessage());
        }
    }
    public void delete(int id){
        String query = "DELETE FROM evenement WHERE id=?";
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void update(Event e){
        String  query  = "UPDATE evenement SET titre = ?,description = ?, date_debut = ?,date_fin = ?  Where id = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, e.getTitre());
            ps.setString (2, e.getDescription());
            ps.setDate   (3, e.getDateDebut());
            ps.setDate   (4, e.getDateFin());
            ps.setInt    (5, e.getId());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
     
     
    public Event findOne(String id){
        String query = "SELECT * FROM evenement WHERE id = ?";
        PreparedStatement preparedStmt;
        Event e = new Event();
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                e.setId(rs.getInt("id"));
                e.setTitre(rs.getString("titre"));
                e.setDateDebut(rs.getDate("date_debut"));
                e.setDateFin(rs.getDate("date_fin"));
                e.setDescription(rs.getString("description"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return e;
    }
    
    public ArrayList getStat(){
        
        String q1 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-01-01' and date_debut<= '2021-01-31'";
        String q2 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-02-01' and date_debut<= '2021-02-28'";
        String q3 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-03-01' and date_debut<= '2021-03-31'";
        String q4 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-4-01' and date_debut<= '2021-4-30'";
        String q5 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-5-01' and date_debut<= '2021-5-31'";
        String q6 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-6-01' and date_debut<= '2021-6-30'";
        String q7 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-7-01' and date_debut<= '2021-7-31'";
        String q8 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-8-01' and date_debut<= '2021-8-31'";
        String q9 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-9-01' and date_debut<= '2021-9-30'";
        String q10 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-10-01' and date_debut<= '2021-10-31'";
        String q11 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-11-01' and date_debut<= '2021-11-31'";
        String q12 = "SELECT count(*) as d FROM evenement WHERE date_debut>='2021-12-01' and date_debut<= '2021-12-31'";
        PreparedStatement preparedStmt1;
        PreparedStatement preparedStmt2;
        PreparedStatement preparedStmt3;
        PreparedStatement preparedStmt4;
        PreparedStatement preparedStmt5;
        PreparedStatement preparedStmt6;
        PreparedStatement preparedStmt7;
        PreparedStatement preparedStmt8;
        PreparedStatement preparedStmt9;
        PreparedStatement preparedStmt10;
        PreparedStatement preparedStmt11;
        PreparedStatement preparedStmt12;
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
            
            preparedStmt5 = connection.prepareStatement(q5);
            ResultSet rs5 = preparedStmt5.executeQuery();
            while ( rs5.next() ){
            data.add(rs5.getInt("d"));
            }
            
            preparedStmt6 = connection.prepareStatement(q6);
            ResultSet rs6 = preparedStmt6.executeQuery();
            while ( rs6.next() ){
            data.add(rs6.getInt("d"));
            }
            
            preparedStmt7 = connection.prepareStatement(q7);
            ResultSet rs7 = preparedStmt7.executeQuery();
            while ( rs7.next() ){
            data.add(rs7.getInt("d"));
            }
            
            preparedStmt8 = connection.prepareStatement(q8);
            ResultSet rs8 = preparedStmt8.executeQuery();
            while ( rs8.next() ){
            data.add(rs8.getInt("d"));
            }
            
            preparedStmt9 = connection.prepareStatement(q9);
            ResultSet rs9 = preparedStmt9.executeQuery();
            while ( rs9.next() ){
            data.add(rs9.getInt("d"));
            }
            
            preparedStmt10 = connection.prepareStatement(q10);
            ResultSet rs10 = preparedStmt10.executeQuery();
            while ( rs10.next() ){
            data.add(rs10.getInt("d"));
            }
            
            preparedStmt11 = connection.prepareStatement(q11);
            ResultSet rs11 = preparedStmt11.executeQuery();
            while ( rs11.next() ){
            data.add(rs11.getInt("d"));
            }
            
            preparedStmt12 = connection.prepareStatement(q12);
            ResultSet rs12 = preparedStmt12.executeQuery();
            while ( rs12.next() ){
            data.add(rs12.getInt("d"));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.print(data);
        return data;
        
    }
    
}
