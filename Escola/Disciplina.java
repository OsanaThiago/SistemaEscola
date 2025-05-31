package Escola;

import java.util.Scanner;

public class Disciplina extends Notas{
    Scanner sc = new Scanner(System.in);

    public String nomedisc, codigo;

    public void cadastroDcp(){        
            System.out.println("Qual o nome da disciplina?");
            nomedisc = sc.next();

            System.out.println("Qual o código da disciplina?");
            codigo = sc.next(); //verify       
    }

    public void showInfoD(){
        System.out.println(nomedisc + " é o nome da disciplina");
        System.out.println(codigo + " é o código da disciplina");
    }

    public String insereLinha(){
        String sim = nomedisc + "," + codigo + ",";
        return sim;
    }
}