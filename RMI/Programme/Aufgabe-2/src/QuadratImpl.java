/**
 * Created by stbormir on 20.03.2017.
 */


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class QuadratImpl extends UnicastRemoteObject implements Quadrat {


    public QuadratImpl() throws RemoteException {

    }

    public double quadrat(double i) {
        return i * i;
    }           //Implementation der Funktion


}