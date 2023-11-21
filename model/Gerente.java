package model;

import java.text.DecimalFormat;

public class Gerente extends control.ControlGerente implements Funcionario {
    private String nome, senha;
    private double salario, adicionalSalario, bonus;

    public Gerente(String nome, double salario, String senha, double adicionalSalario) {
        this.nome = nome;
        this.salario = salario;
        this.senha = senha;
        this.adicionalSalario = adicionalSalario;
    }

    @Override
    public String toString(){
        DecimalFormat f = new DecimalFormat("0.00");
        String s = "nome: " + this.nome
                + "\nsenha: " + this.senha
                + "\nsalario: " + f.format(this.salario)
                + "\nadcional salario: " + f.format(this.adicionalSalario)
                + "\nbonus: " + f.format(this.bonus);

        return s;
    }

    //getters
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    @Override
    public double getSalario() {
        return this.salario;
    }

    @Override
    public double getBonus() {
        return this.bonus;
    }
}
