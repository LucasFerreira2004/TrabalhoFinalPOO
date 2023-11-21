package control;

import model.Produto;

public class ControlEstoquista {

    public boolean validaIdProduto(int id){
        return (Data.produtos.get(id) != null);
    }

    public String showProdutos() throws Exception{
        String s = "*Produtos*:\n";
        s += "--------------------\n";
        for (Integer i : Data.produtos.keySet()){
            s+= "id: " + i + "\n";
            s += getProdutoById(i).toString() + "\n";
            s += "--------------------\n";
        }
        return s;
    }
    //crud
    public void addProduto (int id, Produto p) throws Exception{
        if (validaIdProduto(id)) throw new Exception("id já cadastrado");
        Data.produtos.put(id, p);
        System.out.println("Produto Cadastrado com sucesso");
    }
    public Produto getProdutoById(int id) throws Exception{
        if (Data.produtos.get(id) == null){
            throw new Exception("id " + id + "nao encontrado");
        }
        return Data.produtos.get(id);
    }
    public void delProdutoById(int id) throws Exception{
        if (!validaIdProduto(id)) throw new Exception("id " + id + " nao encontrado");
        Data.produtos.remove(id);
        System.out.println("Produto Removido com sucesso");
    }
    public void updateProduto(int id, Produto p) throws Exception{
        if (!validaIdProduto(id)) throw new Exception("id " + id + " nao encontrado");
        Data.produtos.put(id, p);
        System.out.println("Produto de id "+ id+ " atualizado com sucesso");
    }
}
