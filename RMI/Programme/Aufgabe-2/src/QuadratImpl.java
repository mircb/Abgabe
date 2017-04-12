/**
 * Created by stbormir on 20.03.2017.
 */

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


public class QuadratImpl extends UnicastRemoteObject implements Quadrat {


    public QuadratImpl() throws RemoteException {

    }

    public long quadrat(long i) {
        return i * i;
    }           //Implementation der Funktion


}