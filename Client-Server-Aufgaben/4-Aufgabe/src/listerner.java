
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
        this.controller = r;
        this.start();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Nachricht msg;

            while (true) {
                controll();
                msg = (Nachricht) in.readObject();          //Wenn nachricht erhalten werden die Buttons geändert




                String bName = msg.getMessage();       // Erweitern

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
                    bt.setDisable(true);;
                    bt.setStyle("-fx-background-color ##FF0000;");
                    controller.setpane(false);
                    controll();
                }
            }
        });

    }

    private void controll() {           //Überprüfung ob jemand gewonnen, verloren oder Unentschieden

            //Nicht Fertig
            setalldis();
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





