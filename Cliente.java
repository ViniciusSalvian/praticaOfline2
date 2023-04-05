import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    static Scanner scanner = new Scanner(System.in);

    private Cliente() {

    }

    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost");
            ISistema stub = (ISistema) registro.lookup("Sistema");
            User user = null;

            while (user == null) {
                System.out.println("Digite o login: ");
                String login = scanner.nextLine();
                System.out.println("Digite a senha: ");
                String senha = scanner.nextLine();

                user = stub.login(login, senha);
                if(user == null) System.out.println("Login ou senha incorretos");
            }

            

            switch (user.getTipo()) {
                case "Cliente":
                    System.out.println("Bem vindo " + user.getNome());
                    menuCliente(stub);
                    break;
                case "Funcionario":
                    System.out.println("Bem vindo " + user.getNome());
                    break;
            }

        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }

    }

    public static void menuCliente(ISistema stub) throws RemoteException {
        String option = "";
        boolean flag = false;
        do {
            System.out.println("1 - Buscar carro por nome");
            System.out.println("2 - Buscar carro por Renavam");
            System.out.println("3 - Lista de carros");
            System.out.println("0 - Sair");
            option = scanner.nextLine();
            

            switch (option) {
                case "1":
                    System.out.println("Digite o nome do carro: ");
                    String nome = scanner.nextLine();
                    Carro car = stub.buscaCarroByName(nome);

                    if(car == null){
                        System.out.println("Carro não encontrado");
                        break;
                    }

                    System.out.println(car.toString());

                    System.out.println("Deseja comprar esse carro? (s/n)");
                    String compra = scanner.nextLine();

                    if (compra.equals("s")){
                        stub.removeCarro(car);
                        System.out.println("Carro comprado com sucesso!");
                    }
                    break;

                case "2":
                    System.out.println("Digite o Renavam do carro: ");
                    String renavam = scanner.nextLine();
                    Carro car2 = stub.buscaCarroByRenavam(renavam);
                    System.out.println(car2.toString());

                    System.out.println("Deseja comprar esse carro? (s/n)");
                    String compra2 = scanner.nextLine();

                    if (compra2.equals("s"))
                        stub.removeCarro(car2);
                    else
                        break;
                case "3":
                    listaCarros(stub);
                    break;

                case "0":
                    flag = true;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!flag);
    }


    public static void listaCarros(ISistema stub) throws RemoteException {
         List<Carro> carros = stub.getCarroList();
         System.out.println("=============Lista de carros=============");
         carros.forEach((car)->{
             System.out.println(car.toString());
         });
    }



    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
