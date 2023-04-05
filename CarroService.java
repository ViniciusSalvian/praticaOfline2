import java.util.List;

public class CarroService {

    public Carro buscaCarroByName(List<Carro> carroList, String nome) {
        for (Carro carro : carroList) {
            if (carro.getNome().equals(nome)) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByRenavam(List<Carro> carroList, String renavam) {
        for (Carro carro : carroList) {
            if (carro.getRenavam().equals(renavam)) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByCategoria(List<Carro> carroList, String categoria) {
        for (Carro carro : carroList) {
            if (carro.getCategoria().equals(categoria)) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByAno(List<Carro> carroList, String ano) {
        for (Carro carro : carroList) {
            if (carro.getAnoFabricacao().equals(ano)) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByQuantidade(List<Carro> carroList, int quantidade) {
        for (Carro carro : carroList) {
            if (carro.getQuantidade() == quantidade) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscaCarroByPreco(List<Carro> carroList, double preco) {
        for (Carro carro : carroList) {
            if (carro.getPreco() == preco) {
                return carro;
            }
        }
        return null;
    }

    public void adicionaCarro(List<Carro> carroList, Carro carro) {
        carroList.add(carro);
    }

    public void removeCarro(List<Carro> carroList, Carro carro) {
        carroList.remove(carro);
    }

    public void atualizaCarro(List<Carro> carroList, Carro carro) {
        for (Carro carro2 : carroList) {
            if (carro2.getNome().equals(carro.getNome())) {
                carro2.setNome(carro.getNome());
                carro2.setRenavam(carro.getRenavam());
                carro2.setCategoria(carro.getCategoria());
                carro2.setAnoFabricacao(carro.getAnoFabricacao());
                carro2.setQuantidade(carro.getQuantidade());
                carro2.setPreco(carro.getPreco());
            }
        }
    }

    public void imprimeCarro(List<Carro> carroList) {
        for (Carro carro : carroList) {
            System.out.println("Nome: " + carro.getNome());
            System.out.println("Renavam: " + carro.getRenavam());
            System.out.println("Categoria: " + carro.getCategoria());
            System.out.println("Ano de Fabricação: " + carro.getAnoFabricacao());
            System.out.println("Quantidade: " + carro.getQuantidade());
            System.out.println("Preço: " + carro.getPreco());
        }
    }

    
}
