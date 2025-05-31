import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import Escola.Disciplina;
import Escola.Notas;
import Escola.Turma;
import Individuos.Discentes;
import Individuos.Docente;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        // ArrayLists
        ArrayList <Discentes> alunos = new ArrayList<>();
        ArrayList <Docente> profs = new ArrayList<>();
        ArrayList <Turma> turma = new ArrayList<>();
        ArrayList <Disciplina> mdisciplinas = new ArrayList<>();
        ArrayList <Notas> gNotas = new ArrayList<>();


        // Inicialização de Objetos
        Disciplina d = new Disciplina();
        Turma t = new Turma();
        Discentes dis = new Discentes();
        Notas n = new Notas();
        Docente doc = new Docente();

        // Booleans de while's
        boolean sairgeral = false;
        boolean sairdiscente = false;
        boolean sairdocente = false;
        boolean sairTD = false;

        // Variaveis do MENU
        String resposta;

        System.out.println("\nBEM-VINDO A ESCOLA OESAA!");

        //LENDO DISCIPLINAS
        FileWriter arqd = new FileWriter("disciplina.txt", true);
        FileReader lerd = new FileReader("disciplina.txt");
        BufferedReader linhad = new BufferedReader(lerd);
        PrintWriter printd = new PrintWriter(arqd);
        resposta = linhad.readLine();
        
        while (resposta != null) {
            d = new Disciplina();

            String[] vetor = resposta.split(",");
            d.nomedisc = vetor[0];
            d.codigo = vetor[1];
            t.listdisc.add(d);
            mdisciplinas.add(d);

            resposta = linhad.readLine();
        }

        // LENDO TURMAS

        FileWriter arqt = new FileWriter("turma.txt", true);
        FileReader lert = new FileReader("turma.txt");
        BufferedReader linhat = new BufferedReader(lert);
        PrintWriter printt = new PrintWriter(arqt);
        resposta = linhat.readLine();
 
        while (resposta != null) {
            t = new Turma();
            String[] vetor = resposta.split(",");
            t.nome = vetor[0];
            t.codigo = vetor[1];
            for(int i = 2; i < vetor.length; i++){
                for(Disciplina jjjj : mdisciplinas){
                    if(d.codigo.equals(vetor[i])){ 
                        t.listdisc.add(jjjj);
                    }
                }
            }
            turma.add(t);
            resposta = linhat.readLine();
        }

        // LENDO DISCENTES
        FileWriter arqdis = new FileWriter("discente.txt", true);
        FileReader lerdis = new FileReader("discente.txt");
        BufferedReader linhadis = new BufferedReader(lerdis);
        PrintWriter printdis = new PrintWriter(arqdis);
        resposta = linhadis.readLine();
        
        while (resposta != null) {
            dis = new Discentes();
            String[] vetor = resposta.split(",");
            dis.nome = vetor[0];
            dis.nascimento = vetor[1];
            dis.idade = Integer.parseInt(vetor[2]);
            dis.cpf = vetor[3];
            dis.estado = vetor[4];
            dis.turma = vetor[5];

            for(int i = 2; i < vetor.length; i++){
                for(String seisptsHeliopfvr : dis.disciplina){
                    if(d.codigo.equals(vetor[i])){
                        dis.disciplina.add(seisptsHeliopfvr);
                    }
                }
            }

            alunos.add(dis);
            resposta = linhadis.readLine();
        }

        //LENDO DOCENTES

        FileWriter arqdoc = new FileWriter("docentes.txt", true);
        FileReader lerdoc = new FileReader("docentes.txt");
        BufferedReader linhadoc = new BufferedReader(lerdoc);
        PrintWriter printdoc = new PrintWriter(arqdoc);
        resposta = linhadoc.readLine();
        
        while (resposta != null) {
            doc = new Docente();
            String[] vetor = resposta.split(",");
            doc.nome = vetor[0];
            doc.nascimento = vetor[1];
            doc.idade = Integer.parseInt(vetor[2]);
            doc.cpf = vetor[3];
            doc.estado = vetor[4];
            doc.turma = vetor[5];
            doc.disciplina = vetor[6];

            profs.add(doc);
            resposta = linhadoc.readLine();
        }

        while (sairgeral != true) {
            try {
                System.out.println("\n------------MENU PRINCIPAL------------");
                System.out.println("\nDigite a sua opção:\n");
                System.out.println("1 = Opções para turma e disciplina");
                System.out.println("2 = Opções para discente");
                System.out.println("3 = Opções para docente");
                System.out.println("4 = Informar notas");
                System.out.println("5 = Relatório");
                System.out.println("0 = Sair do sistema\n");
                System.out.print("RESPOSTA: ");
                int opcoes = sc.nextInt();

                switch (opcoes) {
                    case 0:
                        lerdis.close(); arqdis.close();
                        lert.close(); printt.close();
                        linhad.close(); printd.close();
                        arqdoc.close(); lerdoc.close();

                        System.out.println("sim");
                        sairgeral = true;
                        break;

                    case 1:
                        sairTD = false;

                        while (sairTD != true) {
                            System.out.println("\n---------OPÇÕES DE TURMA E DISCIPLINA---------\n");
                            System.out.println("1 = Cadastrar turma");
                            System.out.println("2 = Ver informações da turma");
                            System.out.println("3 = Cadastrar disciplina");
                            System.out.println("4 = Ver todas as disciplinas");
                            System.out.println("5 = Excluir turma");
                            System.out.println("6 = Excluir disciplinas");
                            System.out.println("0 = Voltar para o menu inicial\n");
                            System.out.print("RESPOSTA: ");
                            int op1 = sc.nextInt();

                            switch (op1) {
                                case 1:
                                    System.out.println("\n---------------CADASTRANDO TURMA---------------");
                                    t = new Turma();
                                    t.cadastroTurma();

                                    boolean sim = false;

                                    for(int w = 0; w < turma.size(); w++){
                                        if(t.nome.equals(turma.get(w).nome)){
                                            System.out.println("NÃO PODE HAVER MAIS DE UMA TURMA COM O MESMO NOME");
                                            sim = true;
                                        }
                                    }

                                    if(sim == true){
                                        break;
                                    }

                                    System.out.println("Quantas disciplinas terá nesta turma?");
                                    int respostaI = sc.nextInt();

                                    for (int y = 0; y < respostaI; y++) {
                                        System.out.println("\n---------CADASTRE A " + (y + 1) + "° DISCIPLINA---------\n");
                                        d = new Disciplina();
                                        d.cadastroDcp();

                                        sim = false;

                                        for(int w = 0; w < mdisciplinas.size(); w++){
                                            if(d.nomedisc.equals(mdisciplinas.get(w).nomedisc)){
                                                System.out.println("NÃO PODE HAVER MAIS DE UMA TURMA COM O MESMO NOME");
                                                sim = true;
                                            }
                                        }
    
                                        if(sim == true){
                                            break;
                                        }

                                        t.listdisc.add(d);
                                        mdisciplinas.add(d);
                                        printd.println(d.insereLinha());
                                    }
                                    turma.add(t);
                                    printt.println(t.insereLinha());
                                    break;

                                case 2:
                                    System.out.println("\nQUAL O CÓDIGO DA TURMA QUE VOCÊ QUER VER AS INFORMAÇÕES?");
                                    resposta = sc.next();
                                    System.out.println(resposta);
                                    for (int i = 0; i < turma.size(); i++) {
                                        if (resposta.equals(turma.get(i).codigo)) {
                                            turma.get(i).showInfoT();
                                        }
                                    }
                                    break;

                                   case 3:
                                   System.out.println("\n-----------------CADASTRANDO DISCIPLINAS-----------------\n");
                                   
                                   d = new Disciplina();
                                   d.cadastroDcp();

                                   sim = false;

                                   for(int w = 0; w < mdisciplinas.size(); w++){
                                       if(d.nomedisc.equals(mdisciplinas.get(w).nomedisc)){
                                           System.out.println("NÃO PODE HAVER MAIS DE UMA DISCIPLINA COM O MESMO NOME");
                                           sim = true;
                                        }
                                    }

                                    if(sim == true){
                                        break;
                                    }
                                        
                                    System.out.println("ESSA DISCIPLINA PERCENTERÁ A QUAL TURMA?\n");
                                    System.out.println("OPÇÕES: ");
                                            
                                    for(int i = 0; i < turma.size(); i++){
                                        System.out.println(turma.get(i).nome);
                                    }
                                    System.out.print("\nRESPOSTA:");
                                    resposta = sc2.nextLine(); 

                                    for(int b = 0; b < turma.size(); b++){
                                        if(resposta.equals(turma.get(b).nome)){
                                            System.out.println("\nADICIONADO A TURMA DO " + turma.get(b).nome.toUpperCase() + " COM SUCESSO!");
                                            turma.get(b).listdisc.add(d); 
                                        }                                        
                                    }
                                    mdisciplinas.add(d);
                                    printd.println(d.insereLinha());

                                    break;

                                case 4:

                                System.out.println("\n----------------MOSTRANDO TODAS AS DISCIPLINAS----------------\n");

                                for(int i = 0; i < mdisciplinas.size(); i++){
                                    System.out.println(mdisciplinas.get(i).nomedisc);
                                }
                                System.out.println(" ");

                                break;

                                case 5: 

                                System.out.println("\n----------------EXCLUINDO TURMA----------------\n");

                                System.out.println("QUAL O NOME DA TURMA QUE SERÁ EXCLUIDA?");
                                resposta = sc2.nextLine();

                                for(int i = 0; i < turma.size(); i++){
                                    if(turma.get(i).nome.equals(resposta)){
                                        turma.remove(i);
                                    }
                                }
                                break;

                                case 6: 

                                System.out.println("\n----------------EXCLUINDO DISCIPLINAS----------------\n");

                                System.out.println("QUAL O NOME DA DISCIPLINA QUE SERÁ EXCLUIDA?");
                                resposta = sc2.nextLine();

                                for(int i = 0; i < mdisciplinas.size(); i++){
                                    if(mdisciplinas.get(i).nomedisc.equals(resposta)){
                                        mdisciplinas.remove(i);
                                    }
                                }
                                break;

                                case 0:
                                    sairTD = true;
                                    break;

                                default:
                                    System.out.println("\nNÃO HÁ OPÇÃO COM O NÚMERO " + op1 + ". TENTE OUTRO!");
                            }
                        }
                        break;

                    case 2:
                        sairdiscente = false;

                        while (sairdiscente != true) { 
                            System.out.println("\n---------OPÇÕES DO DISCENTE---------\n");
                            System.out.println("1 = Cadastrar discente");
                            System.out.println("2 = Editar discente");
                            System.out.println("3 = Excluir discente");
                            System.out.println("4 = Lista de todos os discentes ");
                            System.out.println("5 = Ver informações de discente");
                            System.out.println("0 = Voltar ao menu inicial\n");
                            System.out.print("RESPOSTA: ");
                            int disopc = sc.nextInt();

                            switch (disopc) {
                                case 1:
                                    if (turma.size() < 1) {
                                        System.out.println("\nCRIE UMA TURMA ANTES DE CADASTRAR UM ALUNO");
                                    } else {
                                        dis = new Discentes();
                                        System.out.println("\nDIGITE SEU CPF");
                                        dis.cpf = sc.next();
                                        boolean brecar = false;
                                        for(int g = 0; g < alunos.size(); g++){
                                            if(dis.cpf.equals(alunos.get(g).cpf)){
                                                System.out.println("NÃO PODE HAVER MAIS DE UM ALUNO COM O MESMO CPF");
                                                brecar = true;
                                                break;
                                            }
                                        }

                                        if(brecar){
                                            break;
                                        }
                                        dis.cadastro();
                                            
                                        System.out.println("\nQUAL O CÓDIGO DA SUA TURMA?");
                                        resposta = sc.next();

                                        for (int i = 0; i < turma.size(); i++) {
                                            if (resposta.equals(turma.get(i).codigo)) {
                                                dis.turma = turma.get(i).nome;
                                            }
                                        }

                                        System.out.println("\nQUANTAS DISCIPLINAS O DISCENTE TERÁ?");
                                        int respostaI = sc.nextInt();
                                        System.out.println();
                                        int i = 0;

                                        System.out.println("DISCIPLINAS: "); 
                                        for (int k = 0; k < respostaI; k++) {
                                            for(i = 0; i < mdisciplinas.size(); i++) {
                                                System.out.println(mdisciplinas.get(i).nomedisc);                                                
                                            }
                                            System.out.println("\nESCREVA A " + (k+1) + "° DISCIPLINA QUE VOCÊ DESEJA");
                                            resposta = sc.next();
                                            System.out.println(" ");

                                            for (i = 0; i < t.listdisc.size(); i++) {
                                                if (resposta.equals(t.listdisc.get(i).nomedisc)) {
                                                    dis.disciplina.add(resposta);
                                                }
                                            }
                                        }
                                        alunos.add(dis);
                                        printdis.println(dis.adcArq());
                                        System.out.println("CADASTRO CONCLUÍDO COM SUCESSO!\n");
                                    }
                                    break;

                                case 2:
                                    System.out.println("\nQual o cpf do aluno que terá suas informações editadas?");
                                    resposta = sc.next();
                                    
                                    boolean brecar = false;
                                        for(int g = 0; g < alunos.size(); g++){
                                            if(resposta.equals(alunos.get(g).cpf)){
                                                System.out.println("NÃO HÁ ALUNO COM ESSE CPF");
                                                brecar = true;
                                            }
                                        }
                                        if(brecar){
                                            break;
                                        }

                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (resposta.equals(alunos.get(i).cpf)) {
                                            alunos.get(i).editar();
                                            System.out.println("Qual o código da sua turma?");
                                            resposta = sc.next();

                                            for (i = 0; i < turma.size(); i++) {
                                                if (resposta.equals(turma.get(i).codigo)) {
                                                    dis.turma = turma.get(i).nome;
                                                }
                                            }
                                        }
                                    }
                                    printdis.println(dis.adcArq());
                                    break;

                                case 3:
                                    System.out.println("\nQual o cpf do aluno que será removido?");
                                    resposta = sc.next();

                                    brecar = false;
                                        for(int g = 0; g < alunos.size(); g++){
                                            if(resposta.equals(alunos.get(g).cpf)){
                                                System.out.println("NÃO HÁ ALUNO COM ESSE CPF");
                                                brecar = true;
                                            }
                                        }
                                        if(brecar){
                                            break;
                                        }

                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (resposta.equals(alunos.get(i).cpf)) {
                                            alunos.remove(i);
                                            System.out.println("Aluno removido!");
                                        } 
                                    }
                                    
                                    break;

                                case 4:
                                    System.out.println("\n---------MOSTRANDO TODOS OS DISCENTES---------\n");

                                    for (int i = 0; i < alunos.size(); i++) {
                                        System.out.println((i + 1) + "° Discente: " + alunos.get(i).nome + " - " + alunos.get(i).cpf);
                                    }

                                    break;

                                case 5:
                                    System.out.println("QUAL O CPF DO DISCENTE QUE VOCÊ QUER VER AS INFORMAÇÕES?");
                                    resposta = sc.next();

                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (resposta.equals(alunos.get(i).cpf)) {
                                            System.out.println(" ");
                                            alunos.get(i).showInfo();
                                        }
                                    }
                                    break;

                                case 0:
                                    
                                    sairdiscente = true;
                                    break;

                                default:
                                    System.out.println("\nNÃO HÁ OPÇÃO COM O NÚMERO " + disopc + " TENTE OUTRO!");
                            }
                        }
                        break;

                    case 3:
                        sairdocente = false;
                        while (sairdocente != true) {

                            System.out.println("\n---------OPÇÕES DO DOCENTE---------\n");
                            System.out.println("1 = Cadastrar docente");
                            System.out.println("2 = Editar docente");
                            System.out.println("3 = Excluir docente");
                            System.out.println("4 = Lista de todos os docentes (nomes)");
                            System.out.println("5 = Ver informações de um docente");
                            System.out.println("0 = Voltar ao menu inicial\n");
                            System.out.print("RESPOSTA: ");
                            int dopc = sc.nextInt();

                            switch (dopc) {
                                case 0:
                                    sairdocente = true;
                                    break;

                                case 1:
                                    if (turma.size() < 1) {
                                        System.out.println("CADASTRE UMA TURMA ANTES DE CADASTRAR UM DOCENTE");
                                    } else {
                                        doc = new Docente();
                                        System.out.println("\nQual o seu cpf?");
                                        doc.cpf = sc.next();

                                        boolean sim = false;

                                        for(int g = 0; g < profs.size(); g++){
                                            if(doc.cpf.equals(profs.get(g).cpf)){
                                                System.out.println("NÃO PODE TER MAIS DE DOCENTE COM O MESMO CPF");
                                                sim = true;
                                            }
                                        }

                                        if(sim == true){
                                            break;
                                        }

                                        doc.cadastro();
                                        System.out.println("\nQUAL O CÓDIGO DA SUA TURMA?");
                                        resposta = sc.next();

                                        sim = false;
                                        for (int i = 0; i < turma.size(); i++) {
                                            if (resposta.equals(turma.get(i).codigo)) {
                                                doc.turma = turma.get(i).nome;
                                                sim = true;
                                            } 
                                        }

                                        if(sim == false){
                                            System.out.println("NÃO TURMA COM ESSE CÓDIGO"); break;
                                        }

                                        System.out.println("\nQUAL DISCIPLINA VOCÊ LECIONARÁ?\n");
                                        System.out.println("OPÇÕES:\n");
                                        for (int i = 0; i < mdisciplinas.size(); i++) {
                                            System.out.println(mdisciplinas.get(i).nomedisc);
                                        }
                                        System.out.print("RESPOSTA: ");
                                        resposta = sc.next();

                                        for (int i = 0; i < t.listdisc.size(); i++) {
                                            if (resposta.equals(t.listdisc.get(i).nomedisc)) {
                                                doc.disciplina = t.listdisc.get(i).nomedisc;
                                                break;
                                            } 
                                        }
                                        profs.add(doc);
                                        printdoc.println(doc.adcArq());
                                    }
                                    break;

                                case 2:
                                    System.out.println("\nQual o cpf do professor(a) que terá suas informações editadas?");
                                    resposta = sc.next();

                                    boolean brecar = false;
                                        for(int g = 0; g < profs.size(); g++){
                                            if(resposta.equals(profs.get(g).cpf)){
                                                System.out.println("NÃO HÁ ALUNO COM ESSE CPF");
                                                brecar = true;
                                            }
                                        }
                                        if(brecar){
                                            break;
                                        }

                                    for (int i = 0; i < profs.size(); i++) {
                                        if (resposta.equals(profs.get(i).cpf)) {
                                            profs.get(i).editar();
                                            System.out.println("\nQUAL O CÓDIGO DA SUA TURMA?");
                                        resposta = sc.next();

                                        boolean sim = false;
                                        for (int y = 0; y < turma.size(); y++) {
                                            if (resposta.equals(turma.get(y).codigo)) {
                                                doc.turma = turma.get(y).nome;
                                                sim = true;
                                            } 
                                        }

                                        if(sim == false){
                                            System.out.println("NÃO TURMA COM ESSE CÓDIGO"); break;
                                        }

                                        System.out.println("\nQUAL DISCIPLINA VOCÊ LECIONARÁ?\n");
                                        System.out.println("OPÇÕES:\n");
                                        for (int l = 0; l < mdisciplinas.size(); l++) {
                                            System.out.println(mdisciplinas.get(l).nomedisc);
                                        }
                                        System.out.print("RESPOSTA: ");
                                        resposta = sc.next();

                                        for (int k = 0; k < t.listdisc.size(); k++) {
                                            if (resposta.equals(t.listdisc.get(k).nomedisc)) {
                                                doc.disciplina = t.listdisc.get(k).nomedisc;
                                                break;
                                            } 
                                        }
                                        printdoc.println(doc.adcArq());
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.println("Qual o cpf do professor(a) que será removido?");
                                    resposta = sc.next();

                                    for (int i = 0; i < profs.size(); i++) {
                                        if (resposta.equals(profs.get(i).cpf)) {
                                            profs.remove(i);
                                            break;
                                        }
                                    }
                                    break;

                                case 4:
                                    System.out.println("\n---------MOSTRANDO TODOS OS DOCENTES---------\n");
                                    for (int i = 0; i < profs.size(); i++) {
                                        System.out.println(
                                                (i + 1) + "° DOCENTE: " + profs.get(i).nome + " - " + profs.get(i).cpf);
                                    }
                                    break;

                                case 5:
                                    System.out.println("QUAL O CPF DO DOCENTE QUE VOCÊ QUER VER AS INFORMAÇÕES?");
                                    resposta = sc.next();

                                    for (int i = 0; i < profs.size(); i++) {
                                        if (resposta.equals(profs.get(i).cpf)) {
                                            profs.get(i).showInfo();
                                        } else if (i == profs.size() - 1) {
                                            System.out.println("NÃO HÁ DOCENTE COM ESSE CPF");
                                        }
                                    }
                                    break;

                                default:
                                    System.out.println("\nNÃO HÁ OPÇÃO COM O NÚMERO " + dopc + " TENTE OUTRO!");
                                }
                            } 
                            break;

                        case 4:
 

                        System.out.println("\n-----------FORNECIMENTO DE NOTAS-----------\n");


                        for (int i = 0; i < mdisciplinas.size(); i++) {
                            System.out.println(mdisciplinas.get(i).nomedisc);
                        }

                        System.out.println("\nDIGITE O NOME DE UMA DAS OPÇÕES DE DISCIPLINA ACIMA");
                        resposta = sc.next();

                        for(int da = 0; da < 1; da++){
                        System.out.println("DIGITE O NOME DA TURMA");
                        String respx = sc2.nextLine();

                        for (int j = 0; j < mdisciplinas.size(); j++) { 
                            if (resposta.equals(mdisciplinas.get(j).nomedisc)) { 
                                for (int k = 0; k < alunos.size(); k++) { 
                                    for (int o = 0; o < alunos.get(k).disciplina.size(); o++) { 
                                        if (resposta.equals(alunos.get(k).disciplina.get(o))) { 
                                            if(alunos.get(k).turma.equals(respx)){
                                            n = new Notas();
                                            n.nomeNota = resposta;
                                            n.nomaTurma = respx;
                                            System.out.println("\n--------Notas para " + (alunos.get(k).nome) +" do " + (alunos.get(k).turma) + "--------\n");
                                            n.infoNota();
                                            alunos.get(k).notas.add(n);
                                            gNotas.add(n);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                    break;

                    case 5:
                    int qtd = 0;
                    double soma = 0;
                    System.out.println("\n------------------MÉDIA POR TURMA------------------\n");

                    for(int q = 0; q < turma.size(); q++){
                        qtd = 0;
                        soma = 0;
                        for(int y = 0; y < gNotas.size(); y++){
                            if(turma.get(q).nome.equals(gNotas.get(y).nomaTurma)){
                                qtd +=1;
                                soma += gNotas.get(y).nota;
                            }
                        }
                        System.out.println("MÉDIA DA TURMA DO " + turma.get(q).nome + " = " + soma/qtd);
                    }

                    System.out.println("\n------------SITUAÇÃO------------\n");

                    for (int i = 0; i < turma.size(); i++) {
                        for (int j = 0; j < alunos.size(); j++) {
                            for (int k = 0; k < alunos.get(j).notas.size(); k++) {
                                if(alunos.get(j).notas.get(k).nota >= 7){
                                    System.out.println("O(A) ALUNO(A) " + alunos.get(j).nome.toUpperCase() + " DA TURMA DO " + alunos.get(j).turma.toUpperCase() + " FOI APROVADO(A) PELA DISCIPLINA DE " + alunos.get(j).notas.get(k).nomeNota.toUpperCase());
                                }
                                else{
                                    System.out.println("O(A) ALUNO(A) " + alunos.get(j).nome.toUpperCase() + " DA TURMA DO " + alunos.get(j).turma.toUpperCase() + " FOI REPROVADO(A) PELA DISCIPLINA DE " + alunos.get(j).notas.get(k).nomeNota.toUpperCase());
                                }
                            }
                        }
                    }

                    System.out.println("\n-------------------MÉDIA POR DISCIPLINA-------------------\n");
                        
                    for(int i = 0; i < mdisciplinas.size(); i++){
                        qtd = 0;
                        soma = 0;
                        
                        for(int j = 0; j < gNotas.size(); j++){
                            if(mdisciplinas.get(i).nomedisc.equals(gNotas.get(j).nomeNota)){
                                qtd += 1;
                                soma += gNotas.get(j).nota;
                            }
                        }
                        System.out.println("MÉDIA NA DISCIPLINA DE " + mdisciplinas.get(i).nomedisc.toUpperCase() + " = " + soma/qtd);
                    }

                    System.out.println("\n----------------DOCENTES----------------\n");

                    for(int i = 0; i < profs.size(); i++){
                        System.out.println("O DOCENTE " + profs.get(i).nome.toUpperCase() + " LECIONA PELA DISCIPLINA DE " + profs.get(i).disciplina.toUpperCase());
                    }

                    break;

                    default: System.out.println("\nNÃO HÁ OPÇÃO COM O NÚMERO " + opcoes + " TENTE OUTRO");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nRESPOSTA INVÁLIDA. TENTE DIGITAR UM OUTRO NÚMERO");
                sc.nextLine();
            }
        }

        sc.close();   
        sc2.close();
    
    }
}