package model;

import java.math.BigDecimal;
import java.util.Date;

public class Funcionario {
    private int id;
    private String nome;
    private int cargo_Id;
    private BigDecimal salario;
    private Date data_nascimento;

    // Construtor, getters e setters

    public Funcionario(int id, String nome, int cargo_Id, BigDecimal salario, Date data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.cargo_Id = cargo_Id;
        this.salario = salario;
        this.data_nascimento = data_nascimento;
    }
    
    public Funcionario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargo_Id() {
        return cargo_Id;
    }

    public void setCargo_Id(int cargo_Id) {
        this.cargo_Id = cargo_Id;
    }

    public  BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    public Date getData_nascimento(){
     return data_nascimento;
    }
    
    public void setData_nascimento(Date data_nascimento){
        this.data_nascimento = data_nascimento;
    }
    
}