import java.rmi.Remote;  
import java.rmi.RemoteException;  
public interface Square extends Remote{  
public int square(int x)throws RemoteException;  
}  