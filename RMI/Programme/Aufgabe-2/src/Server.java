import java.io.FilePermission;
import java.net.SocketPermission;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by stbormir on 20.03.2017.
 */
public class Server {

    public static void main(String[] args) {
        try {


            System.setProperty("java.rmi.server.hostname", "127.0.0.2");
            QuadratImpl h = new QuadratImpl();

           // System.setSecurityManager(new SecurityManager());                             Versuch mit Rechten
            //SecurityManager security = System.getSecurityManager();

            //security.checkPermission(new SocketPermission("localhost:4242","listen,resolve"));
          // security.checkPermission(new FilePermission("Server.java", "read,write"));

            LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            Runtime.getRuntime().exec("rmiregistry");

            Registry registry = LocateRegistry.getRegistry();


            UnicastRemoteObject.unexportObject(h, true);

            Quadrat h_stub = (Quadrat) UnicastRemoteObject.exportObject(h, 4242);



            registry.bind("test", h_stub);                  //Hier immer Fehler

            System.out.println("Server ready");

        } catch (Exception e) {
            System.err.println("Error on server :" + e);
            e.printStackTrace();
        }


    }
}