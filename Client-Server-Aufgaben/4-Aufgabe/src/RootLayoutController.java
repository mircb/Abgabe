
import java.io.*;
import java.net.Socket;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class RootLayoutController {                         //Controller für GUI
    @FXML
    private TextField tf_ip;
    Socket CSocket;
    Thread server;

    @FXML
    private javafx.scene.control.Button b11;
    @FXML
    private javafx.scene.control.Button b12;
    @FXML
    private javafx.scene.control.Button b13;
    @FXML
    private javafx.scene.control.Button b14;
    @FXML
    private javafx.scene.control.Button b15;
    @FXML
    private javafx.scene.control.Button b16;
    @FXML
    private javafx.scene.control.Button b17;
    @FXML
    private javafx.scene.control.Button b21;
    @FXML
    private javafx.scene.control.Button b22;
    @FXML
    private javafx.scene.control.Button b23;
    @FXML
    private javafx.scene.control.Button b24;
    @FXML
    private javafx.scene.control.Button b25;
    @FXML
    private javafx.scene.control.Button b26;
    @FXML
    private javafx.scene.control.Button b27;
    @FXML
    private javafx.scene.control.Button b31;
    @FXML
    private javafx.scene.control.Button b32;
    @FXML
    private javafx.scene.control.Button b33;
    @FXML
    private javafx.scene.control.Button b34;
    @FXML
    private javafx.scene.control.Button b35;
    @FXML
    private javafx.scene.control.Button b36;
    @FXML
    private javafx.scene.control.Button b37;
    @FXML
    private javafx.scene.control.Button b41;
    @FXML
    private javafx.scene.control.Button b42;
    @FXML
    private javafx.scene.control.Button b43;
    @FXML
    private javafx.scene.control.Button b44;
    @FXML
    private javafx.scene.control.Button b45;
    @FXML
    private javafx.scene.control.Button b46;
    @FXML
    private javafx.scene.control.Button b47;
    @FXML
    private javafx.scene.control.Button b51;
    @FXML
    private javafx.scene.control.Button b52;
    @FXML
    private javafx.scene.control.Button b53;
    @FXML
    private javafx.scene.control.Button b54;
    @FXML
    private javafx.scene.control.Button b55;
    @FXML
    private javafx.scene.control.Button b56;
    @FXML
    private javafx.scene.control.Button b57;
    @FXML
    private javafx.scene.control.Button b61;
    @FXML
    private javafx.scene.control.Button b62;
    @FXML
    private javafx.scene.control.Button b63;
    @FXML
    private javafx.scene.control.Button b64;
    @FXML
    private javafx.scene.control.Button b65;
    @FXML
    private javafx.scene.control.Button b66;
    @FXML
    private javafx.scene.control.Button b67;


    @FXML
    private javafx.scene.control.Button s;
    @FXML
    private javafx.scene.control.Button serverbt;
    @FXML
    private javafx.scene.control.Button resetbt;
    @FXML
    private Pane pane;
    @FXML
    private Label label;
    @FXML
    private Label lb_weristdran;
    @FXML
    private Circle cl_weristdrantrue;
    @FXML
    private Circle cl_weristdranfalse;
    Nachricht send = new Nachricht();

    public void setpane(boolean f) {            //Das  Fenster disable ansteuern
        setWeristdran(f);
        pane.setDisable(f);
    }

    public void setWeristdran(boolean f) {                  //Wer ist dran wird ausgetauscht
        if (f) {
            lb_weristdran.setText("Der andere Spieler ist dran ");
            cl_weristdranfalse.setVisible(true);
            cl_weristdrantrue.setVisible(false);
        } else {
            lb_weristdran.setText("Du bist dran");
            cl_weristdranfalse.setVisible(false);
            cl_weristdrantrue.setVisible(true);
        }
    }

    public void setlabel(String f) {                    //Text für Label setzten

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                label.setText(f);

            }
        });
    }

    public Label getlabel() {               //getter für label

        return label;
    }

    public void setreset(boolean f) {               //Resetbutton ändern
        resetbt.setDisable(f);
    }

    ObjectOutputStream out;

    public void Buttonclk() {                   //mit server verbindung aufnehmen

        try {
            CSocket = new Socket(tf_ip.getText(), 4343);
            serverbt.setText("Verbunden mit: " + CSocket.getInetAddress().toString());
            serverbt.setDisable(true);

            //ObjectInputStream in = new ObjectInputStream(CSocket.getInputStream());

            // in.readObject();

            s.setText("Verbunden");
            s.setDisable(true);
            resetbt.setDisable(true);
            tf_ip.setDisable(true);

            javafx.scene.control.Button[] b = new javafx.scene.control.Button[42];
            b[0] = b11;
            b[1] = b12;
            b[2] = b13;
            b[3] = b14;
            b[4] = b15;
            b[5] = b16;
            b[6] = b17;
            b[7] = b21;
            b[8] = b22;
            b[9] = b23;
            b[10] = b24;
            b[11] = b25;
            b[12] = b26;
            b[13] = b27;

            b[14] = b31;
            b[15] = b32;
            b[16] = b33;
            b[17] = b34;
            b[18] = b35;
            b[19] = b36;
            b[20] = b37;
            b[21] = b41;
            b[22] = b42;
            b[23] = b43;
            b[24] = b44;
            b[25] = b45;
            b[26] = b46;
            b[27] = b47;

            b[28] = b51;
            b[29] = b52;
            b[30] = b53;
            b[31] = b54;
            b[32] = b55;
            b[33] = b56;
            b[34] = b57;
            b[35] = b51;
            b[36] = b52;
            b[37] = b53;
            b[38] = b54;
            b[39] = b55;
            b[40] = b56;
            b[41] = b57;


            listerner n = new listerner(b, CSocket, this);

        } catch (Exception e) {

            System.out.println("Fehler aufgetreten!!!");
            e.printStackTrace();

        }

    }

    public void Buttonclk2(ActionEvent actionEvent) {           //Server wird gestartet und mit diesen verbunden

        server = new Thread() {
            @Override
            public void run() {
                Server s = new Server();
            }
        };
        server.start();
        serverbt.setDisable(true);
        tf_ip.setText("127.0.0.1");
        this.Buttonclk();


    }


    public void Bt(ActionEvent actionEvent) {          // wenn ein Button des Spielfeldes geklickt wird, wird dieser an den Serverthread gesendet
        try {
            out = new ObjectOutputStream(CSocket.getOutputStream());

            if (actionEvent.getSource().equals(b11)) {
                this.setButton(b11);
            }
            if (actionEvent.getSource().equals(b12)) {
                this.setButton(b12);
            }
            if (actionEvent.getSource().equals(b13)) {
                this.setButton(b13);
            }
            if (actionEvent.getSource().equals(b14)) {
                this.setButton(b14);
            }
            if (actionEvent.getSource().equals(b15)) {
                this.setButton(b15);
            }
            if (actionEvent.getSource().equals(b16)) {
                this.setButton(b16);
            }
            if (actionEvent.getSource().equals(b17)) {
                this.setButton(b17);
            }

            if (actionEvent.getSource().equals(b21)) {
                this.setButton(b21);
            }
            if (actionEvent.getSource().equals(b22)) {
                this.setButton(b22);
            }
            if (actionEvent.getSource().equals(b23)) {
                this.setButton(b23);
            }
            if (actionEvent.getSource().equals(b24)) {
                this.setButton(b24);
            }
            if (actionEvent.getSource().equals(b25)) {
                this.setButton(b25);
            }
            if (actionEvent.getSource().equals(b26)) {
                this.setButton(b26);
            }
            if (actionEvent.getSource().equals(b27)) {
                this.setButton(b27);
            }

            if (actionEvent.getSource().equals(b31)) {
                this.setButton(b31);
            }
            if (actionEvent.getSource().equals(b32)) {
                this.setButton(b32);
            }
            if (actionEvent.getSource().equals(b33)) {
                this.setButton(b33);
            }
            if (actionEvent.getSource().equals(b34)) {
                this.setButton(b34);
            }
            if (actionEvent.getSource().equals(b35)) {
                this.setButton(b35);
            }
            if (actionEvent.getSource().equals(b36)) {
                this.setButton(b36);
            }
            if (actionEvent.getSource().equals(b37)) {
                this.setButton(b37);
            }

            if (actionEvent.getSource().equals(b41)) {
                this.setButton(b41);
            }
            if (actionEvent.getSource().equals(b42)) {
                this.setButton(b42);
            }
            if (actionEvent.getSource().equals(b43)) {
                this.setButton(b43);
            }
            if (actionEvent.getSource().equals(b44)) {
                this.setButton(b44);
            }
            if (actionEvent.getSource().equals(b45)) {
                this.setButton(b45);
            }
            if (actionEvent.getSource().equals(b46)) {
                this.setButton(b46);
            }
            if (actionEvent.getSource().equals(b47)) {
                this.setButton(b47);
            }

            if (actionEvent.getSource().equals(b51)) {
                this.setButton(b51);
            }
            if (actionEvent.getSource().equals(b52)) {
                this.setButton(b52);
            }
            if (actionEvent.getSource().equals(b53)) {
                this.setButton(b53);
            }
            if (actionEvent.getSource().equals(b54)) {
                this.setButton(b54);
            }
            if (actionEvent.getSource().equals(b55)) {
                this.setButton(b55);
            }
            if (actionEvent.getSource().equals(b56)) {
                this.setButton(b56);
            }
            if (actionEvent.getSource().equals(b57)) {
                this.setButton(b57);
            }

            if (actionEvent.getSource().equals(b61)) {
                this.setButton(b61);
            }
            if (actionEvent.getSource().equals(b62)) {
                this.setButton(b62);
            }
            if (actionEvent.getSource().equals(b63)) {
                this.setButton(b63);
            }
            if (actionEvent.getSource().equals(b64)) {
                this.setButton(b64);
            }
            if (actionEvent.getSource().equals(b65)) {
                this.setButton(b65);
            }
            if (actionEvent.getSource().equals(b66)) {
                this.setButton(b66);
            }
            if (actionEvent.getSource().equals(b67)) {
                this.setButton(b67);
            }

        } catch (IOException e) {

            System.out.println("Fehler aufgetreten!!!");
            e.printStackTrace();

        }


    }

    private void setButton(javafx.scene.control.Button bt) {                //einnen Button ändern

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                send.setMessage(bt.toString());

                try {
                    out.writeObject(send);
                } catch (IOException e) {

                    System.out.println("Fehler aufgetreten!!!");
                    e.printStackTrace();

                }


                bt.setDisable(true);
                bt.setText("X");
                setpane(true);
            }
        });
    }

    public void reset() {                       //Spielfeld zurücksetzten

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setallBTdis();
                setallBTdis();
                send.setMessage("reset");
                try {
                    out.writeObject(send);
                } catch (IOException e) {

                    System.out.println("Fehler aufgetreten!!!");
                    e.printStackTrace();

                }
                pane.setDisable(false);
                setWeristdran(false);
                setlabel("Du bist X, der Gegner ist 0 ");
                setreset(true);
            }

        });
    }

    private void setallBTdis() {                    //Alle Buttons Zurücksetzten
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                b11.setDisable(false);
                b12.setText("");
                b13.setDisable(false);
                b14.setText("");
                b15.setDisable(false);
                b16.setText("");
                b17.setDisable(false);
                b21.setText("");
                b22.setDisable(false);
                b23.setText("");
                b24.setDisable(false);
                b25.setText("");
                b26.setDisable(false);
                b27.setText("");
                b31.setText("");
                b32.setDisable(false);
                b33.setText("");
                b34.setDisable(false);
                b35.setText("");
                b36.setDisable(false);
                b37.setText("");
                b41.setText("");
                b42.setDisable(false);
                b43.setText("");
                b44.setDisable(false);
                b45.setText("");
                b46.setDisable(false);
                b47.setText("");
                b51.setText("");
                b52.setDisable(false);
                b53.setText("");
                b54.setDisable(false);
                b55.setText("");
                b56.setDisable(false);
                b57.setText("");
                b61.setText("");
                b62.setDisable(false);
                b63.setText("");
                b64.setDisable(false);
                b65.setText("");
                b66.setDisable(false);
                b67.setText("");

            }
        });
    }
}