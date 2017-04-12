import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by stbormir on 20.03.2017.
 */
public class QuadratClient {

    public static void main(String[] args) {        //Client
        try {

            String host;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Adresse eingeben andie verbunden werden soll:");

            host= reader.readLine();

            Registry registry = LocateRegistry.getRegistry(host,1099);
            Quadrat h = (Quadrat) registry.lookup("test");


            System.out.println("Zahl eingeben die Berechnet werden soll:");
            String enter= reader.readLine();

            double res = h.quadrat(Integer.parseInt(enter));

            System.out.println("Ergebniss: "+res);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
