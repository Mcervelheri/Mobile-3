package com.example.myapplication;

public class Tarefa {

    // Declaração dos atributos da classe
    private int id;
    private String Titulo;
    private String email;

    // Construtor vazio da classe
    public Tarefa(){

    }

    // Construtor com parâmetros da classe
    public Tarefa(int id, String Titulo, String email, String telefone){
        this.id = id;
        this.Titulo = Titulo;
        this.email = email;
    }

    // Métodos getters e setters da classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
