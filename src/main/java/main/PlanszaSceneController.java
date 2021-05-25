package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.Random;

public class PlanszaSceneController {
    public Button bt00;
    public Button bt10;
    public Button bt20;
    public Button bt01;
    public Button bt11;
    public Button bt21;
    public Button bt02;
    public Button bt12;
    public Button bt22;
    public Label gracz;
    public Label ruch;

    public static int movment=0;
    public Label wynik;
    public CheckBox typPlayer;
    //1 is x
    //-1 is y
    int[] decision = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void whoWin(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        if(decision[0]+decision[1]+decision[2]==3 ||
                decision[3]+decision[4]+decision[5]==3 ||
                decision[6]+decision[7]+decision[8]==3 ||
                decision[0]+decision[3]+decision[6]==3 ||
                decision[1]+decision[4]+decision[7]==3 ||
                decision[2]+decision[5]+decision[8]==3 ||
                decision[6]+decision[4]+decision[2]==3 ||
                decision[0]+decision[4]+decision[8]==3
        ){
            wynik.setText("WYGRYWA O");
            alert.setContentText("Wygrywa O");
            alert.setHeaderText("Koniec Gry");
            alert.show();

        }else if(decision[0]+decision[1]+decision[2]==-3 ||
                decision[3]+decision[4]+decision[5]==-3 ||
                decision[6]+decision[7]+decision[8]==-3 ||
                decision[0]+decision[3]+decision[6]==-3 ||
                decision[1]+decision[4]+decision[7]==-3 ||
                decision[2]+decision[5]+decision[8]==-3 ||
                decision[6]+decision[4]+decision[2]==-3 ||
                decision[0]+decision[4]+decision[8]==-3 ){
            wynik.setText("WYGRYWA X");
            alert.setContentText("Wygrywa X");
            alert.setHeaderText("Koniec Gry");
            alert.show();

        }else {
            wynik.setText("REMIS");
            alert.setContentText("Remis");
        }
        if (decision[0]!=0
                && decision[1]!=0
                && decision[2]!=0
                && decision[3]!=0
                && decision[4]!=0
                && decision[5]!=0
                && decision[6]!=0
                && decision[7]!=0
                && decision[8]!=0){
            alert.setHeaderText("Koniec Gry");
            alert.show();
        }
    }

    //  f0 || f1 || f2
    //  = = + = = + = =
    //  f3 || f4 || f5
    //  = = + = = + = =
    //  f6 || f6 || f8

    public void randomMovment(int zakazana){
        Random random=new Random();
        if (decision[0]==0
                || decision[1]==0
                || decision[2]==0
                || decision[3]==0
                || decision[4]==0
                || decision[5]==0
                || decision[6]==0
                || decision[7]==0
                || decision[8]==0) {
            int r = random.nextInt(9);
            if (r != zakazana) {
                //POLE f0
                if (r == 0 && decision[0] == 0) {
                    decision[0] = -1;
                    bt00.setText("SI");
                    bt00.setDisable(true);
                }

                //POLE f1
                else if (r == 1 && decision[1] == 0) {
                    decision[1] = -1;
                    bt01.setText("SI");
                    bt01.setDisable(true);

                }

                //POLE f2
                else if (r == 2 && decision[1] == 0) {
                    decision[2] = -1;
                    bt02.setText("SI");
                    bt02.setDisable(true);

                }

                //Pole f3
                else if (r == 3 && decision[3] == 0) {
                    decision[3] = -1;
                    bt10.setText("SI");
                    bt10.setDisable(true);

                }

                //Pole f4
                else if (r == 4 && decision[4] == 0) {
                    decision[4] = -1;
                    bt11.setText("SI");
                    bt11.setDisable(true);

                }

                //Pole f5
                else if (r == 5 && decision[5] == 0) {
                    decision[5] = -1;
                    bt12.setText("SI");
                    bt12.setDisable(true);
                }
                //POLE f6
                else if (r == 6 && decision[6] == 0) {
                    decision[6] = -1;
                    bt20.setText("SI");
                    bt20.setDisable(true);
                }

                //Pole f7
                else if (r == 7 && decision[7] == 0) {
                    decision[7] = -1;
                    bt21.setText("SI");
                    bt21.setDisable(true);
                }
                //Pole f8
                else if (r == 8 && decision[8] == 0) {
                    decision[8] = -1;
                    bt22.setText("SI");
                    bt22.setDisable(true);
                }else {
                    randomMovment(r);
                }

                movment = 0;
                gracz.setText("X");
            } else {
                randomMovment(r);
            }
        }else {
            System.out.println("Brak wolnych pól");
        }
    }

