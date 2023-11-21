package model;

import control.ControlEstoquista;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Estoquista extends ControlEstoquista implements Funcionario {
    protected String nome;
    protected double salario;
    protected String senha;
    protected double bonus;
    //public static Control.Data data;

    public Estoquista(String nome, double salario, String senha) {
        this.nome = nome;
        this.salario = salario;
        this.senha = senha;
        //data = new Control.Data();
    }
    @Override
    public String toString(){
        DecimalFormat f = new DecimalFormat("0.00");
        String s = "nome: " + this.nome
                + "\nsenha: " + this.senha
                + "\nsalario: " + f.format(this.salario)
                + "\nbonus: " + f.format(this.bonus);

        return s;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
