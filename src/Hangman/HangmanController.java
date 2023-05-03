package Hangman;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HangmanController {


    @FXML
    private Rectangle rope;

    @FXML
    private ImageView manHead2;

//    @FXML
//    private Circle manHead;

    @FXML
    private Rectangle manBody;

    @FXML
    private Rectangle rightHand;

    @FXML
    private Rectangle leftHand;

    @FXML
    private Rectangle leftLeg;

    @FXML
    private Rectangle rightLeg;

    @FXML
    private Text targetWordField;

    @FXML
    private Pane buttonContainer;

    @FXML
    private Text gameStatus;

    @FXML
    private Text hintBar;

    private Word word = new Word();



    private int correctGuess;
    private int wrongGuess;
    String targetWord ="";

    private List<String> targetLetter;
    private List<String> answer;

    private char[] result;
    private char[] targetWordArray;


    public void initialize(){
        rope.setVisible(false);
//        manHead.setVisible(false);
        manHead2.setVisible(false);
        manBody.setVisible(false);
        leftHand.setVisible(false);
        rightHand.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);


        targetWord = word.getRandomWord();
        targetWordArray = new char[targetWord.length()];
        targetWordArray = targetWord.toCharArray();

        result = new char[targetWord.length()];

        for(int k = 0;k<targetWord.length();k++){
            result[k] = '_';
        }


        StringBuffer res = new StringBuffer();
        for (char e:result) {
            res.append(e+" ");
        }

        targetWordField.setText(res+"");


    }




    @FXML
    public void onClick(ActionEvent event){
        String letter = ((Button)event.getSource()).getText().toLowerCase();

        ((Button) event.getSource()).setDisable(true);



        if(targetWord.contains(letter)){


            for(int i=0; i<targetWord.length();i++){
                if(targetWordArray[i]== letter.charAt(0)){
                    correctGuess++;
                    result[i] = letter.charAt(0);
                }
            }

            StringBuffer res = new StringBuffer();
            for (char e:result) {
                res.append(e+" ");
            }

            targetWordField.setText(res+"");

            System.out.println(correctGuess);
            if(correctGuess == targetWord.length()){
                gameStatus.setText("YOU WIN");
            }



        }else{
            System.out.println(targetWord);

            wrongGuess++;
            if(wrongGuess ==1) rope.setVisible(true);
            else if (wrongGuess ==2) manHead2.setVisible(true);
            else if (wrongGuess ==3) manBody.setVisible(true);
            else if (wrongGuess ==4) leftHand.setVisible(true);
            else if (wrongGuess ==5) rightHand.setVisible(true);
            else if (wrongGuess ==6) leftLeg.setVisible(true);
            else if (wrongGuess==7){
                rightLeg.setVisible(true);
                gameStatus.setText("GAME OVER");

            };
        }

    }

    @FXML
    void changeScreen(ActionEvent event) throws IOException {
        Parent goToHome = FXMLLoader.load(getClass().getResource("/GameZone/GameZoneMain.fxml"));
        Scene scene = new Scene(goToHome);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
