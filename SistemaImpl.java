import java.rmi.RemoteException;
import java.util.List;

public class SistemaImpl implements Sistema {

    private List<Carro> carroList;

    @Override
    public Carro buscaCarroByName(String name) throws RemoteException {
        for (Carro carro : carroList) {
            if (carro.getNome().equals(name)) {
                return carro;
            }
        }
        return null;
    }

    @Override
    public Carro buscaCarroByRenavam(String renavam) throws RemoteException {
        for (Carro carro : carroList) {
            if (carro.getRenavam().equals(renavam)) {
                return carro;
            }
        }
        return null;
    }

    @Override
    public void adicionaCarro(Carro carro) throws RemoteException {
        carroList.add(carro);
    }

    @Override
    public void removeCarro(Carro carro) throws RemoteException {
        carroList.remove(carro);
    }

    @Override
    public List<Carro> getCarroList() throws RemoteException {
       return carroList;
    }

}
