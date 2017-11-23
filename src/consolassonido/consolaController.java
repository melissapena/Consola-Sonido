/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolassonido;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 *
 * @author MELISSA
 */
public class consolaController implements Initializable {
    
   
    @FXML Pane pane;
    @FXML Slider sliderR;
    @FXML Slider sliderG;
    @FXML Slider sliderB;
    
     @FXML
    private Label label;
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
       System.out.println("ON/OFF");
       label.setText("SONIDO");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        //cambia el color de fondo del objeto Pane
        pane.setBackground(
                //la clase Background crea un fondo para agregar al Pane
                new Background(
                //la clase BackgroundFill permiete crear un relleno 
                        new BackgroundFill( 
                            Color.rgb(//Color RGB con los valores iniciales de los slider
                                (int)sliderR.getValue(),
                                (int)sliderG.getValue(),
                                (int)sliderB.getValue()
                            ), CornerRadii.EMPTY, Insets.EMPTY)));
        
        sliderR.valueProperty().addListener(new ChangeListener<Number>() {            
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {                    
                pane.setBackground(new Background(new BackgroundFill( 
                Color.rgb(
                    new_val.intValue(),
                    (int)sliderG.getValue(),
                    (int)sliderB.getValue()
                ), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        
        sliderG.valueProperty().addListener(new ChangeListener<Number>() {            
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {                    
                pane.setBackground(new Background(new BackgroundFill( 
                Color.rgb(                    
                    (int)sliderR.getValue(),
                    new_val.intValue(),
                    (int)sliderB.getValue()
                ), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        
        sliderB.valueProperty().addListener(new ChangeListener<Number>() {            
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {                    
                pane.setBackground(new Background(new BackgroundFill( 
                Color.rgb(                    
                    (int)sliderR.getValue(),
                    (int)sliderG.getValue(),
                    new_val.intValue()
                ), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });

    }    
    
}
