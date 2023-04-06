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
                    System.out.println("Bem vindo " + user.getNome()+ " você é um funcionario");
                    menuFuncionario(stub);
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
                        stub.vendendo(car);
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

                    if (compra2.equals("s")){
                        stub.vendendo(car2);
                        System.out.println("Carro comprado com sucesso!");
                    }
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

    public static void menuFuncionario(ISistema stub) throws RemoteException{
        String option = "";
        boolean flag = false;
        do {
            System.out.println("1 - Buscar carro por nome");
            System.out.println("2 - Buscar carro por Renavam");
            System.out.println("3 - Lista de carros");
            System.out.println("4 - Adicionar carro");
            System.out.println("5 - Remover carro");
            System.out.println("6 - Editar carro");
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
                    break;

                case "2":
                    System.out.println("Digite o Renavam do carro: ");
                    String renavam = scanner.nextLine();
                    Carro car2 = stub.buscaCarroByRenavam(renavam);
                    if(car2 == null){
                        System.out.println("Carro não encontrado");
                        break;
                    }
                    System.out.println(car2.toString());
                    break;

                case "3":
                    listaCarros(stub);
                    break;

                case "4":
                    System.out.println("Digite o id do carro: ");
                    int id = scanner.nextInt();
                    System.out.println("Digite o nome do carro: ");
                    scanner.nextLine();
                    String nomeCarro = scanner.nextLine();
                    System.out.println("Digite o renavam do carro: ");
                    String renavamCarro = scanner.nextLine();
                    System.out.println("Digite o ano do carro: ");
                    String anoCarro = scanner.nextLine();
                    System.out.println("Digite a quantidade do carro em estoque: ");
                    int quantidade = scanner.nextInt();
                    System.out.println("Digite o preço do carro: ");
                    Double preco = scanner.nextDouble();
                    System.out.println("Digite o tipo do carro: 1 - Economico, 2 - Intermediário, 3 - Executivo");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if(tipo == 1){
                        stub.adicionaCarro(new Economico(id, nomeCarro, renavamCarro, anoCarro, quantidade, preco));
                    };
                    if(tipo == 2){
                        stub.adicionaCarro(new Intermediario(id, nomeCarro, renavamCarro, anoCarro, quantidade, preco));
                    };
                    if(tipo == 3){
                        stub.adicionaCarro(new Executivo(id, nomeCarro, renavamCarro, anoCarro, quantidade, preco));
                    };

                    System.out.println("Carro adicionado com sucesso!");
                    break;
                
                case "5": 
                    System.out.println("Digite o id do carro: ");
                    int idCarro = scanner.nextInt();
                    stub.removeCarroById(idCarro);
                    System.out.println("Carro removido com sucesso!");
                    scanner.nextLine();
                    break;

                case "6": 
                    System.out.println("Digite o id do carro: ");
                    int idCarro2 = scanner.nextInt();
                    var carro2 = stub.buscaCarroById(idCarro2);
                    System.out.println(carro2.toString()); 
                    scanner.nextLine();
                    System.out.println("Digite o nome do carro para ser alterado: ");
                    String nomeCarro2 = scanner.nextLine();
                    System.out.println("Digite o renavam do carro para ser alterado: ");
                    String renavamCarro2 = scanner.nextLine();
                    System.out.println("Digite o ano do carro para ser alterado: ");
                    String anoCarro2 = scanner.nextLine();
                    System.out.println("Digite a quantidade do carro em estoque: ");
                    int quantidade2 = scanner.nextInt();
                    System.out.println("Digite o preço do carro para ser alterado: ");
                    Double preco2 = scanner.nextDouble();
                    scanner.nextLine();

                    stub.editaCarroById(idCarro2, new Carro(idCarro2, nomeCarro2, renavamCarro2, anoCarro2, carro2.getCategoria() , quantidade2, preco2));
                    System.out.println("Carro editado com sucesso!");
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
         System.out.println("================ Lista de carros ================");
         carros.forEach((car)->{
             System.out.println(car.toString());
         });

         System.out.println("==================================================");
    }



    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
