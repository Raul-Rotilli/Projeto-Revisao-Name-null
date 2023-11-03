package com.amarelinha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeitorCSV {
    private int[][] matrizDistancias;
    public HashSet<String> indice = new HashSet<>();

    public void run(){
        String arquivoCSV = "src/main/java/com/amarelinha/DistanciaCidadesCSV.csv";
        BufferedReader br = null;
        String linha = "";
        int linhaAtual = 0;
        String divisorStringCSV = ";";

        String[] cidades = null;
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null){

                cidades = linha.split(divisorStringCSV);
                System.out.println("Nome:" + cidades[cidades.length-24]);
                if (cidades == null) {
                    matrizDistancias = new int [cidades.length][cidades.length];
                }

                for (int i  = 0; cidades.length <= 24; i++){

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
