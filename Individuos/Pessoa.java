package Individuos;

import java.util.Scanner;

abstract class Pessoa {
    Scanner sc = new Scanner(System.in);
    
    public String nome = "", nascimento = "", cpf = "", estado = "";
    public int idade = 0;

    String adcArq(){
        String sim = nome + "," + nascimento + "," + idade + "," + cpf + "," + estado + ",";
        return sim;
    }
                                        
    void cadastro() {
        System.out.println("\nQual o seu primeiro nome?");
        this.nome = sc.next();

        System.out.println("\nQual sua data de nascimento?");
        this.nascimento = sc.next();

        System.out.println("\nQual sua idade?");
        this.idade = sc.nextInt();

        System.out.println("\nEstado onde você mora? (sigla)");
        this.estado = sc.next();
    }

    void showInfo(){
        System.out.println("Seu nome é: " + nome);
        System.out.println("Sua data de nascimento é: " + nascimento);
        System.out.println("Sua idade é: " + idade);
        System.out.println("Seu cpf é: " + cpf);
        System.out.println("Você mora no estado do(a) " + estado);
    }

    void editar(){
        System.out.println("----------------Redefina seus informações----------------\n");
        System.out.println("\nQual o seu primeiro nome?");
        this.nome = sc.next();

        System.out.println("\nQual sua data de nascimento?");
        this.nascimento = sc.next();

        System.out.println("\nQual sua idade?");
        this.idade = sc.nextInt();

        System.out.println("\nQual seu cpf?");
        this.cpf = sc.next();

        System.out.println("\nEstado onde você mora? (sigla)");
        this.estado = sc.next();    

    }

    //ideia: adicionar turma no cadastro da pessoa pra já pegar a turma
}