package view;

import control.Data;

public class MenuInicial extends ViewModel{

    public void show(Data data) {
        while (true) {
            println("-----Main menu-----");
            println("1. loginF\n" +
                    "2. loginG\n" +
                    "3. showAll\n" +
                    "4. end");

            try {
                int opcao = Integer.parseInt(input());

                switch (opcao) {
                    case 1:
                        new LoginEstoquista().show(data);
                        break;
                    case 2:
                        new LoginGerente().show(data);
                        break;
                    case 3:
                        print(data.toString());
                        break;
                    case 4:
                        return;
                    default:
                        println("fail: comando invalido");
                }

            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
}
