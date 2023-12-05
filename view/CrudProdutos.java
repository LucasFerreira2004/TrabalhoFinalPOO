package view;

import control.Data;
import model.Estoquista;
import model.Produto;
import model.*;

public class CrudProdutos extends ViewModel{
    public Estoquista estoquista;

    public CrudProdutos(Estoquista e){
        estoquista = e;
    }
    public CrudProdutos(){
        estoquista = new Estoquista("", 0, "");
        //esse construtor é acionado quando o menuGerente chama o CrudProdutos
    }

    @Override
    public void show(Data data) {
        while (true) {
            println("-----CRUD Produtos-----");
            println("1. Adicionar produto");
            println("obs: os tipos de produtos são: " +
                      "\n  - alimenticio"
                    + "\n  - bebida"
                    + "\n  - limpeza"
                    + "\n  - higiene"
                    + "\n  - eletronico"
                    + "\n  - pets"
                    + "\n  - outros");
            println("2. Atualizar Produto");
            println("3. Ver Produto por id");
            println("4. Mostrar todos os produto");
            println("5. Remover Produto");
            println("6. back: volta para o menu anterior");

            try {
                int opcao = Integer.parseInt(input());
                String nome, tipo;
                int id, qtd;
                double preco;

                switch (opcao) {
                    case 1:
                        println("preencha as informações do novo produto:");
                        print("id: ");
                        id = toInt(input());
                        if (id < 1){println("falha ao cadastrar: o id deve ser maior do que 0"); break;}
                        print("nome: ");
                        nome = input();
                        print("tipo: ");
                        tipo = input();
                        print("quantidade: ");
                        qtd = toInt(input());
                        print("preco: ");
                        preco = toDouble(input());
                        if (preco <= 0 || qtd <= 0){println("falha ao cadastrar: a quantidade e o preco devem ser maiores que 0"); break;}
                        estoquista.addProduto(id, new Produto(nome, data.createType(tipo), qtd, preco));
                        break;
                    case 2:
                        println("preencha as informações para atualizar o produto");
                        print("id do produto a ser atualizado: ");
                        id = toInt(input());
                        if (id < 1){println("o id deve ser maior do que 0"); break;}
                        println("agora preencha todas as informações que serão colocadas no produto");
                        print("nome: ");
                        nome = input();
                        print("tipo: ");
                        tipo = input();
                        print("quantidade: ");
                        qtd = toInt(input());
                        print("preco: ");
                        preco = toDouble(input());
                        if (preco <= 0 || qtd <= 0){println("falha ao atualizar: a quantidade e o preco devem ser maiores que 0"); break;}
                        estoquista.updateProduto(id, new Produto(nome, data.createType(tipo), qtd, preco));
                        break;

                    case 3:
                        println("insira o id do produto que deseja buscar");
                        id = toInt(input());
                        println(estoquista.getProdutoById(id));
                        break;
                    case 4:
                        print(estoquista.showProdutos());
                        break;
                    case 5:
                        println("preencha o id do produto que deseja deletar: ");
                        print("id: ");
                        id = toInt(input());
                        estoquista.delProdutoById(id);
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
