import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server extends SquareImpl {
    public Server() throws RemoteException {
    }

    public static void main(String args[]) {
        try {
            var obj = new SquareImpl();
            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            var stub = UnicastRemoteObject.exportObject(obj, 0) ;

            // Binding the remote object (stub) in the registry
            var registry = LocateRegistry.getRegistry();

            registry.bind("Square", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}