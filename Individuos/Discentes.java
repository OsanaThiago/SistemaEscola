package Individuos;

import java.util.ArrayList;

import Escola.Notas;

public class Discentes extends Pessoa{

    public String turma;
    public ArrayList <String> disciplina = new ArrayList<>();
    public ArrayList <Notas> notas = new ArrayList<>();

    public void cadastro() {
        super.cadastro();        
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Sua turma é: " + turma);

        System.out.print("SUAS DISCIPLINAS SÃO: ");
        for (String show : disciplina) {
            System.out.print(show + "; ");
        }
        System.out.println(" ");
    }

    public String adcArq(){
        String sim = super.adcArq() + turma + ",";

        for (String some : disciplina) {
            sim = sim + some + ",";
        }
        return sim;
    }
    public void editar() {
        super.editar();
    }

}