import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceGatewayImpl extends UnicastRemoteObject implements ISistema {
    private List<ISistema> replicas;
    private int currentReplicaIndex;

    public ServiceGatewayImpl(List<ISistema> replicas) throws RemoteException {
        this.replicas = replicas;
        currentReplicaIndex = 0;
    }

    private synchronized ISistema getNextReplica() {
        int index = currentReplicaIndex;
        currentReplicaIndex = (currentReplicaIndex + 1) % replicas.size();
        return replicas.get(index);
    }


    @Override
    public Carro buscaCarroByName(String name) throws RemoteException {
        var carro = getNextReplica().buscaCarroByName(name);
        return carro;
    }

    @Override
    public Carro buscaCarroByRenavam(String renavam) throws RemoteException {
        var carro = getNextReplica().buscaCarroByRenavam(renavam);
        return carro;
    }

    @Override
    public void adicionaCarro(Carro carro) throws RemoteException {
        var replicaAtual = getNextReplica();
        replicaAtual.adicionaCarro(carro);
        atualizaReplica(replicaAtual.getCarroList(), replicaAtual.getUserList());
    }

    @Override
    public void removeCarro(Carro carro) throws RemoteException {
        var replicaAtual = getNextReplica();
        replicaAtual.removeCarro(carro);
        atualizaReplica(replicaAtual.getCarroList(), replicaAtual.getUserList());
    }

    @Override
    public List<Carro> getCarroList() throws RemoteException {
        System.out.println("Retornou lista de Carro na replica:" + currentReplicaIndex);

        var listCarro = getNextReplica().getCarroList();
        return listCarro;
    }

    @Override
    public User login(String username, String password) throws RemoteException {
        var user = getNextReplica().login(username, password);
        return user;
    }

    @Override
    public List<User> getUserList() throws RemoteException {
        var listUser = getNextReplica().getUserList();
        return listUser;
    }

    @Override
    public void vendendo(Carro carro) throws RemoteException {
        var replicaAtual = getNextReplica();
        replicaAtual.vendendo(carro);
        atualizaReplica(replicaAtual.getCarroList(), replicaAtual.getUserList());
    }

    @Override
    public void removeCarroById(int id) throws RemoteException {
        var replicaAtual = getNextReplica();
        replicaAtual.removeCarroById(id);
        atualizaReplica(replicaAtual.getCarroList(), replicaAtual.getUserList());
    }

    @Override
    public Carro buscaCarroById(int id) throws RemoteException {
        var carro = getNextReplica().buscaCarroById(id);
        return carro;
    }

    @Override
    public void editaCarroById(int id, Carro carro) throws RemoteException {
        var replicaAtual = getNextReplica();
        replicaAtual.editaCarroById(id, carro);
        atualizaReplica(replicaAtual.getCarroList(), replicaAtual.getUserList());
    }

    @Override
    public void atualizaReplica(List<Carro> carroList, List<User> userList) throws RemoteException {
        for(ISistema replica : replicas){
            replica.atualizaReplica(carroList, userList);
        }
    }
}
