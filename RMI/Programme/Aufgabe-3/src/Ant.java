import com.sun.deploy.util.SessionState;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by stbormir on 03.04.2017.
 */
public interface  Ant  extends Remote {             //Interface des Remote Objekts

    void Antwort(String i, Client c) throws RemoteException;
}

