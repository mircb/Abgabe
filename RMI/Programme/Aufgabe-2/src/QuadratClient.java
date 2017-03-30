import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by stbormir on 20.03.2017.
 */
public class QuadratClient {

    public static void main(String[] args) {
        try {                                           //Client

            String host = "127.0.0.1";


            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host,4242);
            Quadrat h = (Quadrat) registry.lookup("test");
            // Remote method invocation
            double res = h.quadrat(4);

            System.out.println("Ergebniss: "+res);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
