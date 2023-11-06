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
                    lc.listarCidades();

                    s.nextLine();
                    System.out.println("Escolha as cidades:");
                    System.out.println("");

                    System.out.println("Digte a cidade de partida:");
                    String cidade1 = s.nextLine().toUpperCase();

                    System.out.println("Digte a cidade de partida:");
                    String cidade2 = s.nextLine().toUpperCase();

                    System.out.println(cidade2 + cidade1);
                    if (cidade1 == cidade2) {
                        System.out.println("Você informou a mesma cidade!!!");
                        break;
                    }else {
                        if (lc.verificaCidade(cidade1) && lc.verificaCidade(cidade2)) {
                            System.out.println("As cidades selecionadas foram:");
                            System.out.println("Partida:" + cidade1);
                            System.out.println("Destino:" + cidade2);
                            System.out.println("");
                            System.out.println(" Escolha o tipo de caminhão para ser utilizado na rota acima!");
                            System.out.println("1 - Pequeno");
                            System.out.println("2 - Médio");
                            System.out.println("3 - Grande");
                            Caminhao caminhao = new Caminhao(s.nextInt());

                            double distancia = lc.pegaDistancia(cidade1, cidade2);
                            double valor = caminhao.Calculo(distancia, 1);

                            System.out.println("Informações do trajeto:");
                            System.out.println("Origem:" + cidade1);
                            System.out.println("Destino:" + cidade2);
                            System.out.println("Distância:" + distancia + "KM");
                            System.out.println("Custo:" + valor);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Aperte Enter para continuar");
                            s.nextLine();
                            s.nextLine();

                        } else {
                            System.out.println("Erro, tente novamente");
                            System.out.println("Aperte Enter para continuar");
                            s.nextLine();
                            s.nextLine();

                            break;
                        }
                    }
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