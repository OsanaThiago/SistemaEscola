package Individuos;

public class Docente extends Pessoa {
    public String turma;
    public String disciplina;
    

    public void cadastro() {
        super.cadastro();
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("Você leciona na turma do " + turma + " pela disciplina de " + disciplina);

    }
    public void editar() {
        super.editar();

    }
    public String adcArq(){
        String sim = super.adcArq() + turma + "," + disciplina + ",";
        return sim;
    }
}