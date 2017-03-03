import javafx.scene.control.Button;

/**
 * Created by Mirco B on 03.03.2017.
 */
public class Nachricht extends AbstactMessage {



    int[][] feld = new int[7][6];

    javafx.scene.control.Button Nbutton;

    public int[][] getFeld() {
        return feld;
    }

    public void setFeld(int[][] feld) {
        this.feld = feld;
    }


    public Button getNbutton() {
        return Nbutton;
    }

    public void setNbutton(Button nbutton) {
        Nbutton = nbutton;
    }






}
