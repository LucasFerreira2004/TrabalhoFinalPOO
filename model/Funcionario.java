package model;

public interface Funcionario {
    String nome = null, senha = null;
    double salario = 0, bonus = 0;

    public String getNome();
    public String getSenha();
    public double getSalario();
    public double getBonus();

}
