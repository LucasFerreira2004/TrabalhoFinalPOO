package view;

import control.Data;
import model.Gerente;

public class MenuGerente extends ViewModel{
    public Gerente gerente;
    public MenuGerente (Gerente g){
        gerente = g;
    }
    @Override
    public void show(Data data) {
        while (true){
            println("-----menu Gerente-----");
            println("selecione qual entidade você deseja trabalhar");
            println("1. Menu produto");
            println("2. Menu estoquista");
            println("3. Menu Gerente (crud)");
            println("4. back: voltar ao menu anterior");

              try{
                  int opc = toInt(input());

                  switch (opc){
                      case 1:
                          new CrudProdutos().show(data);
                          break;
                      case 2:
                          new CrudEstoquistas(this.gerente).show(data);
                          break;
                      case 3:
                          new CrudGerentes(this.gerente).show(data);
                          break;
                      case 4:
                          return;
                      default:
                          println("comando invalido");
                          break;
                  }
              }catch (Exception e){
                  println(e.getMessage());
              }
        }
    }
}
