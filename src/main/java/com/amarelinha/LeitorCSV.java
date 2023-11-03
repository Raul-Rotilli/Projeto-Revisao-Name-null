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
        return matrizDistancias;
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

}