import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            // Getting the registry
            var registry = LocateRegistry.getRegistry();

            // Looking up the registry for the remote object
            var stub = (Square) registry.lookup("Square");

            // Calling the remote method using the obtained object
            try (var scan = new Scanner(System.in)) {
                System.out.print("Enter any number: ");

                // This method reads the number provided using keyboard
                int num = scan.nextInt();
                System.out.println("The square is " + stub.square(num));
            }

            // System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
