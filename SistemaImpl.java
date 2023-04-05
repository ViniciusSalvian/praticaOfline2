import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class SistemaImpl implements ISistema {
    private List<Carro> carroList;
    private List<User> userList;


    public SistemaImpl() throws RemoteException {
        super();
        carroList = new ArrayList<Carro>();
        userList = new ArrayList<User>();
        userList.add(new UserCliente("valdir", "trollita", "123321"));
        userList.add(new UserCliente("jaco", "onichan", "123456"));
        userList.add(new Funcionario("Vinicius", "Inhegaz", "12345678"));

        carroList.add(new Economico(1,"Fiat Novo Uno", "123456789", "2010", 1, 10000));
        carroList.add(new Economico(2,"Chevrolet Onix", "123456789", "2010", 1, 10000));
        carroList.add(new Economico(3,"Ford Ka", "123456789", "2010", 1, 10000));

        carroList.add(new Intermediario(4, "ford ka sedan", "123456789", "2008", 1, 10000));
        carroList.add(new Intermediario(5, "ford ka sedan", "123456789", "2008", 1, 10000));
        carroList.add(new Intermediario(6, "ford ka sedan", "123456789", "2008", 1, 10000));

        carroList.add(new Executivo(7, "toyota corolla", "123456789", "2008", 1, 10000));
        carroList.add(new Executivo(8, "honda civic", "123456789", "2008", 1, 10000));
        carroList.add(new Executivo(9, "chevrolet cruze", "123456789", "2008", 1, 10000));
    }

    public User login(String username, String password) throws RemoteException {
        for (User user : userList) {
            if (user.getLogin().equals(username) && user.getSenha().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Carro buscaCarroByName(String name) throws RemoteException {
        for (Carro carro : carroList) {
            if (carro.getNome().equals(name)) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByRenavam(String renavam) throws RemoteException {
        for (Carro carro : carroList) {
            if (carro.getRenavam().equals(renavam)) {
                return carro;
            }
        }
        return null;
    }

    public List<Carro> adicionaCarro(Carro carro) throws RemoteException {
        this.carroList.add(carro);
        return carroList;
    }

    public void removeCarro(Carro carro) throws RemoteException {
        Carro car = buscaCarroByName(carro.getNome());
        int index = carroList.indexOf(car);

        carroList.remove(index);
    }

    public void vendendo(Carro carro) throws RemoteException{
        if(carro.getQuantidade() == 0){
            removeCarro(carro);
        }else{
            carro.vendendo();
        }
        
    }

    public void editaCarroById(int id, Carro carro) throws RemoteException {
        Carro car = buscaCarroById(id);
        int index = carroList.indexOf(car);

        carroList.set(index, carro);
    }
    public void removeCarroById(int id) throws RemoteException {
        Carro car = buscaCarroById(id);
        int index = carroList.indexOf(car);

        carroList.remove(index);
    }

    public Carro buscaCarroById(int id) throws RemoteException {
        for (Carro carro : carroList) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }

    public List<Carro> getCarroList() throws RemoteException {
        return carroList;
    }

    public List<User> getUserList() {
        return userList;
    }

}
