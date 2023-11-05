package com.amarelinha;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ListaProdutos lp = new ListaProdutos();
        LeitorCSV lc = new LeitorCSV();
        CadastroTransporte ct = new CadastroTransporte();

        while (true){
            System.out.println("______________________________________");
            System.out.println("");
            System.out.println("       AMARELINHA TRANSPORTES"         );
            System.out.println("______________________________________");
            System.out.println("Escolha uma das opções do menu:");
            System.out.println("1. CONSULTAR TRECHOS E MODALIDADES");
            System.out.println("2. CADASTRAR TRANPORTE");
            System.out.println("3. DADOS ESTATISTICOS");
            System.out.println("4. FINALIZAR PROGRAMA");
            System.out.println("______________________________________");

            int opcao = s.nextInt();

            switch (opcao){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("O programa foi finalizado. Obrigado por usar a Amarelinha Transportes!");
                    System.exit(0);
                    s.close();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");

            }
        }

    }
}