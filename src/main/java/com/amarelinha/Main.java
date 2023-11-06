package com.amarelinha;

import java.text.DecimalFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ListaProdutos lp = new ListaProdutos();
        LeitorCSV lc = new LeitorCSV();
        CadastroTransporte ct = new CadastroTransporte();
        boolean controladorDados = false;

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

                    boolean igual = cidade1.equals(cidade2);

                    if (igual){
                        System.out.println("\n\n\nVocê informou a mesma cidade!!!\n\n\n");
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
                    Scanner s2 = new Scanner(System.in);
                    lc.listarCidades();
                    String cidadePartida;
                    String cidadeDestino;
                    do {
                        System.out.println("Qual sua cidade de partida?");
                        cidadePartida = s2.nextLine().toUpperCase();
                        System.out.println("Qual sua cidade de destino?");
                        cidadeDestino = s2.nextLine().toUpperCase();

                        if (!lc.indice.contains(cidadePartida) || !lc.indice.contains(cidadeDestino) || cidadePartida.equals(cidadeDestino)){
                            System.out.println("Uma das cidades informadas não está na lista de cidades ou as duas cidades são iguais. Tente novamente.");
                        }

                    }while (!lc.indice.contains(cidadePartida) || !lc.indice.contains(cidadeDestino) || cidadePartida.equals(cidadeDestino));
                    double distanciaASerPercorrida = lc.pegaDistancia(cidadePartida, cidadeDestino);


                    //chamar lista de produtos

                    lp.listarProdutos();
                    lp.selecionarProdutos();

                    double soma = 0.0;

                    for (Double valor : lp.produtosSelecionados.values()) {
                        soma += valor;
                    }

                    double valorTransporte = 0;
                    double valorOpcional = 0;
                    int caminhaoPequeno = 0;
                    int caminhaoMedio = 0;
                    int caminhaoGrande = 0;
                    int contador = 0;


                    if (soma > 10000) {
                        Caminhao caminhoes = new Caminhao(3);
                        while (soma > 10000) {

                            soma -= 10000;
                            contador += 1;
                        }
                        valorOpcional += caminhoes.Calculo(distanciaASerPercorrida, contador);
                    }
                    if (soma <= 2301.88) {
                        if (soma > 1000) {
                            Caminhao caminhoes1 = new Caminhao(1);
                            valorTransporte += caminhoes1.Calculo(distanciaASerPercorrida, 2);
                            caminhaoPequeno += 2;
                        } else {
                            Caminhao caminhoes2 = new Caminhao(1);
                            valorTransporte += caminhoes2.Calculo(distanciaASerPercorrida, 1);
                            caminhaoPequeno += 1;
                        }
                    }
                    if (soma > 2301.88 && soma <= 8706.40) {
                        if (soma <= 4000) {
                            Caminhao caminhoes3 = new Caminhao(2);
                            valorTransporte += caminhoes3.Calculo(distanciaASerPercorrida, 1);
                            caminhaoMedio += 1;
                        } else if (soma < 8706.40 && soma > 4000) {
                            Caminhao caminhoes4 = new Caminhao(2);
                            Caminhao caminhoes42 = new Caminhao(1);
                            valorTransporte += caminhoes4.Calculo(distanciaASerPercorrida, 1) + caminhoes42.Calculo(distanciaASerPercorrida, 1);
                            caminhaoPequeno += 1;
                            caminhaoMedio += 1;
                        }
                    }
                    if (soma > 8706.40) {
                        Caminhao caminhoes5 = new Caminhao(3);
                        valorTransporte += caminhoes5.Calculo(distanciaASerPercorrida, 1);
                        caminhaoGrande += 1;
                    }

                    Double valorTotal = valorTransporte + valorOpcional;

                    System.out.println("A distancia da viagem eh de " + distanciaASerPercorrida + " KM.");
                    System.out.println("O custo da viagem de " + cidadePartida + " ate a cidade de " + cidadeDestino + " eh de: R$" + valorTotal);

                    System.out.println("Foram utilizados: " + caminhaoPequeno + " caminhões pequenos, " + caminhaoMedio + " caminhões medios" + " e " + (caminhaoGrande + contador) + " caminhões grandes!");

                    ct.setCaminhoesPequenos(caminhaoPequeno); ;
                    ct.setCaminhoesMedios(caminhaoMedio);
                    ct.setCaminhoesGrandes(caminhaoGrande + contador);

                    ct.setCustoPorCaminhoesPequenos(ct.calculaCustoPorCaminhaoPequeno(distanciaASerPercorrida));
                    ct.setCustoPorCaminhoesMedios(ct.calculaCustoPorCaminhaoMedio(distanciaASerPercorrida));
                    ct.setCustoPorCaminhoesGrandes(ct.calculaCustoPorCaminhaoGrande(distanciaASerPercorrida));

                    ct.numeroDeTrechos++;
                    ct.precosAdicionados.add(Double.valueOf(valorTotal));
                    ct.distanciaTrechos.add(distanciaASerPercorrida);
                    ct.precosTotais.add(Double.valueOf(valorTotal));
                    controladorDados = true;

                    System.out.println("Aperte Enter para continuar");
                    s.nextLine();
                    break;
                case 3:
                    DecimalFormat df = new DecimalFormat("##,##");
                    if(controladorDados) {
                        System.out.println("________________________________________________________________");
                        ct.exibeEstatisticas();
                        ct.calculaCustoMedioPorProduto(lp.produtosSelecionados, lp.quantidade, ct.precosAdicionados);
                        ct.contaTotalDeItensTransportados(lp.quantidade);
                        System.out.println("Custo total em caminhões pequenos: R$" + ct.getCustoPorCaminhoesPequenos());
                        System.out.println("Custo total em caminhões médios: R$" + ct.getCustoPorCaminhoesMedios());
                        System.out.println("Custo total em caminhões grandes: R$" + ct.getCustoPorCaminhoesGrandes());
                        System.out.println("_______________________________________________________________");
                    } else {
                        System.out.println("Ainda não há dados estatisticos registrados.");
                    }
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