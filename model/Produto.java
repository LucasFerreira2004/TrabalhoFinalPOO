package model;

import java.text.DecimalFormat;

public class Produto {
    private String label;
    private ProductType type;
    private int qtd;
    private double price;

    public Produto(String label, ProductType type, int qtd, double price) {
        this.label = label;
        this.type = type;
        this.qtd = qtd;
        this.price = price;
    }

    @Override
    public String toString(){
        //return "[ " + this.label+":"+this.type+":"+this.qtd+":"+this.price+" R$" + "] ";
        DecimalFormat f = new DecimalFormat("0.00");
        String s = "nome: " + this.label
                + "\ntipo: " + this.type.toString().toLowerCase()
                + "\nquantidade: " + this.qtd
                + "\npreco: " + f.format(this.price) + " R$";
        return s;
    }

    //getters e setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProductType getType() {
        return type;
    }
    public String getTypString(){
        return "";
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
