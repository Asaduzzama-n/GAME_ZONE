package TicTacToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToeController {

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Text whosTurn;

    @FXML
    private Text tf;

    String turn = "X";
    static String player = "Player 1";
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, val = 0, count = 0, val2 = 10;

//    Image imageX = new Image("assets/undraw_Gaming_re_cma2.png");
//    BackgroundImage backgroundImageX = new BackgroundImage(imageX, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//    Background backgroundX = new Background(backgroundImageX);

    public void resetGame() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        c1 = 0;
        c2 = 0;
        c3 = 0;
        c4 = 0;
        c5 = 0;
        c6 = 0;
        c7 = 0;
        c8 = 0;
        c9 = 0;
        val = 0;
        val2 = 10;
        count = 0;
        tf.setText("The Winner Is: ");
        whosTurn.setText("Player 1 turn");
        turn = "X";

    }

    public void stopGame() {
        c1 = 5;
        c2 = 5;
        c3 = 5;
        c4 = 5;
        c5 = 5;
        c6 = 5;
        c7 = 5;
        c8 = 5;
        c9 = 5;
        count = 1;
    }

    public void determineTurn() {
        val2++;

        if (val2 % 2 != 0) {
            turn = "X";
            player = "Player 1";

            whosTurn.setText("Player 2 turn");

        } else {
            turn = "O";
            player = "Player 2";

            whosTurn.setText("Player 1 turn");

        }
    }

    public void check() throws Exception {
        val++;


        if (b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText()) && !"".equals(b1.getText()) && !"".equals(b5.getText()) && !"".equals(b9.getText())) {
            tf.setText(player + " won ");
            stopGame();

        }
        if (b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText()) && !"".equals(b3.getText()) && !"".equals(b5.getText()) && b7.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b1.getText() == b2.getText() && b1.getText() == b3.getText() && b1.getText() != "" && b2.getText() != "" && b3.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b4.getText() == b5.getText() && b4.getText() == b6.getText() && b4.getText() != "" && b5.getText() != "" && b6.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b7.getText() == b8.getText() && b7.getText() == b9.getText() && b7.getText() != "" && b8.getText() != "" && b9.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b1.getText() == b4.getText() && b1.getText() == b7.getText() && b1.getText() != "" && b4.getText() != "" && b7.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b2.getText() == b5.getText() && b2.getText() == b8.getText() && b2.getText() != "" && b5.getText() != "" && b8.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
        if (b3.getText() == b6.getText() && b3.getText() == b9.getText() && b3.getText() != "" && b6.getText() != "" && b9.getText() != "") {
            tf.setText(player + " won ");
            stopGame();
        }
    }

    public void cit() {
        if (count == 0) {
            tf.setText("Tie!!!");
            stopGame();
        }
    }

    public void button1() {
        if (c1 < 1) {
            determineTurn();
            b1.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b1.setTextFill(Color.valueOf("#32CCCD"));
//                b1.setBackground(backgroundX);
            } else {
                b1.setTextFill(Color.valueOf("#FFFFFF"));

            }

            c1++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button2() {
        if (c2 < 1) {
            determineTurn();
            b2.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b2.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b2.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c2++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button3() {
        if (c3 < 1) {
            determineTurn();
            b3.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b3.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b3.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c3++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button4() {
        if (c4 < 1) {
            determineTurn();
            b4.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b4.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b4.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c4++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button5() {
        if (c5 < 1) {
            determineTurn();
            b5.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b5.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b5.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c5++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button6() {
        if (c6 < 1) {
            determineTurn();
            b6.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b6.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b6.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c6++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button7() {
        if (c7 < 1) {
            determineTurn();
            b7.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b7.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b7.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c7++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button8() {
        if (c8 < 1) {
            determineTurn();
            b8.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b8.setTextFill(Color.valueOf("#32CCCD"));
            } else {
                b8.setTextFill(Color.valueOf("#FFFFFF"));
            }
            c8++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void button9() {
        if (c9 < 1) {
            determineTurn();
            b9.setText(turn);
            if (turn.equalsIgnoreCase("X")) {
                b9.setTextFill(Color.valueOf("#32CCCD"));

            } else {
                b9.setTextFill(Color.valueOf("#FFFFFF"));
            }

            c9++;
            try {
                check();
                if (val == 9) {
                    cit();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicTacToeController.class
                        .getName()).log(Level.SEVERE, null, ex);
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