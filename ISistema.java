import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISistema extends Remote {
    Carro buscaCarroByName(String name) throws RemoteException;
    Carro buscaCarroByRenavam(String renavam) throws RemoteException;
    List<Carro> adicionaCarro(Carro carro) throws RemoteException;
    void removeCarro(Carro carro) throws RemoteException;
    List<Carro> getCarroList() throws RemoteException;
    User login(String username, String password) throws RemoteException;
    List<User> getUserList() throws RemoteException;
}
