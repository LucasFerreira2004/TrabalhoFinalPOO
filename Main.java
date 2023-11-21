import control.Data;
import model.Estoquista;
import model.Gerente;
import model.ProductType;
import model.Produto;
import view.MenuInicial;

public class Main {
    static Data data = new Data();

    public static void main(String[] args) {
        try {
            Estoquista func = new Estoquista("rootFunc", 1400, "12345");
            Gerente gere = new Gerente("rootGere", 2400, "12345", 100);
            data.addFuncionario(1000, func);
            data.addGerente(1000, gere);
            func.addProduto(1000, new Produto("prodTeste", ProductType.LIMPEZA, 1, 1));
        } catch (Exception ignored) {
        }

        new MenuInicial().show(data);
    }


}
