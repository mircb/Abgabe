import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by stbormir on 20.03.2017.
 */
public class QuadratClient {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java HelloClient <rmiregistry host>");
                return;
            }
            String host = args[0];
            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Quadrat h = (Quadrat) registry.lookup("Hello1");
            // Remote method invocation
            double res = h.quadrat(4);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
