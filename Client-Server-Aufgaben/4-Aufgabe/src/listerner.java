
import javafx.application.Platform;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Borri Mirco on 03.03.2017.
 */
public class listerner extends Thread {

    javafx.scene.control.Button[] btarray;
    Socket socket;
    RootLayoutController controller;

    public listerner(javafx.scene.control.Button[] b, Socket c, RootLayoutController r) {       //Thread zum abhören ob der Serverthread eine Nachricht sendet
        this.btarray = b;
        this.socket = c;
        this.start();
        this.controller = r;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Nachricht msg = new Nachricht();

            while (true) {
                controll();
                msg = (Nachricht) in.readObject();

                //Wenn nachricht erhalten werden die Buttons geändert

                String bName = msg.getMessage();

                this.setButton(btarray[1]);


                controll();

            }

        } catch (Exception e) {

            System.out.println("Fehler aufgetreten!!!");
            e.printStackTrace();

        }

    }

    private void setButton(javafx.scene.control.Button bt) {        //Button ändern

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (bt.getText().equals("")) {
                    bt.setDisable(true);
                    bt.setText("0");
                    controller.setpane(false);
                    controll();
                }
            }
        });

    }

    private void controll() {           //Überprüfung ob jemand gewonnen, verloren oder Unentschieden

        if (btarray[0].getText().equals("0") && btarray[3].getText().equals("0") && btarray[6].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[1].getText().equals("0") && btarray[4].getText().equals("0") && btarray[7].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[2].getText().equals("0") && btarray[5].getText().equals("0") && btarray[8].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[0].getText().equals("0") && btarray[1].getText().equals("0") && btarray[2].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[3].getText().equals("0") && btarray[4].getText().equals("0") && btarray[5].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[6].getText().equals("0") && btarray[7].getText().equals("0") && btarray[8].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[0].getText().equals("0") && btarray[4].getText().equals("0") && btarray[8].getText().equals("0")) {
            ergebnis(false);
        }
        if (btarray[2].getText().equals("0") && btarray[4].getText().equals("0") && btarray[6].getText().equals("0")) {
            ergebnis(false);
        }

        if (btarray[0].getText().equals("X") && btarray[3].getText().equals("X") && btarray[6].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[1].getText().equals("X") && btarray[4].getText().equals("X") && btarray[7].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[2].getText().equals("X") && btarray[5].getText().equals("X") && btarray[8].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[0].getText().equals("X") && btarray[1].getText().equals("X") && btarray[2].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[3].getText().equals("X") && btarray[4].getText().equals("X") && btarray[5].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[6].getText().equals("X") && btarray[7].getText().equals("X") && btarray[8].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[0].getText().equals("X") && btarray[4].getText().equals("X") && btarray[8].getText().equals("X")) {
            ergebnis(true);
        }
        if (btarray[2].getText().equals("X") && btarray[4].getText().equals("X") && btarray[6].getText().equals("X")) {
            ergebnis(true);
        }

        if (!btarray[0].getText().equals("") && !btarray[1].getText().equals("") && !btarray[2].getText().equals("") && !btarray[3].getText().equals("") && !btarray[4].getText().equals("") &&
                !btarray[5].getText().equals("") && !btarray[6].getText().equals("") && !btarray[7].getText().equals("") && !btarray[8].getText().equals("") &&
                !controller.getlabel().getText().equals("Gewonnen!!!") && !controller.getlabel().getText().equals("Verloren!!!")) {
            controller.setlabel("Unentschieden!!!");
            setalldis();
        }


    }

    private void setalldis() {      //alle Buttons disablen

        for (int i = 0; i < btarray.length; i++) {
            btarray[i].setDisable(true);

        }
        controller.setreset(false);

    }

    private void ergebnis(boolean t) {           //Ergebniss setzten

        if (t) {
            controller.setlabel("Gewonnen!!!");
        } else {
            controller.setlabel("Verloren!!!");
        }
        setalldis();

    }
}





