package view;
import control.Data;
import model.Estoquista;
import model.Gerente;

public class CrudGerentes extends ViewModel{
    private Gerente gerente;

    public CrudGerentes( Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public void show(Data data) {
        while (true) {
            println("-----CRUD Gerentes-----");
            println("1. Adicionar Gerente");
            println("2. Atualizar Gerente");
            println("3. Ver Gerente por id");
            println("4. Mostrar todos os Gerentes");
            println("5. Remover Gerente");
            println("6. back: volta para o menu anterior");

            try {
                int opcao = Integer.parseInt(input());
                String nome, senha;
                double salario, adicionalSalario;
                int id;

                switch (opcao) {
                    case 1:
                        println("preencha as informações do novo Gerente :");
                        print("id: ");
                        id = toInt(input());
                        print("nome: ");
                        nome = input();
                        print("senha: ");
                        senha = input();
                        print("salario: ");
                        salario = toDouble(input());
                        print("adicional salario: ");
                        adicionalSalario = toDouble(input());
                        if (id <= 0){println("falha ao cadastrar: o id deve ser maior do que 0"); break;}
                        if (salario <= 0 || adicionalSalario <= 0) {
                            println("falha ao cadastrar: salario e adicional salario devem ser maiores que 0");
                            break;
                        }
                        gerente.addFuncionario(id, new Gerente(nome, salario, senha, adicionalSalario));
                        break;

                    case 2:
                        println("preencha as informações para atualizar o Gerente");
                        print("id do Gerente a ser atualizado: ");
                        id = toInt(input());
                        println("agora preencha todas as informações que serão colocadas no funcionario");
                        print("nome: ");
                        nome = input();
                        print("senha: ");
                        senha = input();
                        print("salario: ");
                        salario = toDouble(input());
                        print("adicional salario: ");
                        adicionalSalario = toDouble(input());
                        if (id <= 0){println("falha ao cadastrar: o id deve ser maior do que 0"); break;}
                        if (salario <= 0 || adicionalSalario <= 0) {
                            println("falha ao cadastrar: salario e adicional salario devem ser maiores que 0");
                            break;
                        }
                        gerente.updateGerente(id, new Gerente(nome, salario, senha, adicionalSalario));
                        break;

                    case 3:
                        println("insira o id do Gerente que deseja buscar");
                        id = toInt(input());
                        println(gerente.getGerenteByid(id));
                        break;
                    case 4:
                        print(gerente.showGerentes());
                        break;
                    case 5:
                        println("preencha o id do Gerente que deseja deletar: ");
                        print("id: ");
                        id = toInt(input());
                        gerente.deleteGerenteById(id);
                        break;
                    case 6:
                        return;
                    default:
                        println("fail: comando invalido");
                        break;
                }
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
}
