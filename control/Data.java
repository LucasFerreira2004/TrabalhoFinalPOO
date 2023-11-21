package control;
import model.*;


import java.util.*;
public class Data {
    protected static Map<Integer, Produto> produtos;
    protected static Map<Integer, Estoquista> estoquistas;
    protected static Map<Integer, Gerente> gerentes;

    protected static int prodId = 1, funcId = 1, gereId = 1;
    //essas variavéis estão aqui caso surja a necessidade de id autoincrementado.

    public Data (){
        produtos = new LinkedHashMap<Integer, Produto>();
        estoquistas = new LinkedHashMap<Integer, Estoquista>();
        gerentes = new LinkedHashMap<Integer, Gerente>();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("\n*Produtos*: \n");
        s.append(mapToString(produtos));

        s.append("\n*Estoquistas*: \n");
        s.append(mapToString(estoquistas));

        s.append("\n*Gerentes*: \n");
        s.append(mapToString(gerentes));

        return s.toString();
    }

    private String mapToString (Map m){
        StringBuilder s = new StringBuilder();
        s.append("--------------------\n");

        for (Object key : m.keySet()) {
            Object value = m.get(key);
            s.append("id: " + key);
            s.append("\n" + value);
            s.append("\n--------------------");
            s.append("\n");
        }

        return s.toString();
    }
    //creates

    public void addFuncionario(int id, Estoquista f){
        estoquistas.put(id, f);
    }
    public void addGerente (int id, Gerente g){
        gerentes.put(id, g);
    }

    public ProductType createType(String s) throws Exception{
        switch (s.toUpperCase()){
            case "LIMPEZA":
                return ProductType.LIMPEZA;
            case "ALIMENTICIO":
                return ProductType.ALIMENTICIO;
            case "HIGIENE":
                return ProductType.HIGIENE;
            case "ELETRONICO":
                return ProductType.ELETRONICO;
            case "PETS":
                return ProductType.PETS;
            case "BEBIDAS":
                return ProductType.BEBIDA;
            case "OUTROS":
                return ProductType.OUTROS;
            default:
                throw new Exception("fail: tipo incompatível");
        }

    }

    //getters e setters
    public Produto getProdutoById (int id){
        return produtos.get(id);
    }
    public Estoquista getEstoquistaByid (int id){
        return estoquistas.get(id);
    }
    public Gerente getGerenteById(int id){return gerentes.get(id);}

}
