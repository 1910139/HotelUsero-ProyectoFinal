package com.mycompany.hoteluseroproyectofinal;

import Clases.Cliente;
import Clases.Empleado;
import Clases.Persona;
//import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application 
{

       private static Scene scene;
       
       //Llamamos a las ArrayList
                     //nombre clase //Objeto
    private static ArrayList<Persona> persona = new ArrayList<>();
    private static ArrayList<Cliente> cliente = new ArrayList<>();
    private static ArrayList<Empleado> empleado = new ArrayList<>();
    //Hotel, habitacion, ciudad, localidad, Administrador, Servicios, factura
    
    //Usamos gestion de ficheros de milibreria2023
//    private static File personas = new File("personas.dat");
    
    //Lanzador
/*******************************************************************************/
    public static void main(String[] args)
    {
        launch();
    }
/*******************************************************************************/
    
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicioSesion.fxml"));
        try 
        {
          scene = new Scene(fxmlLoader.load());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        
        stage.setTitle("Mi aplicación JavaFX");
        stage.setOnCloseRequest(new EventHandler<WindowEvent>()
              {
               @Override public void handle(WindowEvent event) 
                {
                 event.consume();           //Consumar el evento
                }      
              } );
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
   
    public static void cargarVentana(String vista) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(vista + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());  
     
        Stage stage = new Stage();  
        stage.setScene(scene);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>()
              {
               @Override public void handle(WindowEvent event) 
               {
                event.consume();           //Consumar el evento
               }      
              } );
    
        // Inhabilitar la ventana actual
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();        
    }
   
    
//ArrayList Persona   
/*******************************************************************************/
    public static ArrayList<Persona> getPersona()
    {
        return persona;
    }
    
    public void setPersona(ArrayList<Persona> personas)
    {
        this.persona = personas;
    }
    
//    //Obtenemos el valor de la ArrayList Personas guardado en el fichero 
//    public static File getPersonas()
//    {
//        return personas;
//    }
//    
//    //Editamos el fichero con los nuevos datos
//    public void setPersona (File personas)
//    {
//        this.personas = personas;
//    }

}

//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }