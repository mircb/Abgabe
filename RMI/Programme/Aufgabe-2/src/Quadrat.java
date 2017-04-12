/**
 * Created by stbormir on 20.03.2017.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  Quadrat  extends Remote {             //Interface des Remote Objekts

         long quadrat(long i) throws RemoteException;

}
