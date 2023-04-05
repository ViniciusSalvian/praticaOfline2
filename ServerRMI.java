import java.rmi.server.UnicastRemoteObject;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI extends SistemaImpl {

    public ServerRMI() throws Exception {
        
    }
    public static void main(String args[]) {
        try {
            
            SistemaImpl sistemaImpl = new SistemaImpl();
            ISistema stub = (ISistema) UnicastRemoteObject.exportObject(sistemaImpl, 0);
            LocateRegistry.createRegistry(20002);
            Registry registro = LocateRegistry.getRegistry(20002);
            registro.rebind("Sistema", stub);
           // String objNome = "rmi://localhost:20003/Sistema";
           // LocateRegistry.createRegistry(20003);
           // Naming.rebind(objNome, new SistemaImpl());

            // Sistema skeleton =
            // (Sistema) UnicastRemoteObject
            // .exportObject(refObjetoRemoto, 0);
            // Registry registro =
            // LocateRegistry
            // .getRegistry("127.0.0.1",20003);
            // registro.bind("Sistema", skeleton);
            System.out.println("Servidor pronto:");
        } catch (Exception e) {
        System.err.println("Servidor: " + e.toString());
        e.printStackTrace();
        }
    }
}
