import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServiceGatewayImpl extends UnicastRemoteObject implements ISistema {
    private List<ISistema> replicas;
    private int currentReplicaIndex;

    public ServiceGatewayImpl(List<ISistema> replicas) throws RemoteException {
        this.replicas = new ArrayList<>(replicas);
        currentReplicaIndex = 0;
    }

    private synchronized ISistema getNextReplica() {
        int index = currentReplicaIndex;
        currentReplicaIndex = (currentReplicaIndex + 1) % replicas.size();
        return replicas.get(index);
    }


    @Override
    public Carro buscaCarroByName(String name) throws RemoteException {
        return replicas.get(currentReplicaIndex).buscaCarroByName(name);
    }

    @Override
    public Carro buscaCarroByRenavam(String renavam) throws RemoteException {
       return replicas.get(currentReplicaIndex).buscaCarroByRenavam(renavam);
    }

    @Override
    public List<Carro> adicionaCarro(Carro carro) throws RemoteException {
        return replicas.get(currentReplicaIndex).adicionaCarro(carro);
    }

    @Override
    public void removeCarro(Carro carro) throws RemoteException {
        replicas.get(currentReplicaIndex).removeCarro(carro);
    }

    @Override
    public List<Carro> getCarroList() throws RemoteException {
        System.out.println("Retornou lista de Carro na replica:" + currentReplicaIndex);
        var list = replicas.get(currentReplicaIndex).getCarroList();
        getNextReplica();
        return list;
    }

    @Override
    public User login(String username, String password) throws RemoteException {
       return replicas.get(currentReplicaIndex).login(username, password);
    }

    @Override
    public List<User> getUserList() throws RemoteException {
        return replicas.get(currentReplicaIndex).getUserList();
    }

    @Override
    public void vendendo(Carro carro) throws RemoteException {
        replicas.get(currentReplicaIndex).vendendo(carro);
    }

    @Override
    public void removeCarroById(int id) throws RemoteException {
        replicas.get(currentReplicaIndex).removeCarroById(id);
    }

    @Override
    public Carro buscaCarroById(int id) throws RemoteException {
        return replicas.get(currentReplicaIndex).buscaCarroById(id);
    }

    @Override
    public void editaCarroById(int id, Carro carro) throws RemoteException {
        replicas.get(currentReplicaIndex).editaCarroById(id, carro);
    }

    @Override
    public void atualizaReplica(List<Carro> carroList, List<User> userList) throws RemoteException {
        
    }
}
