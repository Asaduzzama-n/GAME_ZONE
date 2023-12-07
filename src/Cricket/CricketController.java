package Cricket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Random;

public class CricketController {

    @FXML
    private TextField player_1;

    @FXML
    private TextField player_2;

    @FXML
    private TextField player_3;

    @FXML
    private Pane pane_1;

    @FXML
    private Pane pane_2;

    @FXML
    private Label scoreLabel;
    @FXML
    private Label wktLabel;
    @FXML
    private Label overLabel;
    @FXML
    private Label targetLabel;
    @FXML
    private ImageView score_show;
    @FXML
    private Label playerLabel;

    public int target;
    public int max_wkt = 2;
    public int curr_wkt = 0;
    public int totalScore = 0;
    public int ball = 0;
    public int over;
    public int curr_over = 0;

    public int player_total = 0;
    public int pc_total = 0;
    public String curr_player = "player";


    public String player1;
    public String player2;
    public String player3;

    public String winner;

    Image fourImg = new Image(getClass().getResource("/assets/four.gif").toExternalForm());
    Image sixImg = new Image(getClass().getResource("/assets/six.gif").toExternalForm());
    Image wicketImg = new Image(getClass().getResource("/assets/score/wicket.png").toExternalForm());
    Image winImg = new Image(getClass().getResource("/assets/score/trophy.gif").toExternalForm());
    Image loseImg = new Image(getClass().getResource("/assets/score/game-over.gif").toExternalForm());
    Image oneImg = new Image(getClass().getResource("/assets/score/oneS.gif").toExternalForm());
    Image twoImg = new Image(getClass().getResource("/assets/score/twoS.gif").toExternalForm());
    Image threeImg = new Image(getClass().getResource("/assets/score/threeS.gif").toExternalForm());
    Image fiveImg = new Image(getClass().getResource("/assets/score/fiveS.gif").toExternalForm());


//    Image fourImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\four.gif");
//    Image sixImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\six.gif");
//    Image wicketImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\wicket.png");
//    Image winImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\trophy.gif");
//    Image loseImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\game-over.gif");
//    Image oneImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\oneS.gif");
//    Image twoImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\twoS.gif");
//    Image threeImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\threeS.gif");
//    Image fiveImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\fiveS.gif");
//    Image wicketImg = new Image("E:\\AOOP_PROJECT\\GAME_ZONE\\src\\assets\\score\\wicket.png");


    @FXML
    void onOverClick(ActionEvent event) throws IOException {
            over = Integer.parseInt(((Button)event.getSource()).getText());
            System.out.println(over);
            ((Button) event.getSource()).setDisable(true);
    }







    @FXML
    void onStartPlay(ActionEvent event) throws IOException {
            player1 = player_1.getText();
            player2 = player_2.getText();
            player3 = player_3.getText();

            pane_1.setVisible(false);
            pane_2.setVisible(true);

            overLabel.setText("Over: "+ over);
            scoreLabel.setText("Score: "+ totalScore);
            wktLabel.setText("Wicket: "+ curr_wkt);

    }




    @FXML
    void onScoreClick(ActionEvent event) throws IOException {
        int user_score = Integer.parseInt(((Button)event.getSource()).getText());
        System.out.println("player score"+ user_score);


        int pc_score = new Random().nextInt(6);
        pc_score = pc_score ==0? pc_score+1:pc_score;
        System.out.println("pc score: "+ pc_score);
        ball++;


        if(curr_wkt == max_wkt || curr_over == over || pc_total > target ){
            if(curr_player == "player"){
                player_total = totalScore;
                target = totalScore;
                curr_over = 0;
                curr_wkt = 0;
                ball = 0;
                totalScore = 0;
                curr_player = "pc";
                targetLabel.setText("Target: "+target+"");
                overLabel.setText("Over: "+curr_over+""+"-"+ball);
                scoreLabel.setText("Score: "+totalScore);
                wktLabel.setText("Wicket: "+curr_wkt);



            }else{
                if(player_total > pc_total){
                    score_show.setImage(winImg);
                    System.out.println("Winner is player");
                }else if(player_total < pc_total){
                    score_show.setImage(loseImg);
                    System.out.println("Winner is pc");
                }else{
                    System.out.println("Draw");
                }
            }



        }else{
            if(ball >=6){
                curr_over += 1;
                ball = 0;
                overLabel.setText("Over: "+curr_over+""+"-"+ball);

            }
            overLabel.setText("Over: "+curr_over+"-"+ball);

                if(curr_wkt == 0){
                    playerLabel.setText(player1);
                } else if (curr_wkt ==1) {
                    playerLabel.setText(player1);
                }else {
                    playerLabel.setText(player1);
                }

            if(user_score == pc_score){
                curr_wkt ++;
                wktLabel.setText("Wicket: "+curr_wkt);
                score_show.setImage(wicketImg);
            }else{
                wktLabel.setText("Wicket: "+curr_wkt);
                if(curr_player == "player"){
                    totalScore += user_score;
                }else{
                    totalScore += pc_score;
                }

                if(curr_player == "player"){
                    player_total = totalScore;
                }else{
                    pc_total = totalScore;
                }

               if(curr_player == "player"){
                   if(user_score == 1){
                       score_show.setImage(oneImg);
                   }else if(user_score == 2){
                       score_show.setImage(twoImg);
                   }else if(user_score == 3){
                       score_show.setImage(threeImg);
                   }else if(user_score == 4){
                       score_show.setImage(fourImg);
                   }else if(user_score == 5){
                       score_show.setImage(fiveImg);
                   }else {
                       score_show.setImage(sixImg);
                   }
               }else{
                   if(pc_score == 1){
                       score_show.setImage(oneImg);
                   }else if(pc_score == 2){
                       score_show.setImage(twoImg);
                   }else if(pc_score == 3){
                       score_show.setImage(threeImg);
                   }else if(pc_score == 4){
                       score_show.setImage(fourImg);
                   }else if(pc_score == 5){
                       score_show.setImage(fiveImg);
                   }else {
                       score_show.setImage(sixImg);
                   }
               }

                scoreLabel.setText("Score: "+totalScore);
            }


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
