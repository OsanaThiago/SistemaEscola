package Escola;

import java.util.Scanner;

public class Notas {
    Scanner sc = new Scanner(System.in);
    public double nota = 0;
    public String nomeNota = "";
    public String nomaTurma = "";

    public void infoNota(){
        for(int i = 0; i < 4; i++){
            System.out.println("Informando a nota da " + (i+1) +"° unidade");
            nota += sc.nextDouble();

            if(i == 3){
                nota = nota/4;
                System.out.println("MÉDIA FINAL: " + nota);
            }
        }
    }

    
}