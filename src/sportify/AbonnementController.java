/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportify;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AbonnementController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextField dr;
    @FXML
    private TextField dd;
    @FXML
    private TextField pr;

    int id;

    AbonnementDAO dao = new AbonnementDAO();
    @FXML
    private Button suppBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierB(ActionEvent event) {
        java.sql.Date dateD = java.sql.Date.valueOf(dd.getText());
        Abonnement e = dao.findOne(String.valueOf(this.id));
        e.setType(type.getText());
        e.setDateDebut(dateD);
        e.setDuree(Integer.parseInt(dr.getText()));
        e.setPrix(Float.parseFloat(pr.getText()));
        dao.update(e);
        
        
        Stage stage = (Stage) suppBtn.getScene().getWindow();
    // do what you have to do
        stage.close();
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("abonnementlist.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supp(ActionEvent event) {
        dao.delete(this.id);
        Stage stage = (Stage) suppBtn.getScene().getWindow();
    // do what you have to do
        stage.close();
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("abonnementlist.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AbonnementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }


void initData(Abonnement e) {
    
       
        this.type.setText(String.valueOf(e.getType()));
        this.dd.setText(e.getDateDebut().toString());
        this.dr.setText(Integer.toString(e.getDuree()));
        this.pr.setText(Float.toString(e.getPrix()));
        this.id = e.getId();
  }    

 
    @FXML
    private void eventRedirect(MouseEvent event) {
         Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("eventlist.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void redirectevent(MouseEvent event) {
    }

    @FXML
    private void promoRedirect(MouseEvent event) {
          Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("pormolist.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
