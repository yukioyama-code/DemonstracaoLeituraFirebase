package ads.pdm.demonstracaoleiturafirebase;

import java.util.Locale;

public class Usuario {

    //Atributos da classe

    private String nome;
    private String sobrenome;
    private int idade;


    public Usuario (String n, String s, int i){
        nome = n;
        sobrenome = s;
        idade = i;

    }

    public Usuario(){

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome(String s){
        this.sobrenome = sobrenome;

    }

    public int getIdade(){
        return idade;

    }

    public void setIdade(int idade){
        this.idade = idade;
    }

}
