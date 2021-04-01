/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportify;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Kais
 */
public class AbonnementlistController implements Initializable {
    
    @FXML
    public TableView<Abonnement> table;
    @FXML
    private TableColumn<Abonnement, Integer> id;
    
    @FXML
    private TableColumn<Abonnement, Date> dd;
    
    @FXML
    private TableColumn<Abonnement,Date> dr;
    
    @FXML
    private TableColumn<Abonnement,Date> pr;
    
    @FXML
    private TableColumn<Abonnement, String> type;
    
    @FXML
    ObservableList<Abonnement> events;
    
    private TableColumn<Abonnement, String> actionCol = new TableColumn("Action");
//    private TableColumn<Abonnement, String> modifCol = new TableColumn("Modifier");
    
    AbonnementDAO dao = new AbonnementDAO();
    @FXML
    private Button ajouter;
    @FXML
    private TextField searchInput;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.getColumns().add(actionCol);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        dd.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dr.setCellValueFactory(new PropertyValueFactory<>("duree"));
        pr.setCellValueFactory(new PropertyValueFactory<>("prix"));
        actionCol.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("action"));
        ArrayList<Abonnement> events = dao.findAll();
        
       
     
        for(Abonnement ev: events){
            ev.getAction().setOnAction(e -> {
                
                Stage stage = new Stage();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("abonnement.fxml"));
               Parent parent;
                    try {
                        parent = (Parent) loader.load();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.show();
                        AbonnementController controller = loader.getController();
                        controller.initData(ev);
                        Stage parentStage = (Stage) ev.getAction().getScene().getWindow();
                        parentStage.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            });
        
        }
        
        
        
        ObservableList<Abonnement> listevent = FXCollections.observableArrayList(events);
        table.setItems(listevent);
        
        
        // TODO
    }  
    
    
    @FXML
    private void ajouterRedirect(ActionEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("abonnementinput.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AbonnementlistController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void searchAction(KeyEvent event) {
        
        ArrayList<Abonnement> events = dao.findByType(Integer.parseInt(searchInput.getText().trim().equals("") ? "-1" : searchInput.getText().trim()));
       
     
        for(Abonnement ev: events){
            ev.getAction().setOnAction(e -> {
                
                Stage stage = new Stage();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("abonnement.fxml"));
               Parent parent;
                    try {
                        parent = (Parent) loader.load();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.show();
                        AbonnementController controller = loader.getController();
                        controller.initData(ev);
                        Stage parentStage = (Stage) ev.getAction().getScene().getWindow();
                        parentStage.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            });
        
        }
        
        
        
        ObservableList<Abonnement> listevent = FXCollections.observableArrayList(events);
        table.setItems(listevent);
    }

    @FXML
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
            Logger.getLogger(AbonnementlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void tableToPdf(ActionEvent event) {
        try{
            WorkbookController to_pdf = new WorkbookController(this.table);
            to_pdf.load(event);
        }catch(Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
        
    }

   


   @FXML
    private void redirectevent(MouseEvent event) {
    }
    
    @FXML
    private void abonnementRedirect(MouseEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("abonnementlist.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AbonnementlistController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AbonnementlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(AbonnementlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void coursRedirect(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("tableView.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

