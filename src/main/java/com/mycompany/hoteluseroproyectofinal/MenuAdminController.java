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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author franc
 */
public class MenuAdminController implements Initializable
{

    @FXML
    private MenuItem adDatUser;

    @FXML
    private MenuItem adAddRoom;

    @FXML
    private MenuItem adAdduser;

    @FXML
    private MenuItem adAgenda;

    @FXML
    private MenuItem adCalculadora;

    @FXML
    private MenuItem adCalendario;

    @FXML
    private MenuItem adDatRoom;

    @FXML
    private MenuItem adDeleteRoom;

    @FXML
    private MenuItem adDeleteUser;

    @FXML
    private MenuItem adListRoomFree;

    @FXML
    private MenuItem adListRoomOcupa;

    @FXML
    private MenuItem adListUser;

    @FXML
    private MenuItem adModUser;

    @FXML
    private TextField adUserActivo;
    
    @FXML
    private Button exitA;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    } 
    
//    //salir
    @FXML
    private void actionSalir(ActionEvent event) throws IOException 
    {
        App.cargarVentana("confirmarSalir");
    }
    
//    @FXML   //Indica el nombre del usuario activo
//    public void establecerNombreAdmin(String nombreUsuario) 
//    {
//    adUserActivo.setText(nombreUsuario);
//    }
    
}
