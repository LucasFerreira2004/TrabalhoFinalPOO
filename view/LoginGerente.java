package view;

import control.Data;
import model.Estoquista;
import model.Gerente;

public class LoginGerente extends ViewModel{
    @Override
    public void show(Data data) {
        while (true) {
            try {
                println("-----login Gerente-----");
                print("identificador: ");
                String id = input();
                print("senha: ");
                String senha = input();

                Gerente gerente = data.getGerenteById(Integer.parseInt(id));

                if (gerente == null) {
                    println("fail: não existe nenhum gerente com esse identificador");
                    println("digite 's' para sair do menu de login e qualquer outra letra para permanecer: ");
                    String continuar = input();
                    if (continuar.toLowerCase().equals("s")) break;
                } else if (!gerente.getSenha().equals(senha)) {
                    println("fail: senha incorreta");
                    println("digite 's' para sair do menu de login e qualquer outra letra para permanecer");
                    String continuar = input();
                    if (continuar.toLowerCase().equals("s")) break;
                } else {
                    println("Login realizado com sucesso!");
                    new MenuGerente(gerente).show(data); //verificar essa linha depois
                    break;
                }
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
}
