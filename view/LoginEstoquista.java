package view;

import model.Estoquista;

public class LoginEstoquista extends ViewModel {

    @Override
    public void show(control.Data data) {
        while (true) {
            try {
                println("-----login estoquista-----");
                print("identificador: ");
                String id = input();
                print("senha: ");
                String senha = input();

                Estoquista estoquista = data.getEstoquistaByid(Integer.parseInt(id));

                if (estoquista == null) {
                    println("fail: não existe nenhum estoquista com esse identificador");
                    println("digite 's' para sair do menu de login e qualquer outra letra para permanecer: ");
                    String continuar = input();
                    if (continuar.toLowerCase().equals("s")) break;
                } else if (!estoquista.getSenha().equals(senha)) {
                    println("fail: senha incorreta");
                    println("digite 's' para sair do menu de login e qualquer outra letra para permanecer");
                    String continuar = input();
                    if (continuar.toLowerCase().equals("s")) break;
                } else {
                    println("Login realizado com sucesso!");
                    new CrudProdutos(estoquista).show(data);
                    break;
                }
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
}
