import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SistemaImpl extends UnicastRemoteObject implements ISistema {
    private List<Carro> carroList;

    protected SistemaImpl() throws RemoteException {
        
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

    public void adicionaCarro(Carro carro) throws RemoteException {
        carroList.add(carro);
    }

    public void removeCarro(Carro carro) throws RemoteException {
        carroList.remove(carro);
    }

    public List<Carro> getCarroList() throws RemoteException {
       return carroList;
    }

}
