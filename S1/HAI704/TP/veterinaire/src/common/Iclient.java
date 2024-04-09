package common;

import java.rmi.RemoteException;

public interface Iclient {
    void alerte(String message) throws RemoteException;
}
