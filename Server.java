import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            // Crie as réplicas da aplicação
            List<ISistema> replicas = new ArrayList<>();
            replicas.add(new SistemaImpl(false));
            replicas.add(new SistemaImpl(false));
            replicas.add(new SistemaImpl(true));

            // Crie o serviço gateway
            ServiceGatewayImpl gateway = new ServiceGatewayImpl(replicas);

            // Inicie o registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registre o serviço gateway no registro RMI
            registry.rebind("ServiceGateway", gateway);

            System.out.println("Server started.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
