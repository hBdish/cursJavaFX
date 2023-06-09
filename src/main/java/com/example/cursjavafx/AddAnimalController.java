package com.example.cursjavafx;

import com.example.cursjavafx.database.PostgreDB;
import com.example.cursjavafx.utils.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAnimalController implements Initializable {
    @FXML
    public ChoiceBox<String> choiceKindList;
    @FXML
    public TextField name;
    @FXML
    public DatePicker date;
    public CheckBox idReglament;
    PostgreDB db = PostgreDB.singleBD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceKindList.setItems(db.getKinds());
        choiceKindList.setValue(db.getKinds().get(0));
    }

    public void addAnimal(ActionEvent event) {
        db.createAnimal(name.getText(), choiceKindList.getValue(), date.getValue(), event, idReglament.isSelected());
    }

    public void backOnMain(ActionEvent event) {
        Scenes.MAIN.switchScene(event);
    }
}
