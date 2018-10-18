package ung.ungnewsletter.enewsletter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ung.ungnewsletter.enewsletter.model.Newsletter;

public class Controller {
    @FXML
    TextField FirstnameTXT, LastnameTXT, EmailTXT, PasswordTXT;

    public void subscribe(ActionEvent actionEvent) throws Exception{

        Newsletter model = new Newsletter();

        model.setFirstname(FirstnameTXT.getText());
        model.setLastname(LastnameTXT.getText());
        model.setEmail(EmailTXT.getText());
        model.setPassword(PasswordTXT.getText());
        model.addUsertoDatabase();
    }


}
