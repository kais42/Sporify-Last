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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tray.notification.TrayNotification;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AbonnementInputController implements Initializable {
    
    @FXML
    DatePicker dd;
    
    @FXML
    private TextField dr;
    
    @FXML
    private ComboBox type = new ComboBox();
    
   
    @FXML
    private TextField pr;
    @FXML
    private Button add;
    
    @FXML
    public void ajouter(ActionEvent event){
        
        java.sql.Date dateD = java.sql.Date.valueOf(dd.getValue());
        
        Abonnement e = new Abonnement();
        
        e.setDateDebut(dateD);
        e.setType(type.getValue().toString().trim());
        e.setPrix(Float.parseFloat(pr.getText()));     
        e.setDuree(Integer.parseInt(dr.getText()));
        AbonnementDAO dao = new AbonnementDAO();     
        dao.save(e);
        Stage stage = (Stage) add.getScene().getWindow();
    // do what you have to do
        stage.close();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("abonnementlist.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String title = "Succée";
        String message = "Abonnement a été ajouté avec succée";
        
        

        NotificationType notification = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification(title, message, notification);
        tray.showAndWait();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void redirectStat(ActionEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("stat.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   @FXML
    private void DureeValidateDigital(KeyEvent event) {
        if(!dr.getText().matches("[0-9]+")){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Alert");
                    alert.setContentText("N'utilisez que des chiffres!");
                    alert.showAndWait();
                    
            dr.clear();
        }
        
    }
    
    @FXML
    private void PrixValidateDigital(KeyEvent event) {
        if(!pr.getText().matches("[0-9]+")){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Alert");
                    alert.setContentText("N'utilisez que des chiffres!");
                    alert.showAndWait();
                    
            pr.clear();
        }        
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
