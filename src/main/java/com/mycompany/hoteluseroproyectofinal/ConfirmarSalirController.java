/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.hoteluseroproyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author franc
 */
public class ConfirmarSalirController implements Initializable 
{

    @FXML
    private Button btnSi;
    @FXML
    private Button btnNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    

    @FXML
    private void accionSi(ActionEvent event) throws IOException 
    {
     System.exit(0); 
    }

    @FXML
    private void accionNo(ActionEvent event) 
    {
     Stage window = (Stage) this.btnNo.getScene().getWindow();
     window.close();
    }
    
}

