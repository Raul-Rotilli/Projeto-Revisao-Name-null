package com.amarelinha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LeitorCSV {
    private int[][] matrizDistancias;
    public ArrayList<String> indice = new ArrayList<>();

    public int[][] getMatrizDistancias() {
        return this.matrizDistancias;
    }



    public LeitorCSV(){
        criarArrays();
    }

    public void criarArrays(){
        String arquivoCSV = "src/main/java/com/amarelinha/DistanciaCidadesCSV.csv";
        BufferedReader br = null;
        String linha = "";
        int linhaAtual = 0;
        String divisorStringCSV = ";";
        String[] cidades = null;
        String[] conteudoCSV = null;
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = br.readLine()) != null){

                conteudoCSV = linha.split(divisorStringCSV);

                if (cidades == null) {
                    cidades = conteudoCSV;
                    this.matrizDistancias = new int [cidades.length][cidades.length];

                    for (int i  = 0; i < cidades.length; i++){
                        indice.add(cidades[i]);
                    }
                }else {
                    for (int i = 0; i < conteudoCSV.length;i++){
                        // o contador i vai representar as colunas
                        this.matrizDistancias[linhaAtual][i] = Integer.parseInt(conteudoCSV[i]);

                    }
                    linhaAtual++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //tranforma a String da cidade informada pelo usuário em um int que serve como indice para localizar as distancias na matriz
    public int pegaDistancia(String cidade1, String cidade2) {
        int indiceCidade1;
        if (this.indice.contains(cidade1) && this.indice.contains(cidade2)) {
            indiceCidade1 = this.indice.indexOf(cidade1);
            int indiceCidade2 = this.indice.indexOf(cidade2);
            return this.matrizDistancias[indiceCidade1][indiceCidade2];

        } else {
            return 0;
        }

    }

    public void listarCidades(){
        int itensPorLinha = 8;

        System.out.println("LISTA DE CIDADES:");
        System.out.println("_____________________________________________________________________________________________________");

        for (int i = 0; i < this.indice.size(); i++){
            System.out.print(" |" + this.indice.get(i) + "|");
            if ((i + 1) % itensPorLinha == 0) {
                System.out.println();
            }
        }
        System.out.println("_____________________________________________________________________________________________________");
    }

    public boolean verificaCidade(String cidade){
        return this.indice.contains(cidade);
    }



}