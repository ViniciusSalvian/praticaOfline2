import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class SistemaImpl implements ISistema {
    private List<Carro> carroList;
    private List<User> userList;
    private boolean lider;

    public SistemaImpl(boolean lider) throws RemoteException {
        super();
        this.lider = lider;
        carroList = new ArrayList<Carro>();
        userList = new ArrayList<User>();
        userList.add(new UserCliente("valdir", "trollita", "123321"));
        userList.add(new UserCliente("jaco", "jacogames", "123456"));
        userList.add(new Funcionario("vinicius", "inhegaz", "12345678"));

        carroList.add(new Economico(1, "Fiat Novo uno", "1234567890", "2012", 1, 40000));
        carroList.add(new Economico(2, "Chevrolet onix", "123123321", "2014", 1, 450000));
        carroList.add(new Economico(3, "Ford ka", "123456123", "2011", 1, 43000));
        carroList.add(new Economico(4, "Nissan march", "123456987", "2015", 1, 52000));

        carroList.add(new Intermediario(5, "Ford Ka sedan", "123321123", "2016", 1, 82000));
        carroList.add(new Intermediario(6, "Hyundai hb20s", "123321321", "2020", 1, 85000));
        carroList.add(new Intermediario(7, "Renault logan", "123654123", "2017", 1, 80000));
        carroList.add(new Intermediario(8, "Toyota etios", "123789456", "2009", 1, 90000));

        carroList.add(new Executivo(9, "Toyota corolla", "987654321", "2020", 1, 104000));
        carroList.add(new Executivo(10, "Honda civic", "987987321", "2021", 1, 103000));
        carroList.add(new Executivo(11, "Porshe cayman", "987654123", "2021", 1, 102000));
        carroList.add(new Executivo(12, "chevrolet cruze", "123456789", "2019", 2, 100000));
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

    public void vendendo(Carro carro) throws RemoteException {
        if (carro.getQuantidade() == 1) {
            removeCarro(carro);
        } else {
            Carro car = buscaCarroByName(carro.getNome());
            var index = carroList.indexOf(car);
            carroList.get(index).vendendo();
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

    @Override
    public void atualizaReplica(List<Carro> carroList, List<User> userList) throws RemoteException {
        if(!lider){
            //Muita fé
        }
    }

}
