import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SistemaImpl implements ISistema {
    private List<Carro> carroList;

    public Carro oi() {
        return new Carro("Fiat Uno", "123456789", "economico", "2010", 1, 10000);
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
        carroList.add(carro);
        return carroList;
    }

    public void removeCarro(Carro carro) throws RemoteException {
        carroList.remove(carro);
    }

    public List<Carro> getCarroList() throws RemoteException {
       return carroList;
    }

}
