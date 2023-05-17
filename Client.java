import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Obtenha uma referência para o registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obtenha uma referência para o serviço gateway
            ISistema gateway = (ISistema) registry.lookup("ServiceGateway");

            // Inicie a aplicação
            var teste = gateway.getCarroList();
            System.out.println(teste);
            // Pare a aplicação após 5 segundos
            Thread.sleep(5000);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
