/**
 * Created by stbormir on 20.03.2017.
 */


import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class QuadratImpl extends UnicastRemoteObject implements Quadrat {


    public QuadratImpl() throws RemoteException {

    }

    public double quadrat( double i) {
        return i*i;
    }


    public static void main(String [] args) {
        try {
            // Create a  remote object
            QuadratImpl h = new QuadratImpl();
            Quadrat h_stub = (Quadrat) UnicastRemoteObject.exportObject(h, 0);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}