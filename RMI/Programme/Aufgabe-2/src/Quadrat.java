/**
 * Created by stbormir on 20.03.2017.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  Quadrat  extends Remote {             //Interface des Remote Objekts

         double quadrat(double i) throws RemoteException;

}
