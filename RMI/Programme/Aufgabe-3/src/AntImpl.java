import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.spec.ECField;

/**
 * Created by stbormir on 03.04.2017.
 */



public class AntImpl extends UnicastRemoteObject implements Ant {


    public AntImpl() throws RemoteException {

    }

   public void  Antwort(String i, Client c) {
        try {
            Thread.sleep(10000);

        } catch (Exception e) {
        }
        c.Ausgeben("Die Antwort auf  <" + i + "> ist wahrscheinlich 42 \n(miteinberechnet werden Zeitverschiebung, Zufall, " +
                "die Unendlichkeit des Universums und Alles was existiert)");
    }

}
