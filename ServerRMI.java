import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI extends SistemaImpl {

    public ServerRMI() throws Exception {
        
    }
    public static void main(String args[]) {
        try {
            
            SistemaImpl sistemaImpl = new SistemaImpl();
            ISistema stub = (ISistema) UnicastRemoteObject.exportObject(sistemaImpl, 0);
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Registry registro = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            registro.bind("Sistema",stub);
            System.out.println("Servidor pronto:");
        } catch (Exception e) {
        System.err.println("Servidor: " + e.toString());
        e.printStackTrace();
        }
    }
}
