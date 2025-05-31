package Escola;
import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    Scanner sc = new Scanner(System.in);
    public ArrayList <Disciplina> listdisc = new ArrayList<>();

    public String nome;
    public String codigo;

    public void cadastroTurma() {
        System.out.println("\nQual o nome da turma?");
        nome = sc.nextLine();

        System.out.println("Qual o código dessa turma?");
        codigo = sc.next();
    }

    public void showInfoT(){
        System.out.println("\nNome da turma: " + nome);
        System.out.println("Código da turma: " + codigo);
        System.out.print("Disciplinas na turma: "); // n funfa na 2° exec
        for (Disciplina ok : listdisc) {
            System.out.print(ok.nomedisc + ", " );
        }
        System.out.println("");
    }

    public String insereLinha(){
        String linha = nome + "," + codigo+",";
        for (Disciplina ok : listdisc) {
            linha = linha + ok.nomedisc + "," + ok.codigo+","; //try it!
        }
        return linha;
    }
   
    //info da turma; quantidade de alunos, codigo e nome prof
}   // FOR AL de aluno e mostrar os alunos q tiverem o mesmo .nomedisc