package GameZone;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameZoneMainController  {

    @FXML
    private Button buttonHangman;

    @FXML
    private Button buttonTicTacToe;

    @FXML
    private Button cricket;

    @FXML
    void onHangman(ActionEvent event) throws IOException {
        Parent goToHangman = FXMLLoader.load(getClass().getResource("/Hangman/Hangman.fxml"));
        Scene scene = new Scene(goToHangman);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onTicTacToe(ActionEvent event) throws IOException {
        Parent goToHangman = FXMLLoader.load(getClass().getResource("/TicTacToe/TicTacToe.fxml"));
        Scene scene = new Scene(goToHangman);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onCricket(ActionEvent event) throws IOException {
        Parent goToHangman = FXMLLoader.load(getClass().getResource("/Cricket/Cricket.fxml"));
        Scene scene = new Scene(goToHangman);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}