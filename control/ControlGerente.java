package control;

import model.Estoquista;
import model.Funcionario;
import model.Gerente;
import model.Produto;

public class ControlGerente extends ControlEstoquista {

    private boolean validarIdEstoquista(int id){
        return Data.estoquistas.containsKey(id);
    }
    private boolean validarIdGerente(int id){
        return Data.gerentes.containsKey(id);
    }
    public String showEstoquistas() throws Exception{
        String s = "*Estoquistas*: \n";
        s += "--------------------\n";
        for (Integer i : Data.estoquistas.keySet()){
            s += "id: " + i + "\n";
            s += getEstoquistaById(i).toString() + "\n";
            s += "--------------------\n";
        }
        return s;
    }
    public String showGerentes() throws Exception{
        String s = "*Gerentes: *: \n";
        s = "--------------------\n";
        for (Integer i : Data.gerentes.keySet()){
            s +=  "id: "+ i + "\n";
            s+= getGerenteByid(i).toString() + "\n";
            s += "--------------------\n";
        }
        return s;
    }
    //o addFuncionario é responsável por cadastrar tanto gereentes quanto estoquistas.
    public void addFuncionario (int id, Funcionario f) throws Exception{
        if (f instanceof Estoquista){
            if (Data.estoquistas.containsKey(id)) throw new Exception("id já cadastrado");
            Data.estoquistas.put(id, (Estoquista) f);
            System.out.println("Estoquista cadastrado com suceso");

        }
        else if (f instanceof Gerente){
            if (Data.gerentes.containsKey(id)) throw new Exception("id já cadastrado");
            Data.gerentes.put(id, (Gerente) f);
            System.out.println("Gerente cadastrado com sucesso");
        }
        else{
            throw new RuntimeException("erro ao cadastrar o funcionário");
        }
    }

    // -------crud  estoquistas
    public  Estoquista getEstoquistaById(int id) throws Exception{
        if (!validarIdEstoquista(id)){
            throw new Exception("id " + id + "nao encontrado");
        }
        return Data.estoquistas.get(id);
    }
    public void updateEstoquista(int id, Estoquista e) throws Exception{
        if (!Data.estoquistas.containsKey(id)) throw new Exception("id " + id + " nao encontrado");
        Data.estoquistas.put(id, e);
        System.out.println("Estoquista de id "+ id +" atualizado com sucesso");

    }
    public void deleteEstoquistaById(int id) throws Exception{
        if (!Data.estoquistas.containsKey(id)) throw new Exception("id "+id+" nao encontrado");
        Data.estoquistas.remove(id);
        System.out.println("Estoquista removido com suceso");
    }

    // -------crud gerentes
    public  Gerente getGerenteByid(int id) throws Exception{
        if (!Data.gerentes.containsKey(id)){
            throw new Exception("id " + id + " nao encontrado");
        }
        return Data.gerentes.get(id);
    }
    public void updateGerente(int id, Gerente g) throws Exception{
        if (!Data.gerentes.containsKey(id)) throw new Exception("id " + id + " nao encontrado");
        Data.gerentes.put(id, g);
        System.out.println("Gerente de id "+ id +" atualizado com sucesso");

    }
    public void deleteGerenteById(int id) throws Exception{
        if (!Data.gerentes.containsKey(id)) throw new Exception("id "+ id +" nao encontrado");
        Data.gerentes.remove(id);
        System.out.println("Gerente de id "+ id +" removido com sucesso");

    }
}
