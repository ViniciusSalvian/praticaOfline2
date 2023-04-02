
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome/endereço do RMIRegistry:");
        String host = teclado.nextLine();
        try {
            Registry registro = LocateRegistry
                    .getRegistry(host, 20003);
            Sistema stub = (Sistema) registro
                    .lookup("Sistema");
            stub.adicionaCarro(new Carro("Fiat Uno", "123456789", "economico", "2010", 1, 10000));
            System.out.println(stub.getCarroList());
            teclado.close();
        } catch (Exception e) {
            System.err.println("Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