    public void clikField0(ActionEvent actionEvent) {
        //gracz X
        if(movment %2==0){
            movment++;
            gracz.setText("O");
            ruch.setText(String.valueOf(movment));
            bt00.setText("X");
            decision[0]=1;
            bt00.setDisable(true);

            if(typPlayer.isSelected()){
                randomMovment(0);
            }
            whoWin();
        }
        //gracz 2

        else{
            if(!typPlayer.isSelected()) {
                movment++;
                gracz.setText("o");
                ruch.setText(String.valueOf(movment));
                gracz.setText("X");


                bt00.setText("0");
                decision[0] = -1;
                bt00.setDisable(true);
                whoWin();
            }
        }
    }

    public void clikField1(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt01.setText("X");
            decision[1]=1;
            bt01.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(1);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt01.setText("0");
            decision[1]=-1;
            bt01.setDisable(true);
            whoWin();
        }
    }

    public void clikField2(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt02.setText("X");
            decision[2]=1;
            bt02.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(2);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt02.setText("0");
            decision[2]=-1;
            bt02.setDisable(true);

        }
    }

    public void clikField3(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt10.setText("X");
            decision[3]=1;
            bt10.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(3);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt10.setText("0");
            decision[3]=-1;
            bt10.setDisable(true);
            whoWin();
        }

    }
    public void clikField4(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt11.setText("X");
            decision[4]=1;
            bt11.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(4);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));
            bt11.setText("0");
            decision[4]=-1;
            bt11.setDisable(true);

        }
    }
    public void clikField5(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt12.setText("X");
            decision[5]=1;
            bt12.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(5);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt12.setText("0");
            decision[5]=-1;
            bt12.setDisable(true);
            whoWin();
        }

    }

    public void clikField6(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt20.setText("X");
            decision[6]=1;
            bt20.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(6);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt20.setText("0");
            decision[6]=-1;
            bt20.setDisable(true);

        }
    }

    public void clikField7(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt21.setText("X");
            decision[7]=1;
            bt21.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(7);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt21.setText("0");
            decision[7]=-1;
            bt21.setDisable(true);
            whoWin();
        }
    }

    public void clikField8(ActionEvent actionEvent) {
        //gracz 0
        if(movment %2==0){
            movment++;
            gracz.setText("o");
            ruch.setText(String.valueOf(movment));

            bt22.setText("x");
            decision[8]=1;
            bt22.setDisable(true);
            if(typPlayer.isSelected()){
                randomMovment(8);
            }
            whoWin();
        }
        //gracz X
        else{
            movment++;
            gracz.setText("x");
            ruch.setText(String.valueOf(movment));

            bt22.setText("0");
            decision[8]=-1;
            bt22.setDisable(true);
            whoWin();
        }
    }

    public void newGame(ActionEvent actionEvent) {
        bt00.setText("");
        bt00.setDisable(false);
        bt10.setText("");
        bt10.setDisable(false);
        bt20.setText("");
        bt20.setDisable(false);
        bt01.setText("");
        bt01.setDisable(false);
        bt11.setText("");
        bt11.setDisable(false);
        bt21.setText("");
        bt21.setDisable(false);
        bt02.setText("");
        bt02.setDisable(false);
        bt12.setText("");
        bt12.setDisable(false);
        bt22.setText("");
        bt22.setDisable(false);
        movment=0;
        ruch.setText(String.valueOf(movment));
        gracz.setText("X");
        decision = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
