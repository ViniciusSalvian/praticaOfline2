import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISistema extends Remote {
    Carro oi() throws RemoteException;
    Carro buscaCarroByName(String name) throws RemoteException;
    Carro buscaCarroByRenavam(String renavam) throws RemoteException;
    void adicionaCarro(Carro carro) throws RemoteException;
    void removeCarro(Carro carro) throws RemoteException;
    List<Carro> getCarroList() throws RemoteException;
}
