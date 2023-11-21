package view;
import model.Estoquista;
import model.Gerente;
import control.Data;

public class CrudEstoquistas extends ViewModel{
    private Gerente gerente;

    public CrudEstoquistas(Gerente gerente){
        this.gerente = gerente;
    }

    public void show(Data data) {
        while (true) {
            println("-----CRUD Estoquistas-----");
            println("1. Adicionar Estoquista");
            println("2. Atualizar Estoquista");
            println("3. Ver Estoquista por id");
            println("4. Mostrar todos os estoquistas");
            println("5. Remover Estoquista");
            println("6. back: volta para o menu anterior");

            try {
                int opcao = Integer.parseInt(input());
                String nome, senha;
                double salario, bonus;
                int id;

                switch (opcao) {
                    case 1:
                        println("preencha as informações do novo Estoquista :");
                        print("id: ");
                        id = toInt(input());
                        print("nome: ");
                        nome = input();
                        print("senha: ");
                        senha = input();
                        print("salario: ");
                        salario = toDouble(input());
                        if (id <= 0) {println("falha ao cadastrar: o id deve ser maior do que 0"); break;}
                        if (salario <= 0) { println("falha ao cadastrar: salario deve ser maior que 0"); break;}
                        gerente.addFuncionario(id, new Estoquista(nome, salario, senha));
                        break;

                    case 2:
                        println("preencha as informações para atualizar o Estoquista");
                        print("id do Estoquista a ser atualizado: ");
                        id = toInt(input());
                        println("agora preencha todas as informações que serão colocadas no funcionario");
                        print("nome: ");
                        nome = input();
                        print("senha: ");
                        senha = input();
                        print("salario: ");
                        salario = toDouble(input());
                        if (id <= 0) {println("falha ao cadastrar: o id deve ser maior do que 0"); break;}
                        if (salario <= 0) { println("falha ao cadastrar: salario deve ser maior que 0"); break;}
                        gerente.updateEstoquista(id, new Estoquista(nome, salario, senha));
                        break;

                    case 3:
                        println("insira o id do estoquista que deseja buscar");
                        id = toInt(input());
                        println(gerente.getEstoquistaById(id));
                        break;
                    case 4:
                        print(gerente.showEstoquistas());
                        break;
                    case 5:
                        println("preencha o id do estoquista que deseja deletar: ");
                        print("id: ");
                        id = toInt(input());
                        gerente.deleteEstoquistaById(id);
                        break;
                    case 6:
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
